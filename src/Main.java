import com.engeto.plants.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static void printFrequency(Frequency frequency) {
        System.out.println(
                "Počet dní od zalití : "
                        +frequency.getFrequencyOfWatering());
    }
    private static void printWatering(Watering watering) {
        System.out.println(
                "Naposled zalito : "
                        +watering.getLastWatering());
    }

    public static void main(String[] args) {

        Plants plants1 = new Plants("Lilie", LocalDate.now(), 4);
        Plants plants2 = new Plants("Konvalinka", LocalDate.now(), 5);
        Plants plants3 = new Plants("Narcis", LocalDate.now(), 3);
        System.out.println(plants1.getWateringInfo());
        System.out.println(plants2.getWateringInfo());
        System.out.println("Zalij mě prosím za " + plants3.getFreqOfWatering() + " dny \n");

        PlantsList list = new PlantsList();
          try {
            list.addAllFromFile(Settings.getFilename());
        } catch (PlantException e) {
            System.err.println(e.getLocalizedMessage());
        }

        Frequency frequency = new Frequency();
        try {
            System.out.println(" ");
            frequency.SetFrequencyOfWatering(4);
            printFrequency(frequency);
            frequency.SetFrequencyOfWatering(-20);
            printFrequency(frequency);
        } catch (PlantException ex) {
            System.err.println("Chyba při nastavení počtu dní zalití : "
                    +ex.getMessage());
        }


        Watering watering = new Watering();
        try {
            watering.SetLastWatering(LocalDate.of(2023, 3, 8));
            printWatering(watering);
            watering.SetLastWatering(LocalDate.of(2023, 3, 6));
            printWatering(watering);
        } catch (PlantException ex) {
            System.err.println("Chyba při nastavení posledního dne zalití : "
                    +ex.getMessage());
        }


    }
 }


