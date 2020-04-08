package HomeWork2;

import java.io.*;
import java.sql.*;

public class DataBase {

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) throws SQLException {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createTable();
        connection.setAutoCommit(false);
        for(int i=0; i<3; i++)
            insert("Bob"+i, 20+i);
        connection.setAutoCommit(true);
        select();
        disconnect();
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS students (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    name  VARCHAR,\n"
                + "    score INTEGER\n"
                + ");";
        stmt.execute(sql);
    }

    public static void insert(String name, int score) throws SQLException {
        pstmt=connection.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
        pstmt.setString(1, name);
        pstmt.setInt(2, score);
        pstmt.execute();
    }

    public static void insertOrReplace(String name, int score) throws SQLException {
        pstmt=connection.prepareStatement("INSERT OR REPLACE INTO students (name, score) VALUES (?, ?);");
        pstmt.setString(1, name);
        pstmt.setInt(2, score);
        pstmt.execute();
    }

    public static void delete() throws SQLException {
        String sql = "DELETE FROM students;";
        stmt.execute(sql);
    }

    public static void delete(String name) throws SQLException {
        pstmt=connection.prepareStatement("DELETE FROM students WHERE name=?;");
        pstmt.setString(1, name);
        pstmt.execute();
    }

    public static void delete(int id) throws SQLException {
        pstmt=connection.prepareStatement("DELETE FROM students WHERE id=?;");
        pstmt.setInt(1, id);
        pstmt.execute();;
    }

    public static void updateAll(String name, int score) throws SQLException {
        pstmt=connection.prepareStatement("UPDATE students SET name=?, score=?;");
        pstmt.setString(1, name);
        pstmt.setInt(2, score);
        pstmt.execute();
    }

    public static void updateAll(String name) throws SQLException {
        pstmt=connection.prepareStatement("UPDATE students SET name=?");
        pstmt.setString(1, name);
        pstmt.execute();
    }

    public static void updateAll(int score) throws SQLException {
        pstmt=connection.prepareStatement("UPDATE students SET score=?;");
        pstmt.setInt(1, score);
        pstmt.execute();
    }

    public static void update(int id, String name, int score) throws SQLException {
        pstmt=connection.prepareStatement("UPDATE students SET name=?, score=? where id=?;");
        pstmt.setString(1, name);
        pstmt.setInt(2, score);
        pstmt.setInt(3, id);
        pstmt.execute();
    }

    public static void update(int id, String name) throws SQLException {
        pstmt=connection.prepareStatement("UPDATE students SET name=? where id=?");
        pstmt.setString(1, name);
        pstmt.setInt(2, id);
        pstmt.execute();
    }

    public static void update(int id, int score) throws SQLException {
        pstmt=connection.prepareStatement("UPDATE students SET score=? where id=?;");
        pstmt.setInt(1, score);
        pstmt.setInt(2, id);
        pstmt.execute();
    }

    public static void select() throws SQLException {
        String sql = "SELECT id, name, score FROM students";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("score"));
        }
    }

}
