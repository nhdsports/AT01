package helper;

import com.google.gson.Gson;
import model.User;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonHelper {

    // Get all data from json file
    public static User[] getJson(String fileName) {
        final String JSON_PATH = "src/main/resources/files/" + fileName;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(JSON_PATH));
            User[] users = gson.fromJson(reader, User[].class);
            return users;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Get data by email from json file
    public static User getDataFromJsonFile(String fileName, String emailTest) {
        User[] users = JsonHelper.getJson(fileName);
        for (User user : users) {
            if (user.getEmail().equals(emailTest)) {
                return user;
            }
        }
        return null;
    }

}
