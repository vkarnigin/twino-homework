package lv.twino.homework.controller;

import lombok.Setter;
import lv.twino.homework.domain.dto.LoanRequisitionPayload;
import lv.twino.homework.util.GsonConverter;
import lv.twino.homework.util.GsonConverterImpl;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import spark.Response;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

import static lv.twino.homework.jooq.Tables.LOAN_REQUISITION;

@Setter
public class LoanRequisitionController {

    private GeolocationController geolocationController;
    private BlacklistController blacklistController;
    private GsonConverter gsonConverter;

    private LoanRequisitionController() {
        geolocationController = GeolocationControllerImpl.getInstance();
        blacklistController = BlacklistControllerImpl.getInstance();
        gsonConverter = GsonConverterImpl.getInstance();
    }

    private static class SingletonHolder {
        private static LoanRequisitionController instance = new LoanRequisitionController();
    }

    public static LoanRequisitionController getInstance() {
        return SingletonHolder.instance;
    }

    public Response requestLoan(String requestBody, String callerIp, Response res) {

        LoanRequisitionPayload payload = gsonConverter.convertFromJson(requestBody, LoanRequisitionPayload.class);

        if (!blacklistController.isBlacklisted(payload.getPersonalId())) {

            String countryCode = geolocationController.getCountryCode(callerIp);

            try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
                DSLContext dslContext = DSL.using(conn, SQLDialect.H2);
                dslContext.insertInto(LOAN_REQUISITION,
                        LOAN_REQUISITION.NAME,
                        LOAN_REQUISITION.SURNAME,
                        LOAN_REQUISITION.PERSONAL_ID,
                        LOAN_REQUISITION.LOAN_AMOUNT,
                        LOAN_REQUISITION.TERM,
                        LOAN_REQUISITION.COUNTRY_CODE)
                        .values(payload.getName(), payload.getSurname(), payload.getPersonalId(), payload.getLoanAmount(), new Date(payload.getTerm().getTime()), countryCode)
                        .execute();
                res.status(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            res.status(403);
            res.body("That personal ID is blacklisted, request declined");
        }
        return res;
    }

}
