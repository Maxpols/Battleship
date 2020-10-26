import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;

        byte[] bytes = new byte[40];
        int numberOfBytes = inputStream.read(bytes);
//        System.out.println(numberOfBytes);

        for (byte i = 0; i < numberOfBytes; i++) {
            if (bytes[i] > 31) {
                System.out.printf("%d", bytes[i]);
            } else {
                break;
            }
        }

    }
}