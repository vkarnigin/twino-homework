package lv.twino.homework.controller;

import lombok.Setter;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import static lv.twino.homework.jooq.Tables.BLACKLIST;

@Setter
public class BlacklistControllerImpl implements BlacklistController {

    private List<String> blacklist;

    private BlacklistControllerImpl() {
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test")) {
            DSLContext dslContext = DSL.using(conn, SQLDialect.H2);
            blacklist = dslContext.selectFrom(BLACKLIST).fetch(BLACKLIST.PERSONAL_ID);
        } catch (Exception e) {
            e.printStackTrace();
            blacklist = new ArrayList<>();
        }
    }

    private static class SingletonHolder {
        private static BlacklistController instance = new BlacklistControllerImpl();
    }

    public static BlacklistController getInstance() {
        return SingletonHolder.instance;
    }

    public boolean isBlacklisted(String personalId) {
        return blacklist.contains(personalId);
    }

}
