import java.util.Scanner;

public class Main {

    public static String prepareFullName(String firstName, String lastName) {
        if (firstName == null) {
            return String.format("%s", lastName);
        } else if (lastName == null) {
            return String.format("%s", firstName);
        } else {
            return String.format("%s %s", firstName, lastName);
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        firstName = "null".equals(firstName) ? null : firstName;

        String lastName = scanner.nextLine();
        lastName = "null".equals(lastName) ? null : lastName;

        System.out.println(prepareFullName(firstName, lastName));
    }
}