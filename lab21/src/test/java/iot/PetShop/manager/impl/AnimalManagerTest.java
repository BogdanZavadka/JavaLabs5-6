package iot.PetShop.manager.impl;

import iot.PetShop.models.AnimalInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class AnimalManagerTest {


    private List<AnimalInfo> animalList = new LinkedList<>();
    private AnimalManager animalManager = new AnimalManager();


    @BeforeEach
    void testSetUp() {
        AnimalInfo animalInfo1 = new AnimalInfo("dog", "dogName1", 12, "High-protein", 500, 2000, 100, 20, 20);
        AnimalInfo animalInfo2 = new AnimalInfo("cat", "catName1", 10, "High-protein", 200, 1500, 60, 10, 5);
        AnimalInfo animalInfo3 = new AnimalInfo("hamster", "hamsterName1", 3, "Cereal", 10, 500, 5, 3, 0.01);
        AnimalInfo animalInfo4 = new AnimalInfo("hamster", "hamsterName2", 4, "Cereal", 11, 600, 5, 3, 0.01);
        animalList.add(animalInfo1);
        animalList.add(animalInfo2);
        animalList.add(animalInfo3);
        animalList.add(animalInfo4);
        animalManager.addAnimals(animalList);
    }

    @Test
    void testAddAnimals() {
        Assertions.assertEquals(animalList.size(), animalManager.getAnimalListSize());
        Assertions.assertFalse(animalList.isEmpty());
    }

    @Test
    void testSellAnimal() {
        var animalInfo1 = new AnimalInfo("dog", "dogName1", 12, "High-protein", 500, 2000, 100, 20, 20);
        List<AnimalInfo> otherAnimals = animalManager.sellAnimal(animalInfo1);
        Assertions.assertFalse(otherAnimals.contains(animalInfo1));
    }

    @Test
    void testSearchByType() {
        String type = "hamster";
        List<AnimalInfo> hamsters = animalManager.searchByType(type);
        hamsters.forEach(animal -> {
            Assertions.assertEquals(animal.getAnimalType(), type);
        });

    }

    @Test
    void testSearchByFeedType() {
        String feedType = "High-protein";
        List<AnimalInfo> highProtein = animalManager.searchByFeedType(feedType);
        highProtein.forEach(animal -> {
            Assertions.assertEquals(animal.getFeedType(), feedType);
        });
    }

    @Test
    void testSortByPrice() {
        List<AnimalInfo> sortedByPriceDec = animalManager.sortByPrice(true);
        List<AnimalInfo> sortedByPrice = animalManager.sortByPrice(false);
        Assertions.assertFalse(sortedByPrice.isEmpty());
        Assertions.assertFalse(sortedByPriceDec.isEmpty());
        Assertions.assertEquals(sortedByPrice.size(), animalList.size());
        Assertions.assertEquals(sortedByPriceDec.size(), animalList.size());
        for (int i = 0; i<sortedByPrice.size() - 1; i++){
            Assertions.assertTrue(sortedByPrice.get(i).getPriceInUAH() < sortedByPrice.get(i+1).getPriceInUAH());
            Assertions.assertTrue(sortedByPriceDec.get(i).getPriceInUAH() > sortedByPriceDec.get(i+1).getPriceInUAH());
        }
    }

    @Test
    void testSortByDailyAmountOfFeed() {
        List<AnimalInfo> sortedByDailyAmountOfFeedDec = animalManager.sortByDailyAmountOfFeed(true);
        List<AnimalInfo> sortedByDailyAmountOfFeed = animalManager.sortByDailyAmountOfFeed(false);
        Assertions.assertFalse(sortedByDailyAmountOfFeed.isEmpty());
        Assertions.assertFalse(sortedByDailyAmountOfFeedDec.isEmpty());
        Assertions.assertEquals(sortedByDailyAmountOfFeed.size(), animalList.size());
        Assertions.assertEquals(sortedByDailyAmountOfFeedDec.size(), animalList.size());
        for (int i = 0; i<sortedByDailyAmountOfFeed.size() - 1; i++) {
            Assertions.assertTrue(sortedByDailyAmountOfFeed.get(i).getDailyAmountOfFeedInGrams() < sortedByDailyAmountOfFeed.get(i + 1).getDailyAmountOfFeedInGrams());
            Assertions.assertTrue(sortedByDailyAmountOfFeedDec.get(i).getDailyAmountOfFeedInGrams() > sortedByDailyAmountOfFeedDec.get(i + 1).getDailyAmountOfFeedInGrams());
        }
    }

    @Test
    void testGetAnimalListSize() {
        Assertions.assertEquals(animalManager.getAnimalListSize(), 4);
    }

    @Test
    void testGetNames() {
        List<String> listOfAnimalsNames = animalManager.getNames(animalList);
        for (int i = 0; i<listOfAnimalsNames.size(); i++){
            Assertions.assertEquals(listOfAnimalsNames.get(i), animalList.get(i).getAnimalName());
        }
    }
}