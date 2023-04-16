import com.engeto.plants.*;
import com.engeto.plants.WateringComparator;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws PlantException {
        PlantsList dataList = new PlantsList();
        try {
            dataList.addAllFromFile(Settings.getFilename(), Settings.getDelimeter());
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println(PlantsList.getDescriptionOfAllPlants());

        List<Plant> datalist = new ArrayList<>();
        Set<Plant> listSet = new HashSet<>(datalist);
        List<Plant> dataList2 = new ArrayList<>(listSet);

            Plant plant = new Plant("Lilie", "Jsem hezká ", LocalDate.of(2023, 3, 4),
                        LocalDate.of(2023, 3, 7), 6);
            Plant plant2 = new Plant("Konvalinka", LocalDate.of(2021, 3, 13), 5);
            Plant plant3 = new Plant("Narcis");
            Plant plant4 = new Plant("Bazalka", " v kuchyni", LocalDate.of(2021,9,4),
                        LocalDate.of(2021,9,4), 3 );

            datalist.add(plant);
            datalist.add(plant2);
            datalist.add(plant3);
            dataList.add(plant4);

            listSet.add(plant);
            listSet.add(plant2);
            listSet.add(plant2);
            listSet.add(plant);
            listSet.add(plant2);
            listSet.add(plant4);
            listSet.add(plant2);
            listSet.add(plant3);

            Collections.sort(datalist);
             datalist.forEach ( n -> {
               System.out.println(n.getName()+ " " +n.getNotes()+ " zasazená: " +n.getPlanted());
               });
        System.out.println("\n");
        Collections.sort(datalist, new WateringComparator());
          datalist.forEach(c -> System.out.println(c.getName()+": "+c.getWatering()));

        System.out.println("\n" + "Počet prvků v množině je: " + listSet.size() + "\n");

          Collections.sort(dataList2);
          listSet.forEach( c -> {
              System.out.println("Datum zasazení :" + c.getPlanted());
          });

      //  System.out.println(dataList.getDatesOfPlanting());

        System.out.println("\n" + plant.getWateringInfo());
        System.out.println(plant2.getWateringInfo());
        System.out.println(plant3.getWateringInfo() + "");

            System.out.println(" ");
        try {
            plant.getFreqOfWatering();
            System.out.println("Naposled zalito : " + plant.getWatering());
            plant2.getFreqOfWatering();
            System.out.println("Naposled zalito : " + plant2.getWatering());
            plant3.setWatering(LocalDate.of(2023, 2, 26));
            System.out.println("Naposled zalito : " + plant3.getWatering());
            System.out.println(" ");
         } catch (PlantException e) {
             System.err.println("Chyba při nastavení posledního dne zalití : "
                     + e.getLocalizedMessage());
         }
        System.out.println("\n");

            dataList.add(plant);
            dataList.add(plant2);
            dataList.add(plant3);
            dataList.remove(2);
            dataList.add(plant4);
            System.out.println(PlantsList.getDescriptionOfAllPlants());
            System.out.println("Počet prvků v seznamu : " + dataList.getList().size() + "\n");
                System.out.println("První prvek: " + datalist.get(0).getName() + "\n");

            try {
                plant.getFreqOfWatering();
                System.out.println("Počet dní od zalití : " + plant.getFreqOfWatering());
                plant2.getFreqOfWatering();
                System.out.println("Počet dní od zalití : " + plant2.getFreqOfWatering());
                plant3.setFreqOfWatering(-20);
                System.out.println("Počet dní od zalití : " + plant3.getFreqOfWatering());
            } catch  (PlantException ex) {
                System.err.println("Chyba při nastavení frekvence zalití : "
                        + ex.getLocalizedMessage());
            }

        try {
            dataList.saveToFile(Settings.getFilename(), Settings.getDelimeter());
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
      }
    }











