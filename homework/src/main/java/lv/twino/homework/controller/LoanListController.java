package lv.twino.homework.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lv.twino.homework.domain.LoanRequisition;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import static lv.twino.homework.domain.tables.LoanRequisition.LOAN_REQUISITION;

public class LoanListController {

    public static String listApprovedLoans() {
        Gson gson = new GsonBuilder()
                .setDateFormat("dd.MM.yyyy").create();
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
            DSLContext dslContext = DSL.using(conn, SQLDialect.H2);
            List<LoanRequisition> dataset = dslContext.selectFrom(LOAN_REQUISITION)
                    .fetch().into(LoanRequisition.class);
            return gson.toJson(dataset);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
