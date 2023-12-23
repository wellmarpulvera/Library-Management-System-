/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop2.lms.util;

/**
 *
 * @author Wolfe
 */
import com.oop2.lms.model.User;
import java.io.File;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Session {

    private static final String SESSION_FILE = "session.json";

    public static void setLoggedInUser(int userId, String username, String password, String role) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("user_id", userId);
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        jsonObject.put("role", role);

        try (FileWriter file = new FileWriter(SESSION_FILE)) {
            file.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static User getLoggedInUser() {
        File sessionFile = new File(SESSION_FILE);

        if (!sessionFile.exists()) {
            return null;
        }

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(SESSION_FILE)) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;

            // Extract user details from the JSON object
            Object userIdObj = jsonObject.get("user_id");
            int userId = (userIdObj != null) ? ((Long) userIdObj).intValue() : 0; // Default to 0 if userId is null
            String username = (String) jsonObject.get("username");
            String password = (String) jsonObject.get("password");
            String role = (String) jsonObject.get("role");

            // Ensure other required fields are not null
            if (username != null && password != null && role != null) {
                // Create and return a User object with the retrieved details
                return new User(userId, username, password, role);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void clearSession() {
        // Clear the session file
        try (FileWriter file = new FileWriter(SESSION_FILE)) {
            file.write("{}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
