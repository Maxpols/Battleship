import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static int[] getFirstAndLast(int[] result) {
        int[] array = new int[2];

        array[0] = result[0];
        array[1] = result[Array.getLength(result) -1];

        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}