/*
1. Создайте массив из мнемонической фразы:
Каждый охотник желает знать, где сидит фазан.
2. Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
*/

import java.util.Arrays;
import java.util.Collections;

public class ArraysReverse {
    public static void main(String[] args) {
        String[] text = "Каждый охотник желает знать, где сидит фазан".split(" ");
        System.out.println(Arrays.asList(text));
        Collections.reverse(Arrays.asList(text));
        System.out.println(Arrays.asList(text));

    }
}
/*
OUTPUT:
[Каждый, охотник, желает, знать,, где, сидит, фазан]
[фазан, сидит, где, знать,, желает, охотник, Каждый]
*/
