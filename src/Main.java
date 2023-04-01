import com.engeto.plants.*;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

  /*   private static void printWatering(Plant plant) {
        System.out.println("Naposled zalito : " + plant.getWatering());    }*/

    public static void main(String[] args) throws PlantException {
        PlantsList dataList = new PlantsList();
        try {
            dataList.addAllFromFile(Settings.getFilename(), Settings.getTabulator());
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println(PlantsList.getDescriptionOfAllPlants());

        List<Plant> list = new ArrayList<>();
            Plant plant = new Plant("Lilie", "Jsem hezká. ", LocalDate.of(2023, 3, 4),
                        LocalDate.of(2023, 3, 7), 6);
            Plant plant2 = new Plant("Konvalinka", LocalDate.of(2021, 3, 13), 5);
            Plant plant3 = new Plant("Narcis");
            Plant plant4 = new Plant("Bazalka", " v kuchyni", LocalDate.of(2021,9,4),
                        LocalDate.of(2021,9,4), 3 );

        System.out.println(plant.getWateringInfo());
        System.out.println(plant2.getWateringInfo());
        System.out.println(plant3.getWateringInfo() + "");

        list.add(plant);
        list.add(plant2);
        list.add(plant3);

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

            dataList.remove(2);
            dataList.add(plant4);
            System.out.println(PlantsList.getDescriptionOfAllPlants());
            System.out.println("Počet prvků: " + dataList.getList().size() + "\n");
         //       System.out.println("První prvek: " + list.get(0) + "\n");

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

        }
  }






