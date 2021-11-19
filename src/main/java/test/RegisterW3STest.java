package test;

import org.testng.annotations.*;
import page.RegisterW3SPage;

public class RegisterW3STest extends BaseTest {

    @Test
    public void test() {
        driver.get("https://www.w3schools.com/");
        RegisterW3SPage reg = new RegisterW3SPage(driver);
        reg.runRegister(reg.getDataFromJsonFile("registerW3S.json", "nhdvnz@gmail.com"));
        System.out.println("-- Done test");
    }

}