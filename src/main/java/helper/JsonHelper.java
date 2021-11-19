package helper;

import com.google.gson.Gson;
import model.RegisterW3SUserModel;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonHelper {

    public static RegisterW3SUserModel[] getJson(String fileName) {
        final String JSON_PATH = "D:\\zProgram\\IntelliJ IDEA Community Edition 2021.2.3\\IdeaProjects\\BT-Automation\\src\\main\\resources\\files\\" + fileName;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(JSON_PATH));
            RegisterW3SUserModel[] registerW3SUserModels = gson.fromJson(reader, RegisterW3SUserModel[].class);
            return registerW3SUserModels;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
