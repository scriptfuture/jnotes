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

                obj.put("id", rs.getString("id"));
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

    public JSONObject getOneTag(int id) {
        JSONObject obj = new JSONObject();

        try {

            PreparedStatement stat = connection.prepareStatement("select * from tags where id = ?");
            stat.setInt(1, id);

            ResultSet rs = stat.executeQuery();


            if (rs.next()) {

                obj.put("id", rs.getString("id"));
                obj.put("name", rs.getString("name"));

            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }


        return obj;
    }


    private JSONArray getNoteTags(int id) {

        JSONArray arr = new JSONArray();
        int count = 0;

        try {

            PreparedStatement stat = connection.prepareStatement("select tags.id AS id, tags.name AS name from tag_note, tags WHERE tag_id = tags.id AND note_id = ? ORDER BY name ASC");
            stat.setInt(1, id);

            ResultSet rs = stat.executeQuery();

            while (rs.next()) {

                JSONObject obj;
                obj = new JSONObject();

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
        return getPageNotes(1);
    }

    public String getPageNotes(int page) {


        JSONArray arr = new JSONArray();
        int count = 0;

        try {

            int offset = page * 10 - 10;

            PreparedStatement stat = connection.prepareStatement("select * from notes  ORDER BY id DESC LIMIT 10 OFFSET ?");
            stat.setInt(1, offset);

            ResultSet rs = stat.executeQuery();

            getJSONNotes(arr, rs);

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

    public String getTag(int id) {
        return getPageTag(id, 1);
    }

    public String getPageTag(int id, int page) {


        JSONArray arr = new JSONArray();
        int count = 0;

        try {

            int offset = page * 10 - 10;

            PreparedStatement stat = connection.prepareStatement("select notes.id as id, notes.title as title, notes.text as text from tag_note, notes WHERE  tag_id = ?  AND notes.id =  note_id  ORDER BY notes.id DESC LIMIT 10 OFFSET ?");
            stat.setInt(1, id);
            stat.setInt(2, offset);

            ResultSet rs = stat.executeQuery();

            getJSONNotes(arr, rs);

            PreparedStatement stat2 = connection.prepareStatement("select COUNT(*) from tag_note WHERE tag_id = ?");
            stat2.setInt(1, id);

            ResultSet rs2 = stat2.executeQuery();
            while(rs2.next()){
                count = rs2.getInt("count");
            }



        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            return null;

        }


        JSONObject container = new JSONObject();

        container.put("tag", getOneTag(id));
        container.put("totalPages", count);
        container.put("notes", arr);


        return container.toString();
    }

    private void getJSONNotes(JSONArray arr, ResultSet rs) throws SQLException {
        while (rs.next()) {

            JSONObject obj = new JSONObject();

            obj.put("id", rs.getInt("id"));
            obj.put("title", rs.getString("title"));
            obj.put("text", rs.getString("text"));
            obj.put("tags", getNoteTags(rs.getInt("id")));

            arr.put(obj);

        }
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

    public void insertTag(String name, int id) {

        int tid = 0;


        try {

            // проверяем есть ли запись в таблице тегов по имени
            PreparedStatement stat = connection.prepareStatement("select id from tags where name = ?");
            stat.setString(1, name);

            ResultSet rs = stat.executeQuery();

            // Если есть возвращаем id
            if(rs.next()) {
                tid = rs.getInt("id");

                System.out.println("___tit__: "+tid);
            } else {

                // если нет, сохраняем  тег в таблице тегов
                PreparedStatement st2 = connection.prepareStatement("INSERT INTO tags (name)  VALUES (?) RETURNING id;");
                st2.setString(1, name);
                ResultSet rs2 = st2.executeQuery();

                // и возвращаем id
                if(rs2.next()){
                    tid = rs2.getInt("id");
                }

            } // end if

            // сохраняем связки тегов
            PreparedStatement st3 = connection.prepareStatement("INSERT INTO tag_note (tag_id, note_id)  VALUES (?, ?);");
            st3.setInt(1, tid);
            st3.setInt(2, id);
            st3.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void putTags(int id, String tags) {

        try {

            // удаляем тег из таблицы связок
            PreparedStatement st = connection.prepareStatement("DELETE FROM tag_note WHERE note_id = ?");
            st.setInt(1, id);
            st.execute();

            for (String str : tags.split(",")) {

                // добавляем тег в таблицу тегов и связок
                insertTag(str.trim().toLowerCase(), id);
            }

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();


        }

    }


    public String newNote(String title, String text, String tags) {


        JSONObject container = new JSONObject();
        int nid = 0;

        try {

            PreparedStatement st = connection.prepareStatement("INSERT INTO notes (title, text)\n" +
                    "    VALUES (?, ?) RETURNING id;");
            st.setString(1, title);
            st.setString(2, text);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                nid = rs.getInt("id");
            }

            // сохраняем теги
            putTags(nid, tags);

            container.put("msg", "ok");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

            container.put("msg", "error");

        }


        return container.toString();
    }

    public String updateNote(int id, String title, String text, String tags) {


        JSONObject container = new JSONObject();

        try {

            PreparedStatement st = connection.prepareStatement("UPDATE notes SET title = ?, text = ? WHERE id = ?");
            st.setString(1, title);
            st.setString(2, text);
            st.setInt(3, id);
            st.execute();

            // сохраняем теги
            putTags(id, tags);

            container.put("msg", "ok");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

            container.put("msg", "error");

        }


        return container.toString();
    }

}
