package com.Repository;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository("localhost:3306", "root", "","mypenelopef");
        String query = "SELECT * FROM `test`";
        ResultSet resultSet = repository.exec(query);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    int coucou = resultSet.getInt("coucou");
                    System.out.println(coucou);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("null");
        }
/*

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypenelopef?serverTimezone=UTC", "root", "");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM `test`");

            //System.out.println(rs.getString(0));

        } catch (SQLException e) {
            System.out.println(e);
        }
        */
    }
}