package sample;
import java.sql.*;

public class DataBase {
    Connection conn = null;

    /**
     * Connect to the test.db database
     */
    private void connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/fasee/IdeaProjects/untitled/studentregistration.db";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

//String name,String fname,String address,String phone,String gender,String degree,
//                       String email,String cnic
    public void insert() {
        try {
            connect();
            Statement statement =  conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS \"student\" (\n" +
                    "\t\"ID\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                    "\t\"name\"\tTEXT,\n" +
                    "\t\"fname\"\tTEXT,\n" +
                    "\t\"phone\"\tTEXT,\n" +
                    "\t\"address\"\tTEXT,\n" +
                    "\t\"degree\"\tTEXT,\n" +
                    "\t\"gender\"\tTEXT,\n" +
                    "\t\"email\"\tTEXT,\n" +
                    "\t\"cnic\"\tTEXT\n" +
                    ");");
            statement.execute("INSERT INTO student" +
                    " (name, father name, phone, address, degree, gender, email, cnic)" +
                    String.format(" VALUES (\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',\'%s\',\'%s\');"
                                  ,name,fname,phone,address,degree,gender,email,cnic)
                             );


            statement.execute("INSERT INTO student " +  "(name,fname) "+
                    "VALUES ('faseeh', 'Ahmad');");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
