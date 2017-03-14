package com.pamokos.db.atvaizdavimas;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

public class Atvaizdavimas {
    private Connection connection;

    public Atvaizdavimas() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kcs",
                    "root",
                    "");
        } catch (Exception arror) {
        }
    }

    public void pasisveijkinimas() {
        System.out.println("Sveijki pasirinkite lentele");
    }

    public void paklausk() {
        System.out.println("Kure lentele norite pamatyti");
        System.out.println("Studentai  1");
        System.out.println("Pazymei  2");
        System.out.println("Adresiai  3");

    }

    public void nuspresk() {
        Scanner sc = new Scanner(System.in);
        int pasirinkimas = sc.nextInt();
        switch (pasirinkimas) {
            case 1:
                lentele1();
                break;
            case 2:
                lentele2();
                break;
            case 3:
                lentele3();
                break;
        }
    }

    public void lentele1() {
        System.out.println("Pasirinkote studentai 1");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `studentas`");
            while (resultSet.next()) {
                System.out.print("|");
                System.out.print(resultSet.getInt("S_id"));
                System.out.print("|");
                System.out.print(resultSet.getString("name"));
                System.out.print("|");
                System.out.print(resultSet.getString("name"));
                System.out.print("|");
                System.out.print("|");
                System.out.println(" ");
            }
        } catch (Exception error) {
            System.out.println(error);
        }
    }

    public void lentele2() {

    }

    public void lentele3() {
        System.out.println("Pasirinkote Adresus");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `studentas_addres`");
            while (resultSet.next()) {
                System.out.print("  ");
                System.out.print(resultSet.getString("country"));
                System.out.print(" ");
                System.out.print(resultSet.getString("city"));
                System.out.print(" ");
                System.out.print(resultSet.getString("street"));
                System.out.print(" ");
                System.out.print(resultSet.getInt("id"));
                System.out.print(" ");
                System.out.print(resultSet.getInt("studentas_id"));
                System.out.println(" ");
            }
        } catch (Exception error) {
            System.out.println(error);
        }
    }
}

