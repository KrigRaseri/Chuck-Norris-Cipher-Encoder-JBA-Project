package chuck_norris_cipher;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChuckMethods {
    public static boolean isEncodeValid(String encoded_message) {
        boolean isTrue = true;
        String[] arr = encoded_message.split(" ");
        int count = 0;
        String current = "";

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


    public static String setEncodedMessage() {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Input encoded string:");
            String encodedMessage = null;

                try {
                    encodedMessage = reader.readLine();

                }

                catch (IOException e) {
                    e.printStackTrace();
             }


         return encodedMessage;
    }









    public static String setBinaryMessage() {
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

    public static void chuckDecryption(String chuckMessage) {
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



    public static void chuckCryption(String binaryMessage) {
        int count = 0;
        char[] array = binaryMessage.toCharArray();
        char current;

        System.out.println("Encoded message:");
        while (count < binaryMessage.length()) {
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
                if (count == binaryMessage.length()) break;
            }

            if (count < binaryMessage.length()) System.out.print(" ");
        }
        System.out.println();
    }



    public static void chuckCipher(String inp) {
        int count = 0;
        char[] arr = inp.toCharArray();
        char current = ' ';
        char prev = arr[0];

        for (char c : arr) {
            current = c;

            if (current != prev && current == '0') {
                //System.out.println(count);
                System.out.print("0 ");
                printX("0", count);
                System.out.print(" ");
                count = 0;
            }

            if (current != prev && current == '1') {
                System.out.print("00 ");
                printX("0", count);
                System.out.print(" ");
                count = 0;
            }


            count++;
            prev = c;


        }

        if (current == '1') {
            System.out.print("0 " );
            printX("0", count);
        }

        if (current == '0') {
            System.out.print("00 " );
            printX("0", count);
        }


    }




    public static void printX(String b, int times) {
        for (int i = 0; i < times; i++) {
            System.out.print(b);
        }
    }
}
