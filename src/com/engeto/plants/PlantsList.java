package com.engeto.plants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantsList {

    private List<Plants> dataList = new ArrayList<>();

    public ArrayList<Plants> addAllFromFile(String filename) throws PlantException {
        try (Scanner scanner = new Scanner(new FileReader(filename))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
             }
        } catch (FileNotFoundException e) {
            throw new PlantException("Nepodařilo se nalézt soubor " + filename + "\"" + e.getMessage());
        }
             return (ArrayList<Plants>) dataList;
    }

}



