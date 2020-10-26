import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str;
        while (true) {
            str = s.next();
            if (str.equals("0")) {
                break;
            } else {
                try {
                    System.out.printf("\n%d", Integer.parseInt(str) * 10);
                } catch (Exception e) {
                    System.out.printf("\nInvalid user input: %s", str);
                }
            }

        }
    }
}