import java.io.BufferedWriter;
import java.io.FileWriter;

public class CarNumberGeneratedOptimized {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();

        BufferedWriter writer = new BufferedWriter(new FileWriter("Z:\\numbers.txt", false));

        char letters[] = "УКЕНХВАРОСМТ".toCharArray();
        StringBuilder sb;
        sb = new StringBuilder();
        for (int number = 1; number < 1000; number++) {
            int regionCode = 199;
            for (char firstLetter : letters) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        sb
                                .append(firstLetter)
                                .append(padNumber(number, 3))
                                .append(secondLetter)
                                .append(thirdLetter)
                                .append(padNumber(regionCode, 2))
                                .append('\n');
                    }
                }
            }
            if (sb.length() > 100_000) {
                writer.write(sb.toString());
                sb = new StringBuilder();
            }
        }
        writer.write(sb.toString());
        writer.flush();
        writer.close();

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }

    private static String padNumber(int number, int numberLength) {
        String numberStr = Integer.toString(number);
        int padSize = numberLength - numberStr.length();
        for (int i = 0; i < padSize; i++) {
            numberStr = '0' + numberStr;
        }
        return numberStr;

    }
}
//18234
//17576
//18349

// BufferedWriter
//1343
//1036
//1593


//if (sb.length() > 100_000) {
//                    writer.write(sb.toString());
//                    sb = new StringBuilder();
//543
