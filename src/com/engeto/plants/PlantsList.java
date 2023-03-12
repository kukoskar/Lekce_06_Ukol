package com.engeto.plants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantsList {

    private final List<Plant> dataList = new ArrayList<>();

   // List<Plant> listP = new ArrayList<>();
    public void addAllFromFile(String filename) throws PlantException {
        long lineNumber = 0;
        String[] items = new String[0];
        String line = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                items = line.split("\t");
                line = scanner.nextLine();

                if (items.length != 5) throw new PlantException("Špatný počet položek na řádku číslo " +lineNumber);
                Plant plant = new Plant(
                        items[0],
                        items[1],
                        LocalDate.parse(items[4]),
                        LocalDate.parse(items[3]),
                        Integer.parseInt((items[2]))
                );
               dataList.add(plant);
              //  System.out.println(dataList);
                System.out.println(scanner.nextLine());
             }
        } catch (FileNotFoundException e) {
            throw new PlantException("Nepodařilo se nalézt soubor " + filename
                    + "\"" + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new PlantException(
                "Špatně zadané číslo na řádku " +lineNumber+": "
                +items[1]+"\nŘádek: "+line
                +"\n\"" + e.getLocalizedMessage()+"\"");
        }

      }

    public void add(Plant plant) { dataList.add(plant); }

    public void get(Plant plant) { dataList.get(0); }

      public void remove(Plant plant) { dataList.remove(plant); }

    public void clear() { dataList.clear(); }

    public List<Plant> getList() {
      return new ArrayList<>(dataList);
    }


}



