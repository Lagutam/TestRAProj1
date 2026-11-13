package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private ConfigReader(){
        //to avoid object creation
    }

    public static String getToken(){
        try {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:\\Users\\sharm\\vscode\\TestRAProj1\\src\\test\\resources\\config.properties"));
        
        String token = prop.getProperty("API_TOKEN");
        //System.out.println(token);
        if(token==null || token.isBlank()){
            throw new RuntimeException("API_Token not set.");
        }
        return token;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
