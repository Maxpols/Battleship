import java.util.*;

class FixingStringIndexOutOfBoundsException {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        int lengthString = string.length();
        int index = scanner.nextInt();
        if (index < 0 || index > lengthString - 1) {
            System.out.println("Out of bounds!");
        } else {
            System.out.println(string.charAt(index));}

    }
}