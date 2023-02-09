package chuck_norris_cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //The biggest buffest reader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input string:");
        String[] input = reader.readLine().split("");


        for (String x : input) {
            System.out.print(x + " ");
        }

    }
}
