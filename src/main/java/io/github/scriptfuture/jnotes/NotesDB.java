package io.github.scriptfuture.jnotes;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class NotesDB {

    private Connection connection = null;

    public NotesDB(){

        System.out.println("-------- PostgreSQL "
                + "JDBC Connection Testing ------------");

        try {

            Class.forName("org.postgresql.Driver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your PostgreSQL JDBC Driver? "
                    + "Include in your library path!");
            e.printStackTrace();

        }

        System.out.println("PostgreSQL JDBC Driver Registered!");

        try {

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/notes", "postgres",
                    "postgres");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

    }

    public String getNote(int id) {
        JSONObject obj = new JSONObject();

        try {

            PreparedStatement stat = connection.prepareStatement("select * from notes where id = ?");
            stat.setInt(1, id);

            ResultSet rs = stat.executeQuery();


            if (rs.next()) {

                obj.put("title", rs.getString("title"));
                obj.put("text", rs.getString("text"));

            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }


        return obj.toString();
    }


    private JSONArray getNoteTags(int id) {

        JSONArray arr = new JSONArray();
        int count = 0;

        try {

            PreparedStatement stat = connection.prepareStatement("select tags.id AS id, tags.name AS name from tag_note, tags WHERE tag_id = tags.id AND note_id = ? ORDER BY name ASC");
            stat.setInt(1, id);

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {

                JSONObject obj = new JSONObject();

                obj.put("id", rs.getInt("id"));
                obj.put("name", rs.getString("name"));

                arr.put(obj);

            }


        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }

        return arr;

    }

    public String getNotes() {


        JSONArray arr = new JSONArray();
        int count = 0;

        try {
            java.sql.Statement stat = connection.createStatement();

            ResultSet rs = stat.executeQuery("select * from notes  ORDER BY id DESC LIMIT 10");

            while (rs.next()) {

                JSONObject obj = new JSONObject();

                obj.put("id", rs.getInt("id"));
                obj.put("title", rs.getString("title"));
                obj.put("text", rs.getString("text"));
                obj.put("tags", getNoteTags(rs.getInt("id")));

                arr.put(obj);

            }

            java.sql.Statement stat2 = connection.createStatement();
            ResultSet rs3 = stat2.executeQuery("SELECT COUNT(*) FROM notes AS count");
            while(rs3.next()){
                count = rs3.getInt("count");
            }



        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }


        JSONObject container = new JSONObject();

        container.put("totalPages", count);
        container.put("notes", arr);


        return container.toString();
    }

    public String getTags() {
        JSONArray arr = new JSONArray();

        int count = 0;

        try {
            java.sql.Statement stat = connection.createStatement();

            ResultSet rs = stat.executeQuery("select * from tags  ORDER BY id ASC");


            while (rs.next()) {

                JSONObject obj = new JSONObject();
                obj.put("id", rs.getInt("id"));
                obj.put("name", rs.getString("name"));

                arr.put(obj);

            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }


        JSONObject container = new JSONObject();
        container.put("tags", arr);

        return container.toString();
    }

    public String removeNote(int id) {


        JSONObject container = new JSONObject();

        try {

            PreparedStatement st = connection.prepareStatement("DELETE FROM notes WHERE id = ?");
            st.setInt(1, id);
            st.execute();

            container.put("msg", "ok");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

            container.put("msg", "error");

        }


        return container.toString();
    }

}
