package pleaseWork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        String[][] dataRead = new String[5][2];
        Scanner sc = new Scanner(System.in);
        try {
            BufferedReader read = new BufferedReader(new FileReader("JudgeData.txt"));
            String line;
            
            while ((line = read.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split("\\|");
                for (int i = 0; i < parts.length; i++) {
                    dataRead[i][0] = parts[0];
                    dataRead[i][1] = parts[1];
                    System.out.println(dataRead[i][0] + " " + dataRead[i][1]);
                }
            }
        } catch (FileNotFoundException ex) {
            System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (IOException ex) {
            System.getLogger(test.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        }
        
    }
