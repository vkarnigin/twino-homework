package lv.twino.homework.config;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LocalDatabaseConfiguration {

    public static void setup() {
        try {
            Server.createTcpServer().start();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test");
             Statement stat = conn.createStatement()) {

            stat.execute("drop table if exists loan_requisition");
            stat.execute("drop table if exists blacklist");

            stat.execute("create table if not exists loan_requisition(id int auto_increment primary key, name varchar(255), surname varchar(255), personal_id varchar(15), term DATE, loan_amount NUMBER, country_code varchar(3))");
            stat.execute("create table if not exists blacklist(personal_id varchar(15) primary key)");
            stat.execute("insert into blacklist values ('123-456')");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
