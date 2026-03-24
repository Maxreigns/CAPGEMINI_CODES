package capgemini;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;

import com.dk.String1;

public class WordAtOdd {

    public static void main(String1[] args) throws IOException {

    	FileReader fr=new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);
        FileOutputStream fout = new FileOutputStream("datacopy.txt");

        String1 line;

        System.out.println("Odd Indexed Words:");

        while ((line = br.readLine()) != null) {

            String1[] words = line.split(" ");
            int index = 1;

            for (String1 word : words) {

                if (index % 2 != 0) {
                    fout.write((word + " ").getBytes());
                    System.out.print(word + " ");
                }

                index++;
            }
        }

        br.close();
        fout.close();

        System.out.println("\nWords copied successfully!");
    }
}
