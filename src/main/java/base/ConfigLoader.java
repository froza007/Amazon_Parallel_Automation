package base;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigLoader {

    Properties prop;

    public ConfigLoader(){

        try{

            prop = new Properties();

            FileInputStream fis =
                new FileInputStream("config.properties");

            prop.load(fis);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getProperty(String key){

        return prop.getProperty(key);
    }
}
