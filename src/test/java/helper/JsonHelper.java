package helper;

import com.google.gson.Gson;
import factory.EnvironmentFactory;
import model.Product;
import model.User;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonHelper {

    /**
     * Get user data in json file
     * @param fileName
     * @return
     */
    public static User[] getUser(String fileName) {
        String jsonPath = "src/test/resources/files/" + EnvironmentFactory.getEnvironment() + "/" + fileName;
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
     * Get user by email
     * @param fileName
     * @param emailTest
     * @return
     */
    public static User getUserByEmail(String fileName, String emailTest) {
        User[] users = JsonHelper.getUser(fileName);
        for (User user : users) {
            if (user.getEmail().equals(emailTest)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Get user by index
     * @param fileName
     * @param index
     * @return
     */
    public static User getUserByIndex(String fileName, int index) {
        User[] users = JsonHelper.getUser(fileName);
        return users[index];
    }


    // ------------------------------------------------------------------------------------------


    /**
     * Get product data in json file
     * @param fileName
     * @return
     */
    public static Product[] getProduct(String fileName) {
        String jsonPath = "src/test/resources/files/" + EnvironmentFactory.getEnvironment() + "/" + fileName;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(jsonPath));
            Product[] products = gson.fromJson(reader, Product[].class);
            return products;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get product by name
     * @param fileName
     * @param productName
     * @return
     */
    public static Product getProductByName(String fileName, String productName) {
        Product[] products = JsonHelper.getProduct(fileName);
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Get product by index
     * @param fileName
     * @param index
     * @return
     */
    public static Product getProductByIndex(String fileName, int index) {
        Product[] products = JsonHelper.getProduct(fileName);
        return products[index];
    }

}
