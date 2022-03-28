/*
Создайте массив типа float с температурами 30 пациентов (от 32 до 40 градусов).
Напишите код, который выводит среднюю температуру по больнице и количество здоровых пациентов (с температурой от 36,2 до 36,9), а также температуры всех пациентов.
Вынесите в константы условия задания:
количество пациентов,
минимальная и максимальная температура пациентов,
минимальная и максимальная температура диапазона здоровых пациентов.
*/

public class StringManipulations {
    private static final float[] patients = new float[30];
    private static float average = .0f;
    private static int healthy = 0;
    private static float minTemper = .0f;
    private static float maxTemper = .0f;

    public static void main(String[] args) {
        for (int i = 0; i < patients.length; i++) {
            String randomTemperature = String.format("%.2f", (Math.random() * 9 + 32)).replaceAll(",", ".");
            patients[i] = Float.parseFloat(randomTemperature);
        }

        System.out.print("Температуры пациентов: ");
        for (float pacient : patients) {
            System.out.print(pacient + " ");
            average += pacient;
            if (pacient > 36.2 && pacient < 36.9)
                healthy++;
            if (minTemper == .0f)
                minTemper = pacient;
            minTemper = Math.min(minTemper, pacient);
            maxTemper = Math.max(maxTemper, pacient);
        }

        System.out.println("\nСредняя температура: " + String.valueOf(average / 30).substring(0, 5));
        System.out.println("Количество здоровых: " + healthy);
        System.out.println("Минимальная температура: " + minTemper);
        System.out.println("Максимальная температура: " + maxTemper);


    }
}
/*
OUTPUT
Температуры пациентов: 39.69 35.62 39.91 36.07 36.13 40.43 36.6 32.28 38.85 34.98 32.06 39.8 32.03 32.61 36.44 39.48 32.89 40.06 36.82 36.68 40.17 35.83 37.35 33.63 35.4 35.55 33.94 38.83 35.46 33.8
Средняя температура: 36.31
Количество здоровых: 4
Минимальная температура: 32.03
Максимальная температура: 40.43
*/
