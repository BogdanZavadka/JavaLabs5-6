package iot.PetShop.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AnimalSizeTest {

    @Test
    void testGetters() {
        var animalInfo1 = new AnimalInfo("dog", "dogName1", 12, "High-protein", 500, 2000, 100, 20, 20);
        Assertions.assertEquals(animalInfo1.getWidthInCm(), 20);
        Assertions.assertEquals(animalInfo1.getLengthInCm(), 100);
        Assertions.assertEquals(animalInfo1.getWeightInKg(), 20);
    }
}