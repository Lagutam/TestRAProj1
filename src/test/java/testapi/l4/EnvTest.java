package testapi.l4;

import config.ConfigReader;

//import org.testng.annotations.Test;

public class EnvTest {
    
    public static void main(String[] args) {
        System.out.println("API_TOKEN = " + ConfigReader.getToken());
    }
}