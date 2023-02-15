package chuck_norris_cipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* Chuck methods holds the methods used for main.
*
* @author Krig Raseri (pen name)
* */
public class ChuckMethods {

    /**
     * Checks the input for chuckDecryption to make sure it is valid.
     *
     * @param encoded_message represents the string input to be checked for validity from setEncodedMessage.
     * */
    public boolean isEncodeValid(String encoded_message) {
        boolean isTrue = true;
        String[] arr = encoded_message.split(" ");
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i].equals("0")) {
                    continue;
                }

                else if (arr[i].equals("00")) {
                    continue;
                }

                else {
                    isTrue = false;
                }

            }

            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) != '0') {
                    isTrue = false;
                }

                if (i % 2 != 0) {
                    if (arr[i].charAt(j) == '0') {
                        count++;
                    }
                }

            }

        }

        if (count % 7 != 0) {
            isTrue = false;
        }

        return isTrue;
    }


    /**
     * Asks user input of an encoded string to be used with chuckDecryption.
     * */
    public String setEncodedMessage() {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input encoded string:");
            String encodedMessage = "";

                try {
                    encodedMessage = reader.readLine();

                }

                catch (IOException e) {
                    e.printStackTrace();
             }


         return encodedMessage;
    }



    /**
     * Asks user for a string input to be converted to binary, and then to chuck code.
     * */
    public String setMessage() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input string:");
            char[] input = reader.readLine().toCharArray();
            String binaryMessage = "";

            for (char x : input) {
                String b = String.format("%7s", Integer.toBinaryString(x)).replace(' ', '0');
                binaryMessage += b;
            }
            return binaryMessage;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * Decrypts the entered chuck code of "0"s back to binary, and then back to text.
     *
     * @param chuckMessage represents the user inputted chuck code to be decrypted, which is set by setEncoded message.
     * */
    public void chuckDecryption(String chuckMessage) {
        String[] array = chuckMessage.split(" ");
        int count = 0;
        String message = "";

        //Translates chuck code into an entire binary string.
        while (count < chuckMessage.length() - 1) {
            if (array[count].equals("0")) {
                message += array[count+1].replace("0", "1");
            }

            else {
                message += array[count+1];
            }

            count += 2;
            if (count >= array.length) {
                break;
            }

        }

        //Goes through the binary string and stops every 7 characters to convert binary to ASCII.
        System.out.println("Decoded message:");
        String m = "";
        for (int i = 1; i <= message.length(); i++) {
            m += message.charAt(i-1);

            if (i % 7 == 0) {
                System.out.print((char) (Integer.parseInt(m, 2)));
                m = "";
            }
        }

        System.out.println();

    }



    /**
     * Encrypt's the user inputted message by changing it to binary, and then to chuck code.
     *
     * @param Message represents the string message that is input from user, from setMessage.
     * */
    public void chuckCryption(String Message) {
        int count = 0;
        char[] array = Message.toCharArray();
        char current;

        System.out.println("Encoded message:");
        while (count < Message.length()) {
            if (array[count] == '0') {
                System.out.print("00 ");
                current = '0';
            }

            else {
                System.out.print("0 ");
                current = '1';
            }

            while (array[count] == current) {
                System.out.print("0");
                count++;
                if (count == Message.length()) break;
            }

            if (count < Message.length()) System.out.print(" ");
        }
        System.out.println();
    }
}
