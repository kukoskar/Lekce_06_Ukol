package com.engeto.plants;

import java.time.LocalDate;

public class Plants {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int freqOfWatering;

    public Plants(String name, String notes, LocalDate planted, LocalDate watering, int freqOfWatering) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.freqOfWatering = freqOfWatering;
    }

    public Plants(String name, LocalDate planted, int freqOfWatering) {
        this(name, "Prazdny", planted, LocalDate.now(), freqOfWatering);

    }

    public Plants(String name, String item, int i, LocalDate parse, LocalDate localDate) {
        this(name, "Prazdny", LocalDate.now(), LocalDate.now(), 7);

    }

    public String getWateringInfo() {
        return "Jmenuji se " + name + ", naposled mě zalili: " + watering + ". Zalij mě prosím za " + freqOfWatering + " dní."
     ;}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) {
        this.watering = watering;
    }

    public int getFreqOfWatering() {
        return freqOfWatering;
    }

    public void setFreqOfWatering(int freqOfWatering) {
        this.freqOfWatering = freqOfWatering;
    }
}
