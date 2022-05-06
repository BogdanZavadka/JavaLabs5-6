package iot.PetShop.models;

import lombok.Getter;

@Getter
public class AnimalInfo extends AnimalSize {
    private final String animalType;
    private final String animalName;
    private final int animalAgeInMonth;
    private final String feedType;
    private final double dailyAmountOfFeedInGrams;
    private final double priceInUAH;

    public AnimalInfo(final String animalType, final String animalName, final int animalAgeInMonth, final String feedType,
                      final double dailyAmountOfFeedInGrams, final double priceInUAH, final double lengthInCm, final double widthInCm, final double weightInKg) {
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

    public boolean equalsClasses(final AnimalInfo animalInfo) {
        boolean bool1 = this.getAnimalName().contentEquals(animalInfo.getAnimalName());
        boolean bool2 = this.getAnimalType().contentEquals(animalInfo.getAnimalType());
        boolean bool3 = this.getAnimalAgeInMonth() == animalInfo.getAnimalAgeInMonth();
        boolean bool4 = this.getPriceInUAH() == animalInfo.getPriceInUAH();
        boolean bool5 = super.getLengthInCm() == animalInfo.getLengthInCm();
        boolean bool6 = super.getWeightInKg() == animalInfo.getWeightInKg();
        boolean bool7 = super.getWidthInCm() == animalInfo.getWidthInCm();
        return bool1 && bool2 && bool3 && bool4 && bool5 && bool6 && bool7;
    }

    @Override
    public String getHeaders() {
        return super.getHeaders() + "animalType, " + "animalName, " + "animalAgeInMonth, " + "feedType, " + "dailyAmountOfFeedInGrams, " + "priceInUAH";
    }

    @Override
    public String toCSV() {
        return super.toCSV() + animalType + ", " + animalName + ", " + animalAgeInMonth + ", " + feedType + ", " + dailyAmountOfFeedInGrams + ", " + priceInUAH;
    }
}
