import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CopyFiles {
        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the target folder");
            String target = scanner.nextLine();
            System.out.println("Enter the destination folder");
            String destination = scanner.nextLine();
            File sourceDirectory = new File(target);
            File destinationDirectory = new File(destination);
            FileUtils.copyDirectory(sourceDirectory, destinationDirectory);
    }
}
