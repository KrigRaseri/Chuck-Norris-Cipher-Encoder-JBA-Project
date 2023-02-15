package chuck_norris_cipher;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
* Program that asks for user to choose encode, or decode. Encode takes a string input to convert to binary, and then to
* chuck code (refer to readme for more info). Decode decrypts the chuck code back into regular text. Type exit to
* end the program.
*
* @author Krig Raseri (pen name)
* */
public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ChuckMethods cm = new ChuckMethods();

        while (true) {

            System.out.println("Please input operation (encode/decode/exit):");

            try {
                String input = reader.readLine();

                if (input.equals("exit")) {
                    System.out.println("Bye!");
                    break;
                }

                else if (input.equals("encode")) {
                    cm.chuckCryption(cm.setMessage());

                }

                else if (input.equals("decode")) {
                    String encodeInp = cm.setEncodedMessage();

                    if (!cm.isEncodeValid(encodeInp)) {
                        System.out.println("Encoded string is not valid.");
                        System.out.println();
                        continue;
                    }

                    cm.chuckDecryption(encodeInp);
                }

                else {
                    System.out.println("There is no '" + input + "' operation");
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}