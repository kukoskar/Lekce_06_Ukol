package com.engeto.plants;

public class Frequency {
    int frequencyOfWatering;

    public void SetFrequencyOfWatering(int watering) throws PlantException{
        if (watering <1) {
            throw new PlantException("Počet dní nesmí být menší než 1" +
                    " (zadal jsi : " + watering + " )");
        }
        frequencyOfWatering = watering;
    }
    public int getFrequencyOfWatering() { return frequencyOfWatering; }


}


