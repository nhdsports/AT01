package factory;

public class EnvironmentFactory {

    public static ThreadLocal<String> environments = new ThreadLocal<>();

    public static void setEnvironment(String environment) {
        environments.set(environment);
    }

    public static String getEnvironment() {
        return environments.get();
    }
}
