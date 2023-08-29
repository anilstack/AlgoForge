package com.anilstack.ds.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRecordProcessor {

    // Method to remove the ",1" suffix from each record
    private static String removeSuffix(String record) {
        return record.replace(",1", "");
    }

    public static void main(String[] args) {
        String inputFilePath = "D:\\Downloads\\94480c19-dbb5-4490-a040-cf459b576138.oplusdownload";   // Replace with the path to your input file
        String outputFilePath = "D:\\Downloads\\94480c19-dbb5-4490-a040-cf459b576138.oplusdownload.output.txt"; // Replace with the path for the output file

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Process each record and write the cleaned record to the output file
                String cleanedRecord = removeSuffix(line);
                writer.write(cleanedRecord);
                writer.newLine();
            }

            System.out.println("Records processed and saved to the output file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
