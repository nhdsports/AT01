package helper;

import com.google.gson.Gson;
import model.User;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonHelper {

    /**
     * Get all data in json file
     * @param environmentName
     * @param fileName
     * @return
     */
    public static User[] getJson(String environmentName, String fileName) {
        String jsonPath = "src/test/resources/files/" + environmentName + "/" + fileName;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(jsonPath));
            User[] users = gson.fromJson(reader, User[].class);
            return users;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get data by email
     * @param environmentName
     * @param fileName
     * @param emailTest
     * @return
     */
    public static User getDataByEmail(String environmentName, String fileName, String emailTest) {
        User[] users = JsonHelper.getJson(environmentName, fileName);
        for (User user : users) {
            if (user.getEmail().equals(emailTest)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Get data by index
     * @param environmentName
     * @param fileName
     * @param index
     * @return
     */
    public static User getDataByIndex(String environmentName, String fileName, int index) {
        User[] users = JsonHelper.getJson(environmentName, fileName);
        return users[index];
    }

}
