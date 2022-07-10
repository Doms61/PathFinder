package org.example.readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AbstractFindPathInputReader {
    StringBuilder text = new StringBuilder();

    public StringBuilder findMazeFromFile(File file) throws FileNotFoundException {
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                text.append(input.nextLine()).append("\n");
            }
        }
        return text;
    }

    public StringBuilder findMazeFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of your maze.");
        int size = scanner.nextInt();
        System.out.println("Thanks, now enter " + size + " rows with each row containing " + size + " columns/elements");
        scanner.nextLine();
        for (int i = 0; i < size; i++) {
            System.out.println("Enter row number: " + i);
            text.append(scanner.nextLine()).append("\n");
            System.out.println(text);

        }
        return text;
    }
}
