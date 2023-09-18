package basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Basics {
    private static boolean oszthato(int osztando, int oszto) {
        return osztando % oszto == 0;
    }

    private static int osztokOsszegeKiveveSzam(int szam) {
        int osztokOsszege = 0; // kivéve, hogy a számot soha nem számítjuk bele, hisz úgy egy tökéletes szám se létezne
        for (int oszto = 1; oszto < szam; oszto++) {
            if (oszthato(szam, oszto)) {
                osztokOsszege += oszto;
            }
        }
        return osztokOsszege;
    }

    private static boolean tokeletes(int szam) {
        int osszeg = osztokOsszegeKiveveSzam(szam);
        return osszeg == szam;
    }

    private static boolean baratsagos(int szam1, int szam2) {
        int osszeg1 = osztokOsszegeKiveveSzam(szam1);
        int osszeg2 = osztokOsszegeKiveveSzam(szam2);
        return osszeg1 == szam2 && osszeg2 == szam1;
    }

    public static void task1() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (tokeletes(i)) {
                System.out.println(i + " tökéletes!");
            }
        }
        sc.close();
    }

    public static void task2() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (baratsagos(i, j)) {
                    System.out.println(i + " és " + j + " barátságosak!");
                }
            }
        }

        sc.close();
    }

    private static int valueOfDecimalInBaseN(String decimal, int n) {
        int value = 0;

        for (int i = 0; i < decimal.length(); i++) {
            value *= n;

            char digit = decimal.charAt(i);
            if (Character.isDigit(digit)) {
                value += digit - '0'; // todo: find more idiomatic (~javatic) way of doing this
            } else if (Character.isLetter(digit)) {
                value += (Character.toUpperCase(digit) - 'A') + 10;
            } else {
                throw new IllegalArgumentException("Expected a string of letters and numbers.");
            }
        }

        return value;
    }

    public static void task3() {
        Scanner sc = new Scanner(System.in);

        String decimal = sc.next();
        int n = sc.nextInt();

        int valueOfDecimal = valueOfDecimalInBaseN(decimal, n);
        System.out.println(decimal + "'s value in base " + n + " is " + valueOfDecimal);

        sc.close();
    }

    public static void task4() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = reader.readLine()).isEmpty()) {
            // System.out.println(line.replace(" ", "")); // not very efficient, but works

            for (int i = 0; i < line.length(); i++) {
                if (!Character.isSpaceChar(line.charAt(i))) {
                    System.out.print(line.charAt(i));
                }
            }
        }

        reader.close();
    }

    private static String decimalInBaseN(int x, int n) {
        StringBuilder builder = new StringBuilder();

        do {
            int digit = x % n;
            if (digit < 10) {
                builder.append((char) (digit + '0'));
            } else if (digit < 36) {
                builder.append((char) ((digit - 10) + 'A'));
            } else {
                throw new IllegalArgumentException("Base N must be between 2 and 35.");
            }
            x /= n;
        } while (x > 0);

        builder.reverse(); // kihasználjuk, hogy a StringBuilder még úgysem összefűzött String-et tárol

        return builder.toString();
    }

    public static void task5() {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int n = sc.nextInt();

        String decimal = decimalInBaseN(x, n);
        System.out.println(x + " in base " + n + " is " + decimal);

        sc.close();
    }
}
