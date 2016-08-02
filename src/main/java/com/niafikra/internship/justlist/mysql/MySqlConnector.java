package com.niafikra.internship.justlist.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by lilianngweta on 6/27/16.
 */
public class MySqlConnector {


        public static Connection conn = null;

        private static void loadDriver() {
            try {

                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception ex) {

            }
        }


        public static Connection getConnection() {
            try

            {
                if(conn==null) {
                    loadDriver();
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todos?user=root&password=gr8stuff");
                }


            } catch (SQLException ex)

            {

                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }

            return conn;

        }

        public static void close() {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            conn=null;

        }
    }





