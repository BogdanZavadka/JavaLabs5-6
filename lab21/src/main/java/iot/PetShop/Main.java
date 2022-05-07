package iot.PetShop;

import iot.PetShop.manager.impl.AnimalManager;
import iot.PetShop.models.AnimalInfo;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnimalManager animalManager = new AnimalManager();
        List<AnimalInfo> animalList = new LinkedList<>();
        AnimalInfo animalInfo1 = new AnimalInfo("dog", "dogName1", 12, "High-protein", 500, 2000, 100, 20, 20);
        AnimalInfo animalInfo2 = new AnimalInfo("cat", "catName1", 10, "High-protein", 200, 1500, 60, 10, 5);
        AnimalInfo animalInfo3 = new AnimalInfo("hamster", "hamsterName1", 3, "Cereal", 10, 500, 5, 3, 0.01);
        AnimalInfo animalInfo4 = new AnimalInfo("hamster", "hamsterName2", 4, "Cereal", 11, 600, 5, 3, 0.01);
        animalList.add(animalInfo1);
        animalList.add(animalInfo2);
        animalList.add(animalInfo3);
        animalList.add(animalInfo4);
        animalManager.addAnimals(animalList);
        System.out.println("All hamsters:");
        System.out.println(animalManager.getNames(animalManager.searchByType("hamster")));
        System.out.println("-------------------------------------");
        System.out.println("All high-protein feed animals:");
        System.out.println(animalManager.getNames(animalManager.searchByFeedType("High-protein")));
        System.out.println("-------------------------------------");
        System.out.println("Animals sorted by daily amount of feed:");
        System.out.println(animalManager.getNames(animalManager.sortByDailyAmountOfFeed(false)));
        System.out.println("-------------------------------------");
        System.out.println("Animals sorted by price:");
        System.out.println(animalManager.getNames(animalManager.sortByPrice(false)));
        System.out.println("-------------------------------------");
        System.out.println("The dog was sold, other animals:");
        System.out.println(animalManager.getNames(animalManager.sellAnimal(animalInfo1)));
    }
}
