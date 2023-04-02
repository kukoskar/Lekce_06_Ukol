package com.engeto.plants;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlantsList {

    public static List<Plant> dataList = new ArrayList<>();

    public void addAllFromFile(String filename, String tabulator) throws PlantException {
        long lineNumber = 0;
        String[] items = new String[0];
        String line = "";
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                lineNumber++;
                line = scanner.nextLine();
                items = line.split(tabulator);
               if (items.length != 5) throw new PlantException("Špatný počet položek na řádku číslo " + lineNumber);
                Plant plant = new Plant(
                        items[0],
                        items[1],
                        LocalDate.parse(items[3]),
                        LocalDate.parse(items[4]),
                        Integer.parseInt((items[2]))
                );
                dataList.add(plant);

              }
        } catch (FileNotFoundException e) {
            throw new PlantException("Nepodařilo se nalézt soubor " + filename
                    + "\"" + e.getLocalizedMessage());
        } catch (NumberFormatException e) {
            throw new PlantException(
                    "Špatně zadané číslo na řádku " + lineNumber + ": "
                            + items[2] + "\nŘádek: " + line
                            + "\n\"" + e.getLocalizedMessage() + "\"");
        }
        catch (DateTimeException e) {
            throw new PlantException(
                    "Špatně zadané datum na řádku " + lineNumber + ": "
                            + items[3] + items[4] + "\nŘádek: " + line
                            + "\n\"" + e.getLocalizedMessage() + "\"");
        }
    }

    public void saveToFile(String filename, String tabulator) throws PlantException {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Plant plant : dataList) {
                String record =
                  plant.getName()+tabulator
                  +plant.getNotes()+tabulator
                  +plant.getFreqOfWatering()+tabulator
                  +plant.getWatering()+tabulator
                  +plant.getPlanted();
               writer.println(record);
            }
        } catch (IOException e) {
            throw new PlantException("Došlo k chybě při zápisu do souboru "+filename+ ": " + e.getLocalizedMessage() );
        }
    }

    public static String getDescriptionOfAllPlants() {
        String allPlants = "";
        for (Plant plant : dataList) {
            allPlants += plant.getName() + " " + plant.getNotes() + " " + plant.getFreqOfWatering() +
                    " " + plant.getPlanted() + " " + plant.getWatering()  + "\n";
        }
        return allPlants;
    }

    public void add(Plant plant) {
      dataList.add(plant);
    }
    public void remove(int i) {

        dataList.remove(i);
    }

    public void size(){
        dataList.size();
    }
    public void clear() {
      dataList.clear();
    }
    public List<Plant> getList() {

        return new ArrayList<>(dataList);
    }

      @Override
    public String toString() {
        return dataList.toString();
    }
     public static List<Plant> getDataListList() {
         return dataList;
    }
  }






