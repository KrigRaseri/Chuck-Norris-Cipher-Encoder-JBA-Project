package chuck_norris_cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            System.out.println("Please input operation (encode/decode/exit):");
            try {
                String input = reader.readLine();

                if (input.equals("exit")) {
                    System.out.println("Bye!");
                    break;
                }

                else if (input.equals("encode")) {
                    ChuckMethods.chuckCryption(ChuckMethods.setBinaryMessage());

                }

                else if (input.equals("decode")) {
                    String encodeInp = ChuckMethods.setEncodedMessage();

                    if (!ChuckMethods.isEncodeValid(encodeInp)) {
                        System.out.println("Encoded string is not valid.");
                        System.out.println();
                        continue;
                    }

                    ChuckMethods.chuckDecryption(encodeInp);
                }

                else {
                    System.out.println("There is no '" + input + "' operation");
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}