package com.Repository;

import java.sql.*;

public class Repository {

    private String tool;
    private String url;
    private String name;
    private String user;
    private String pass;
    private Statement statement;

    Repository() {

    }

    Repository(String url, String user, String password, String databaseName){
        this.setUser(user);
        this.setPass(password);
        this.setUrl(url);
        this.setName(databaseName);
        this.setTool("jdbc:mysql:");
    }

    public String getJdbcPath(){
        String sep = "/";
        return getTool()+sep+sep+getUrl()+sep+getName()+"?serverTimezone=UTC";
    }


    private Boolean connect() {
        try {
            Connection connection = DriverManager.getConnection(this.getJdbcPath(), this.getUser(), this.getPass());
            Statement statement = connection.createStatement();
            setStatement(statement);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    public ResultSet exec(String query) {
        if (this.getStatement() == null){
            if (!this.connect()) {
                return null;
            }
        }
        ResultSet resultSet = null;
        System.out.println(this.getStatement());
        System.out.println(query);
        try {
            ResultSet resultSet1 = this.getStatement().executeQuery(query);
            return resultSet1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    private String getName() {
        return name;
    }

    private String getPass() {
        return pass;
    }

    private String getTool() {
        return tool;
    }

    private String getUrl() {
        return url;
    }

    private String getUser() {
        return user;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private void setStatement(Statement statement) {
        this.statement = statement;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
