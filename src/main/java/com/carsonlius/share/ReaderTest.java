package com.carsonlius.share;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class ReaderTest {
    public static void main(String[] args) throws IOException {
        String path = "/Users/carsonlius/project/leetcode/src/main/java/com/carsonlius/share/hello.txt";
        try(Reader reader = new FileReader(path, StandardCharsets.UTF_8)){
            char[] chars = new char[1];

            while (reader.read(chars) != -1) {
                System.out.println(chars);
            }
        }

        FileReader fr = new FileReader(path);
        int len = 0;
        while ((len = fr.read()) != -1) {
            System.out.println((char) len);
        }
    }
}
