/*
Напишите код в проекте, который считает сумму заработка всех друзей (Васи, Пети и Маши)
*/

import java.util.Arrays;

public class Zadacha {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        String[] strings = text.split(" ");
        Integer sum = Arrays.stream(strings)
                .filter(e -> Character.isDigit(e.charAt(0)))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .get();

        System.out.println(sum);
    }
}
//42563