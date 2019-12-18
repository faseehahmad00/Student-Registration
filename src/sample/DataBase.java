package sample;
import java.sql.*;

public class DataBase {
    Connection conn = null;

    /*
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

//
    public void insert(String name,String fname,String address,String phone,String gender,String degree,
                       String email,String cnic,String DOB) throws SQLException {
        try {
            connect();
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS\"student\" (\n" +
                    "\t\"name\"\tTEXT,\n" +
                    "\t\"fname\"\tTEXT,\n" +
                    "\t\"phone\"\tTEXT,\n" +
                    "\t\"address\"\tTEXT,\n" +
                    "\t\"degree\"\tTEXT,\n" +
                    "\t\"gender\"\tTEXT,\n" +
                    "\t\"email\"\tTEXT,\n" +
                    "\t\"cnic\"\tTEXT NOT NULL UNIQUE,\n" +
                    "\t\"DOB\"\tTEXT,\n" +
                    "\tPRIMARY KEY(\"cnic\")\n" +
                    "););");
            statement.execute("INSERT INTO student" +
                    " (name, fname , phone, address , degree , gender , email , cnic , DOB )" +
                    String.format(" VALUES ('%s','%s','%s','%s','%s','%s','%s','%s','%s');"
                            , name, fname, phone, address, degree, gender, email, cnic, DOB));

//             statement.execute("INSERT INTO student " +  "(name,fname) "+
//                     "VALUES ('faseeh', 'Ahmad');");

        } catch (SQLException e) {
            System.out.println("The student details were not added to database.Make sure to enter all details correctly");
        }

    }
        public void delete(String cnic) {
        connect();
            try {
                Statement statement =  conn.createStatement();
                statement.execute("DELETE FROM student WHERE cnic= "+cnic);
            } catch (SQLException e) {
                System.out.println("unable to remove student");;
            }

        }

        public void display()
        {
            connect();
            try {
                Statement statement = conn.createStatement();
                statement.execute("SELECT name,fname FROM student WHERE cnic=3620276175649 ");
                System.out.println("name");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

}
