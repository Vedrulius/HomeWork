package com.mihey.testpackage;

import java.sql.*;
import java.util.Scanner;

public class TestJDBC {

    public static void main(String[] args) {

        TestJDBC test = new TestJDBC();
        test.open();
        test.insert();
        test.close();
    }

    String url = "jdbc:sqlite:/home/mihey/Sqlite/bank.db";
    Connection co;
    String sql = "CREATE TABLE IF NOT EXISTS card ("
            + "     id INTEGER PRIMARY KEY,"
            + "     number TEXT,"
            + "     pin TEXT,"
            + "     balance INTEGER DEFAULT 0"
            + ");";

    void open() {
        try {
            co = DriverManager.getConnection(url);
            System.out.println("Connection is valid.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    void insert()  {
        try {
            Scanner sc = new Scanner(System.in);
            String card = sc.nextLine();
            String pin = sc.nextLine();
            String table = "CREATE TABLE IF NOT EXISTS card ("
                    + "     id INTEGER PRIMARY KEY,"
                    + "     number TEXT,"
                    + "     pin TEXT,"
                    + "     balance INTEGER DEFAULT 0"
                    + ");";
            String query = "insert into card (number, pin) values ('" + card + "','" + pin + "')";
            Statement st = co.createStatement();
            st.executeUpdate(table);
            System.out.println("table added");

            st.executeUpdate(query);
            System.out.println("rows added");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void close() {
        try {
            co.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

