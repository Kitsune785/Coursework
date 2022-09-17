package ru.netology.date;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import ru.netology.page.CardPage;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLHelper {
    private static final QueryRunner runner = new QueryRunner();

    private SQLHelper() {
    }

    @SneakyThrows
    private static Connection getConn() {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }

    @SneakyThrows
    public static void getResponseFromDB() {
        var creditAllSQL = "SELECT * FROM credit_request_entity;";
        var creditApprovedSQL = "SELECT id FROM credit_request_entity WHERE status = 'APPROVED';";
        var paymentAllSQL = "SELECT * FROM payment_entity;";
        var paymentDeclineSQL = "SELECT id FROM payment_entity WHERE status = 'DECLINED';";
        try (
                var conn = getConn()
        ) {
            var result1 = runner.query(conn, creditAllSQL, new BeanListHandler<>(CardPage.class));
            var result2 = runner.query(conn, creditApprovedSQL, new BeanListHandler<>(CardPage.class));
            var result3 = runner.query(conn, paymentAllSQL, new BeanListHandler<>(CardPage.class));
            var result4 = runner.query(conn, paymentDeclineSQL, new BeanListHandler<>(CardPage.class));
            System.out.println(result1);
            System.out.println(result2);
            System.out.println(result3);
            System.out.println(result4);
        }
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var conn = getConn();
        runner.execute(conn, "DELETE FROM credit_request_entity");
        runner.execute(conn, "DELETE FROM order_entity");
        runner.execute(conn, "DELETE FROM payment_entity");
    }
}
