package sample;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {
    Connection conn = null;

    /*
     * Connect to the test.db database
     */
    private void connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:studentregistration.db";
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String name,String fname,String address,String phone,String gender,String degree,
                       String email,String cnic,String DOB){
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
            statement.close();

        } catch (SQLException e) {
            System.out.println("The student details were not added to database.Make sure to enter all details correctly");
        }
    }
        public void delete(String cnic) {
        connect();
            try {
                Statement statement =  conn.createStatement();
                statement.execute("DELETE FROM student WHERE cnic= "+cnic);
                statement.close();
            } catch (SQLException e) {
                System.out.println("unable to remove student");
            }

        }

        public ArrayList<String> display(String cnic)
        {
            ArrayList<String> arr = new ArrayList<>();
            connect();
            try {
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("SELECT name,fname,phone,address,degree,gender,email,cnic,DOB"
                        + " FROM student WHERE cnic=" + cnic + ";");
                    arr.add(rs.getString("name"));
                    arr.add(rs.getString("fname"));
                    arr.add(rs.getString("phone"));
                    arr.add(rs.getString("address"));
                    arr.add(rs.getString("degree"));
                    arr.add(rs.getString("gender"));
                    arr.add(rs.getString("email"));
                    arr.add(rs.getString("cnic"));
                    arr.add(rs.getString("DOB"));
                    statement.close();
            } catch (SQLException ignored) {
            }
            return arr;
        }
        public void closeDB(){
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("unable to close DB");
            }
        }

}
