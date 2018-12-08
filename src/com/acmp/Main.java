package com.acmp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Long> array = new ArrayList<>();
        ArrayList<Long> tempArray = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        long counter = 1;

        File input = new File("input.txt");
        Scanner inputFile = new Scanner(input);
        inputFile.nextLong(); //skipping first num (array length in file)
        while(inputFile.hasNextLong()){
            array.add(inputFile.nextLong());
        }

        while(!(array.isEmpty())) {
            for (int i = 0; i < array.size(); i++) {
                if (array.get(i) >= counter - 1 && array.get(i) < counter * 10) {
                    tempArray.add(array.get(i));
                    array.remove(i);
                    i -= 1;
                }
            }
            for (long number : tempArray) {
                answer.append(number).append(" ");
            }
            tempArray.clear();
            counter *= 10;
        }

        File output = new File("output.txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(output);
            writer.print(answer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.flush();
            writer.close();
        }

    }
}
