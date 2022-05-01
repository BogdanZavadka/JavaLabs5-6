package iot.PetShop.manager;

import iot.PetShop.manager.impl.AnimalManager;
import iot.PetShop.models.AnimalInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PetWriterTest {

    @Test
    void writeToFile() throws IOException {
        List<AnimalInfo> animalList = new LinkedList<>();
        var animalManager = new AnimalManager();
        AnimalInfo animalInfo1 = new AnimalInfo("dog", "dogName1", 12, "High-protein", 500, 2000, 100, 20, 20);
        AnimalInfo animalInfo2 = new AnimalInfo("cat", "catName1", 10, "High-protein", 200, 1500, 60, 10, 5);
        AnimalInfo animalInfo3 = new AnimalInfo("hamster", "hamsterName1", 3, "Cereal", 10, 500, 5, 3, 0.01);
        AnimalInfo animalInfo4 = new AnimalInfo("hamster", "hamsterName2", 4, "Cereal", 11, 600, 5, 3, 0.01);
        animalList.add(animalInfo1);
        animalList.add(animalInfo2);
        animalList.add(animalInfo3);
        animalList.add(animalInfo4);
        animalManager.addAnimals(animalList);
        PetWriter.writeToFile(animalList);
        var sep = File.separator;
        String expectedPath = String.format("%s%s%s%s%s", System.getProperty("user.dir"), sep, "src\\test\\resources", sep, "expected.csv");
        String actualPath = String.format("%s%s%s", System.getProperty("user.dir"), sep, "result.csv");
        try(FileReader expectedReader = new FileReader(expectedPath);
            BufferedReader expectedBR = new BufferedReader(expectedReader);
            FileReader actualReader = new FileReader(actualPath);
            BufferedReader actualBR = new BufferedReader(actualReader);){
            for (int i = 0; i < animalList.size() + 1; i++){
                Assertions.assertEquals(expectedBR.readLine(), actualBR.readLine());
            }
        }
    }
}