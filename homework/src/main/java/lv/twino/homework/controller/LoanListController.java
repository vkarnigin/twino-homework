package lv.twino.homework.controller;

import lombok.Setter;
import lv.twino.homework.domain.LoanRequisition;
import lv.twino.homework.util.GsonConverter;
import lv.twino.homework.util.GsonConverterImpl;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static lv.twino.homework.jooq.Tables.LOAN_REQUISITION;

@Setter
public class LoanListController {

    private GsonConverter gsonConverter;

    private LoanListController() {
        gsonConverter = GsonConverterImpl.getInstance();
    }

    private static class SingletonHolder {
        private static LoanListController instance = new LoanListController();
    }

    public static LoanListController getInstance() {
        return SingletonHolder.instance;
    }

    public String listApprovedLoans() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
            DSLContext dslContext = DSL.using(conn, SQLDialect.H2);
            List<LoanRequisition> dataset = dslContext.selectFrom(LOAN_REQUISITION)
                    .fetch().into(LoanRequisition.class);
            return gsonConverter.convertToJson(dataset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
