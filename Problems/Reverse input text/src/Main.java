import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            char[] charArray = new char[50];
            reader.read(charArray);
            for (int i = charArray.length -1; i > -1; i--) {
                if (charArray[i] != 0) {
                    System.out.printf("%c", charArray[i]);
                } else {
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.printf("Exception occurred in I/O: %s", e.getMessage());
        } catch (Exception e) {
            System.out.printf("exception occurred %s ", e.getMessage());
        }

        reader.close();
    }
}