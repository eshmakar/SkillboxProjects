/*
Напишите программу, которая на входе через консоль принимает фамилию, имя и отчество одной строкой (например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно в формате:
Фамилия: Иванов
Имя: Сергей
Отчество: Петрович
*/

import java.util.Scanner;

public class FIO {
    public static void main(String[] args) {
        String fio = new Scanner(System.in).nextLine();
        String[] s = fio.split(" ");
        System.out.println("Фамилия: " + s[0]);
        System.out.println("Имя: " + s[1]);
        System.out.println("Отчество: " + s[2]);
    }
}
