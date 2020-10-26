import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void sort(int[] numbers) {
        int length = Array.getLength(numbers);
        if (length > 1) {

            int sorted = 1;
            int lower;

            while (sorted != 0) {
                sorted = 0;
                for (int i = 0; i < length - 1; i++) {
                    if (numbers[i] > numbers[i + 1]) {
                        lower = numbers[i];
                        numbers[i] = numbers[i + 1];
                        numbers[i + 1] = lower;
                        sorted++;
                    }
                }
            }
        }
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        String[] values = scanner.nextLine().split("\\s+");
        int[] numbers = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        sort(numbers);
        Arrays.stream(numbers).forEach(e -> System.out.print(e + " "));
    }
}