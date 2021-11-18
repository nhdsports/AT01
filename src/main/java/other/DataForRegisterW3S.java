package other;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataForRegisterW3S {

    protected final int INDEX_USER = 0;
    protected String FILE_PATH = "D:\\zProgram\\IntelliJ IDEA Community Edition 2021.2.3\\IdeaProjects\\BT-Automation\\src\\main\\files\\registerW3S.json";
    protected String email;
    protected String password;
    protected String firstName;
    protected String lastName;
    public List list = new ArrayList();

    public DataForRegisterW3S() {}

    public DataForRegisterW3S(String email, String password, String firstName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void convertJsonToObj() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
            DataForRegisterW3S[] obj = gson.fromJson(reader, DataForRegisterW3S[].class);
            list.add(obj[INDEX_USER].email);
            list.add(obj[INDEX_USER].password);
            list.add(obj[INDEX_USER].firstName);
            list.add(obj[INDEX_USER].lastName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
