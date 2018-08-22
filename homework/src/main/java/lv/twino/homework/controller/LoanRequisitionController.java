package lv.twino.homework.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lv.twino.homework.domain.dto.LoanRequisitionPayload;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import spark.Request;
import spark.Response;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;

import static lv.twino.homework.domain.tables.LoanRequisition.LOAN_REQUISITION;

public class LoanRequisitionController {

    public static Response requestLoan(Request req, Response res) {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy").create();
        LoanRequisitionPayload payload = gson.fromJson(req.body(), LoanRequisitionPayload.class);
        if (BlacklistController.isApproved(payload.getPersonalId())) {

            String countryCode = GeolocationController.getCountryCode(req.ip()).orElse("LV");

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
