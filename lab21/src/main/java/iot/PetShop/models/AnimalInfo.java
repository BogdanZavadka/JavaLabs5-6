package iot.PetShop.models;

import lombok.Getter;

import java.util.Objects;
@Getter
public class AnimalInfo extends AnimalSize {
    private String animalType;
    private String animalName;
    private int animalAgeInMonth;
    private String feedType;
    private double dailyAmountOfFeedInGrams;
    private double priceInUAH;

    public AnimalInfo(String animalType, String animalName, int animalAgeInMonth, String feedType, double dailyAmountOfFeedInGrams, double priceInUAH, double lengthInCm, double widthInCm, double weightInKg) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalAgeInMonth = animalAgeInMonth;
        this.feedType = feedType;
        this.dailyAmountOfFeedInGrams = dailyAmountOfFeedInGrams;
        this.priceInUAH = priceInUAH;
        super.lengthInCm = lengthInCm;
        super.widthInCm = widthInCm;
        super.weightInKg = weightInKg;
    }

    public boolean equals(AnimalInfo animalInfo){
        boolean bool1 = Objects.equals(this.getAnimalName(), animalInfo.getAnimalName());
        boolean bool2 = Objects.equals(this.getAnimalType(), animalInfo.getAnimalType());
        boolean bool3 = this.getAnimalAgeInMonth() == animalInfo.getAnimalAgeInMonth();
        boolean bool4 = this.getPriceInUAH() == animalInfo.getPriceInUAH();
        boolean bool5 = super.getLengthInCm() == animalInfo.getLengthInCm();
        boolean bool6 = super.getWeightInKg() == animalInfo.getWeightInKg();
        boolean bool7 = super.getWidthInCm() == animalInfo.getWidthInCm();
        return bool1 && bool2 && bool3 && bool4 && bool5 && bool6 && bool7;
    }
}
