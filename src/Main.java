import com.engeto.plants.*;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static void printFrequency(Plant plant) {
        System.out.println("Počet dní od zalití : " + plant.getFreqOfWatering());
    }

    private static void printWatering(Plant plant) {
        System.out.println("Naposled zalito : " + plant.getWatering());
    }

    public static void main(String[] args) throws PlantException {
        PlantsList listP = new PlantsList();
        try {
            listP.addAllFromFile(Settings.getFilename());
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }
        System.out.println(PlantsList.allListPlants());
        System.out.println(listP.getList() + "\n");

        Plant plant = new Plant("Lilie", "Jsem hezká. ", LocalDate.of(2023, 1, 11),
                LocalDate.of(2023, 3, 7), 6);
        Plant plant2 = new Plant("Konvalinka", LocalDate.of(2021, 3, 13), 5);
        Plant plant3 = new Plant("Narcis");

        System.out.println(plant.getWateringInfo());
        System.out.println(plant2.getWateringInfo());
        System.out.println(plant3.getWateringInfo() + "");

        List<Plant> list = new ArrayList<>();
        // List<Plant> dataList = new ArrayList<>();

        list.add(plant);
        list.add(plant2);
        list.add(plant3);

        // System.out.println("Druhá květina je " + list.getList(plant2));
        //  for (Plant plant : list) {
        System.out.println("\n" + plant.getAllPlantInfo());

            try {
                System.out.println(" ");
                //  list.clear();
                plant.getFreqOfWatering();
                printWatering(plant);
                plant2.getFreqOfWatering();
                printWatering(plant2);
                plant3.setWatering(LocalDate.of(2023, 2, 26));
                printWatering(plant3);
            } catch (PlantException ex) {
                System.err.println("Chyba při nastavení posledního dne zalití : "
                        + ex.getLocalizedMessage());
            }
            list.add(plant3);
            try {
                System.out.println(" ");
                plant.getFreqOfWatering();
                printFrequency(plant);
                plant2.getFreqOfWatering();
                printFrequency(plant2);
                plant3.setFreqOfWatering(-20);
                printFrequency(plant3);
            } catch (PlantException ex) {
                System.err.println("Chyba při nastavení posledního dne zalití : "
                        + ex.getLocalizedMessage());
            }
        }
}





