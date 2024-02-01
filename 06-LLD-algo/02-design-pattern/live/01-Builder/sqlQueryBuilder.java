package org.myQueryBuilder.v1;


import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryBuilderMain {
    public static void main(String[] args) {
        String simpleQuery = new QueryBuilder()
                .select("name", "age")
                .from("users")
                .where("age > 30")
                .orderBy("name")
                .build();

        System.out.println("\nSimple Query:\n" + simpleQuery);

        String complexQuery = new QueryBuilder()
                .select("users.name", "COUNT(orders.order_id) as order_count")
                .from("users")
                .join(JoinType.LEFT, "orders", "users.user_id = orders.user_id")
                .where("users.age > 25 AND orders.status = 'Shipped'")
                .groupBy("users.name")
                .orderBy("order_count DESC")
                .build();
        System.out.println("\nComplex Query:\n" + complexQuery);

        //Using DB
        String dbUrl = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";

        // Create a QueryBuilder instance and connect to MySQL
        QueryBuilder queryBuilder = new QueryBuilder().connect(dbUrl, username, password);

        ResultSet resultSet = queryBuilder.executeQuery();
        processResultSet(resultSet);

        // Close the database connection
        queryBuilder.closeConnection();
    }

    private static void processResultSet(ResultSet resultSet) {
        // Process the result set as needed
        try {
            while (true) {
                try {
                    if (!resultSet.next()) break;
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to process the result set", e);
        }
    }

}
