package iot.PetShop.manager;

import iot.PetShop.models.AnimalInfo;

import java.util.List;

public interface InterfaceAnimalManager {
    void addAnimals(List<AnimalInfo> animals);
    List<AnimalInfo> sellAnimal(AnimalInfo animalInfo);
    List<AnimalInfo> searchByType(String type);
    List<AnimalInfo> searchByFeedType(String feedType);
    List<AnimalInfo> sortByPrice(boolean sortByDecreasing);
    List<AnimalInfo> sortByDailyAmountOfFeed(boolean sortByDecreasing);
}
