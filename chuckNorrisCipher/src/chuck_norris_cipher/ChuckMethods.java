package chuck_norris_cipher;

public class ChuckMethods {
    public static void chuckCryption(String binaryMessage) {
        int count = 0;
        char[] array = binaryMessage.toCharArray();
        char current;

        while (count < binaryMessage.length())
        {
            if (array[count] == '0')
            {
                System.out.print("00 ");
                current = '0';
            }
            else
            {
                System.out.print("0 ");
                current = '1';
            }

            while (array[count] == current)
            {
                System.out.print("0");
                count++;
                if (count == binaryMessage.length()) break;
            }

            if (count < binaryMessage.length()) System.out.print(" ");
        }
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
