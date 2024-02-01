package org.myQueryBuilder.v1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

enum JoinType {
    INNER, LEFT
}


class QueryBuilder {
    private List<String> selectColumns = new ArrayList<>();
    private String fromTable;
    private List<String> joinClauses = new ArrayList<>();
    private String whereCondition;
    private String orderByColumn;
    private String groupByColumn;
    private Connection connection;

    public QueryBuilder select(String... columns) {
        for (String column : columns) {
            selectColumns.add(column);
        }
        return this;
    }

    public QueryBuilder from(String table) {
        this.fromTable = table;
        return this;
    }

    public QueryBuilder where(String condition) {
        this.whereCondition = condition;
        return this;
    }

    public QueryBuilder join(JoinType joinType, String table, String condition) {
        joinClauses.add(String.format("%s JOIN %s ON %s", joinType, table, condition));
        return this;
    }

    public QueryBuilder orderBy(String column) {
        this.orderByColumn = column;
        return this;
    }

    public QueryBuilder groupBy(String column) {
        this.groupByColumn = column;
        return this;
    }

    private void validateQuery() {
        if (fromTable == null) {
            throw new IllegalStateException("FROM clause is mandatory");
        }
    }

    public String build() {
        validateQuery();
        StringBuilder query = new StringBuilder("SELECT ");

        if (selectColumns.isEmpty()) {
            throw new IllegalStateException("SELECT clause is mandatory");
        }

        query.append(String.join(", ", selectColumns))
                .append(" FROM ")
                .append(fromTable);

        if (!joinClauses.isEmpty()) {
            query.append(" ").append(String.join(" ", joinClauses));
        }

        if (whereCondition != null) {
            query.append(" WHERE ").append(whereCondition);
        }

        if (groupByColumn != null) {
            query.append(" GROUP BY ").append(groupByColumn);
        }

        if (orderByColumn != null) {
            query.append(" ORDER BY ").append(orderByColumn);
        }

        return query.toString();
    }



    public QueryBuilder connect(String url, String user, String password) {
        try {
            Properties props = new Properties();
            props.setProperty("user", user);
            props.setProperty("password", password);
            this.connection = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to connect to the database", e);
        }
        return this;
    }

    public ResultSet executeQuery() {
        validateConnection();
        validateQuery();
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(build());
        } catch (SQLException e) {
            throw new RuntimeException("Failed to execute the query", e);
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to close the database connection", e);
        }
    }

    private void validateConnection() {
        if (connection == null) {
            throw new IllegalStateException("Connection to the database is not established");
        }
    }


}


