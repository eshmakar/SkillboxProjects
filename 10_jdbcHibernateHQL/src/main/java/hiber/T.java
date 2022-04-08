package hiber;

import java.io.IOException;
import java.util.Scanner;

public class T {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.contains("+") && input.contains("%")) {
                String substring = input.substring(0, input.length() - 1);
                String[] inputFromUser = substring.split("\\+");
                sumWithPercent(Double.parseDouble(inputFromUser[0]), Double.parseDouble(inputFromUser[1]));
            }

            else if (input.contains("+")) {
                String[] inputSum = input.split("\\+");
                System.out.println(Double.parseDouble(inputSum[0]) + Double.parseDouble(inputSum[1]));
            }

            else if (input.contains("-") && input.contains("%")) {
                String substring = input.substring(0, input.length() - 1);
                String[] inputFromUser = substring.split("-");
                minusWithPercent(Double.parseDouble(inputFromUser[0]), Double.parseDouble(inputFromUser[1]));
            }

            else if (input.contains("-")) {
                String[] inputSum = input.split("-");
                System.out.println(Double.parseDouble(inputSum[0]) - Double.parseDouble(inputSum[1]));
            }

            else if (input.contains("*")) {
                String[] inputSum = input.split("\\*");
                System.out.println(Double.parseDouble(inputSum[0]) * Double.parseDouble(inputSum[1]));
            }

            else if (input.contains("/")) {
                String[] inputSum = input.split("/");
                System.out.println(Double.parseDouble(inputSum[0]) / Double.parseDouble(inputSum[1]));
            }

        }
    }

    public static void sumWithPercent(double number, double percent) {
        System.out.println(number + (number * (percent / 100.)));
    }

    public static void minusWithPercent(double number, double percent) {
        System.out.println(number - (number * (percent / 100.)));
    }
    }

