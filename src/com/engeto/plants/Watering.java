package com.engeto.plants;

import java.time.LocalDate;

public class Watering {
    LocalDate lastWatering = LocalDate.of(2023, 3, 07);

    public void SetLastWatering(LocalDate water) throws PlantException{
        if(water.isBefore(lastWatering)) {
            throw new PlantException("Datum nesmí být menší než den posledního zalití " +
                    " (zadal jsi : " + water + " )");
        }
        lastWatering = water;
    }
    public LocalDate getLastWatering() { return lastWatering; }
}
