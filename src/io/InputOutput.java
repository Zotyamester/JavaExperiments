package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputOutput {
    public static void task1() throws IOException {
        FileReader fileReader = new FileReader("neptun.txt");
        BufferedReader br = new BufferedReader(fileReader);

        String line = null;
        while ((line = br.readLine()) != null) {
            String neptun = line.substring(line.indexOf('(') + 1, line.indexOf(')'));
            System.out.println(neptun);
        }

        br.close();
    }
}
