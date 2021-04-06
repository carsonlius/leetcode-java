package com.carsonlius.share;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class OutStringTest {
    public static void main(String[] args) throws IOException {
        String path = "/Users/carsonlius/project/leetcode/src/main/java/com/carsonlius/share/hello.txt";
        try (OutputStream outputStream = new FileOutputStream(path, true)){
            outputStream.write("Hello,Carsonlius".getBytes(StandardCharsets.UTF_8));
            outputStream.write("Hello,Liusen".getBytes(StandardCharsets.UTF_8));
        }
    }
}
