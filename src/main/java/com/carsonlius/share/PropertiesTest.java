package com.carsonlius.share;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("name", "liusen");
        properties.setProperty("age", "29");

        String path = "/Users/carsonlius/project/leetcode/src/main/java/com/carsonlius/share/hello.txt";
        try(Writer writer = new FileWriter(path, true)){
            properties.store(writer, "Config En");
        }
        

    }
}
