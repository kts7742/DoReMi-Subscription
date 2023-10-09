package com.example.geektrust.MainClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        // Sample code to read from file passed as command line argument
        try {
            // the file to be opened for reading
            FileInputStream fis = new FileInputStream(args[0]);
            Scanner sc = new Scanner(fis); // file to be scanned
            // returns true if there is another line to read

            List<String> commands = new ArrayList<>();

            while(sc.hasNextLine()){
                commands.add(sc.nextLine());
            }

               //execute services
               new Run(commands);
            sc.close(); // closes the scanner
        } 
        catch (IOException e) {
            System.out.println("Invalid Input output");
        }
        
    }
}
