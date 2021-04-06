package com.carsonlius.share;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "/Users/carsonlius/project/leetcode/src/main/java/com/carsonlius/share/hello.txt";
        try (InputStream inputStream = new FileInputStream(path)){
            byte[] buffer = new byte[15];
            int n;
            while ((n = inputStream.read(buffer)) != -1) {
                System.out.println("read " + n + "bytes");
                for (byte b : buffer) {
                    System.out.println("------------------>" + (char) b);
                }
            }
        }

        try (InputStream fis = new FileInputStream(path)){
            int num = fis.read();
            System.out.println(num);
            num = fis.read();
            System.out.println(num);
            num = fis.read();
            System.out.println(num);
            num = fis.read();
            System.out.println(num);
            num = fis.read();
            System.out.println(num);
            num = fis.read();
            System.out.println(num);
            num = fis.read();
            System.out.println(num);

        }


    }
}
