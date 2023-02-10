package chuck_norris_cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //The biggest buffest reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input string:");
        char[] input = reader.readLine().toCharArray();

        System.out.println("\nThe result:");
        for (char x : input) {
            int m = (int) x;

            String b = String.format("%7s", Integer.toBinaryString((int) x)).replace(' ', '0');
            System.out.printf("%s = %s\n", x, b);
        }


    }
}
