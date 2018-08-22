package lv.twino.homework.controller;

import lv.twino.homework.domain.dto.LoanRequisitionPayload;
import lv.twino.homework.domain.tables.Blacklist;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import static lv.twino.homework.domain.Tables.BLACKLIST;

public class BlacklistController {

    private static List<String> blacklist = new ArrayList<>();

    public static void loadCache() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
            DSLContext dslContext = DSL.using(conn, SQLDialect.H2);
            blacklist = dslContext.selectFrom(BLACKLIST).fetch(BLACKLIST.PERSONAL_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean isApproved(String personalId) {
        return !blacklist.contains(personalId);
    }

}
