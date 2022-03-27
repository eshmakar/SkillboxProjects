import java.util.Arrays;

public class IntegerExperiments {
    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;

        System.out.println(sumDigits(12345));
        System.out.println(sumDigits(10));
        System.out.println(sumDigits(5059191));

    }

    public static Integer sumDigits(Integer number) {
        String[] numbers = number.toString().split("");
        if (numbers.length > 1) {
            return Arrays.stream(numbers)
                    .map(Integer::parseInt)
                    .reduce(Integer::sum).get();
        }
        return number;
    }
}
/*
OUTPUT:
15
1
30

*/
