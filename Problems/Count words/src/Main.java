import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        System.out.println(reader.read());
        int numberOfWords = 0;
        boolean word;

        do {
            int charCode = reader.read();
            if (charCode > 32) {
                numberOfWords++;
                word = true;
                while (word) {
                    if (reader.read() <= 32) {
                        word = false;
                        break;
                    }
                }
            }
        } while (reader.read() != -1);
        System.out.printf("%d", numberOfWords);
        reader.close();
    }
}