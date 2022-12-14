package com.org.homework.firsttask.application;

import com.org.homework.firsttask.cryptedstream.CryptedInputStream;
import com.org.homework.firsttask.cryptedstream.CryptedOutputStream;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String str;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input string: ");
            str = scanner.nextLine();
        }
        int key = (int) (Math.random() * 8);
        byte[] buffer = str.getBytes();
        byte[] resultBuffer = new byte[buffer.length];

        try (OutputStream out = new FileOutputStream("notes.txt");
             OutputStream cos = new CryptedOutputStream(out, key)) {
            cos.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (InputStream bis = new BufferedInputStream(new FileInputStream("notes.txt"));
             InputStream cis = new CryptedInputStream(bis, key)) {

            cis.readNBytes(resultBuffer, 0, resultBuffer.length);

            for (byte element : resultBuffer) {
                System.out.print((char) element);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
