package iot.PetShop.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnimalInfoTest {
    AnimalInfo result;

    @BeforeEach
    void setUp(){
        result = new AnimalInfo("dog", "dogName1", 12, "High-protein", 500, 2000, 100, 20, 20);
    }
    @Test
    void testEquals() {
        var animalInfo2 = new AnimalInfo("dog", "dogName1", 12, "High-protein", 500, 2000, 100, 20, 20);
        Assertions.assertTrue(result.equalsClasses(animalInfo2));
    }

    @Test
    void testGetters() {
        var animalInfo1 = new AnimalInfo("dog", "dogName1", 12, "High-protein", 500, 2000, 100, 20, 20);
        Assertions.assertEquals(animalInfo1.getAnimalName(), "dogName1");
        Assertions.assertEquals(animalInfo1.getAnimalType(), "dog");
        Assertions.assertEquals(animalInfo1.getAnimalAgeInMonth(), 12);
        Assertions.assertEquals(animalInfo1.getFeedType(), "High-protein");
        Assertions.assertEquals(animalInfo1.getPriceInUAH(), 2000);
        Assertions.assertEquals(animalInfo1.getDailyAmountOfFeedInGrams(), 500);
        Assertions.assertEquals(animalInfo1.getLengthInCm(), 100);
        Assertions.assertEquals(animalInfo1.getWeightInKg(), 20);
        Assertions.assertEquals(animalInfo1.getWidthInCm(), 20);

    }
}