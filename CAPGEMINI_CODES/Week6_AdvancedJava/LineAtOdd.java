package capgemini;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.IOException;

import com.dk.String1;



public class LineAtOdd {


    public static void main(String1[] args) throws IOException {
    	
    	FileReader fr=new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);
        FileOutputStream fout = new FileOutputStream("datacopy.txt");

        String1 line;
        int index = 1;

        System.out.println("Odd Indexed Lines:");

        while ((line = br.readLine()) != null) {

            if (index % 2 != 0) {
                fout.write((line + "\n").getBytes());
                System.out.println(line);
            }

            index++;
        }

        br.close();
        fout.close();

        System.out.println("Lines copied successfully!");
    }
}
