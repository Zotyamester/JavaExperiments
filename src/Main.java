import io.InputOutput;
import utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void lsdir(File f, String tabs) {
        File[] files = f.listFiles();
        if (files == null)
            return;

        for (int i = 0; i < files.length; i++) {
            System.out.println(tabs + files[i].getName());

            if (files[i].isDirectory()) {
                lsdir(files[i], tabs + " ");
            }
        }
    }

    public static class Boo {
        private int x = 0;

        public Boo(int x) {
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*lsdir(new File("." + File.separator + "src"), "");

        try (
                InputStreamReader isr = new InputStreamReader(System.in);
        ) {
            int status;
            while ((status = isr.read()) != -1) {
                char character = (char) status;
                System.out.println("Next: " + character);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // No need to add finally or anything here really.
        // The cool thing about Java 7 SE's try-with-resources statements
        // is that it alleviates your from unnecessarily verbose
        // finally { streamOrReader.close(); } blocks.
        // It's worth noting, that this whole thing wasn't needed
        // in C++ tho. because it had RAII to take care of
        // freeing up unused resources, but with Garbage Collecting
        // things are not quite as easy.
        // C# also has a similar to try-with-resources with using blocks.

        try (
                PrintWriter pw = new PrintWriter(new FileWriter("hello.txt"));
        ) {
            pw.println("Hello, World!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        Boo[] arr = new Boo[2]; // ez ugyanúgy refernciát tárol, mint a sima "Boo boo;", és a "new Akármi[]" csak
        // egy referenciákból álló tömböt hoz létre, majd azt inicializálja nullára (ergo a benne lévő elemek,
        // a refernciák, ki lesznek nullázva, tehát nem kapnak allokált heap-területet külön tényleges objektumok).
        System.out.println(arr[0]);
    }
}
