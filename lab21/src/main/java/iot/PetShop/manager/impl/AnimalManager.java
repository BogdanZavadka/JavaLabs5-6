package iot.PetShop.manager.impl;

import iot.PetShop.manager.InterfaceAnimalManager;
import iot.PetShop.models.AnimalInfo;

import java.util.*;
import java.util.Comparator;

public class AnimalManager implements InterfaceAnimalManager {

    private List<AnimalInfo> allAnimals = new LinkedList<>();

    public int getAnimalListSize(){
        return allAnimals.size();
    }

    public List<String> getNames(List<AnimalInfo> animalList){
        List<String> animalNames = new LinkedList<>();
        animalList.forEach(animal -> {
            animalNames.add(animal.getAnimalName());
        });
        return animalNames;
    }

    @Override
    public void addAnimals(List<AnimalInfo> animals) {
        animals.forEach(animal -> {
            if (!allAnimals.contains(animal)){
                allAnimals.add(animal);
            }});
    }

    @Override
    public List<AnimalInfo> sellAnimal(AnimalInfo animalInfo) {
        List<AnimalInfo> otherAnimals = new LinkedList<>();
        allAnimals.forEach(animal -> {
            if (animalInfo.equals(animal)){allAnimals.remove(animalInfo);}
            else {otherAnimals.add(animal);}
        });
        return otherAnimals;
    }

    @Override
    public List<AnimalInfo> searchByType(String type) {
        List<AnimalInfo> oneTypeAnimals = new LinkedList<>();
        allAnimals.forEach(animal -> {
            if (Objects.equals(animal.getAnimalType(), type))
                oneTypeAnimals.add(animal);
        });
        return oneTypeAnimals;
    }

    @Override
    public List<AnimalInfo> searchByFeedType(String feedType) {
        List<AnimalInfo> oneFeedTypeAnimals = new LinkedList<>();
        allAnimals.forEach(animal -> {
            if (Objects.equals(animal.getFeedType(), feedType))
                oneFeedTypeAnimals.add(animal);});
        return oneFeedTypeAnimals;
    }

    @Override
    public List<AnimalInfo> sortByPrice(boolean sortByDescending) {
        List<AnimalInfo> sortedByPrice = allAnimals;
        sortedByPrice.sort(Comparator.comparing(AnimalInfo::getPriceInUAH));
        if (sortByDescending)
            Collections.reverse(sortedByPrice);
        return sortedByPrice;
    }



    @Override
    public List<AnimalInfo> sortByDailyAmountOfFeed(boolean sortByDescending) {
        List<AnimalInfo> sortedByByDailyAmountOfFeed = allAnimals;
        sortedByByDailyAmountOfFeed.sort(Comparator.comparing(AnimalInfo::getDailyAmountOfFeedInGrams));
        if (sortByDescending)
            Collections.reverse(sortedByByDailyAmountOfFeed);
        return sortedByByDailyAmountOfFeed;
    }
}
