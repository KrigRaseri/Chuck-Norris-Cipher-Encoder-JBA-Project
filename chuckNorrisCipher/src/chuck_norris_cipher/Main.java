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
        String binaryMessage = "";

        System.out.println("\nThe result:");
        for (char x : input) {
            String b = String.format("%7s", Integer.toBinaryString(x)).replace(' ', '0');
            binaryMessage += b;
            //System.out.printf("%s = %s\n", x, b);
        }

        //ChuckMethods.chuckCryption(binaryMessage);
        ChuckMethods.chuckDecryption(binaryMessage);


    }





    //===================================================================================
}
