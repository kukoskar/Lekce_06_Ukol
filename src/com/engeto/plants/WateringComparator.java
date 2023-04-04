package com.engeto.plants;

public class WateringComparator implements java.util.Comparator<Plant> {

    @Override
    public int compare(Plant first, Plant second) {
        return first.getWatering().compareTo(second.getWatering());
    }
}


