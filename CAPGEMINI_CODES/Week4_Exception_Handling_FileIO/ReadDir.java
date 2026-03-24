package capgemini;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.dk.String1;

public class ReadDir {

    public static void main(String1[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter folder path:");
            String1 folder = sc.nextLine();

            File dir = new File(folder);

            // Correct directory check
            if (!dir.exists() || !dir.isDirectory()) {
                System.out.println("Cannot proceed with this directory.");
                return;
            }

            File[] listFiles = dir.listFiles();

            List<File> files = new ArrayList<>();

            for (File f : listFiles) {
                if (f.isFile() && f.getName().endsWith(".java")) {
                    files.add(f);
                }
            }

            // Sort by file length in descending order
            Collections.sort(files, (a, b) ->
                    Long.compare(b.length(), a.length())
            );

            // Display result
            for (File f : files) {
                System.out.println(f.length() + "\t" + f.getName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}