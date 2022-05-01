package iot.PetShop.manager;

import iot.PetShop.models.AnimalInfo;

import java.io.FileWriter;;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PetWriter {
    public static void writeToFile(final List<AnimalInfo> animalList) throws IOException {
        try (FileWriter writer = new FileWriter("result.csv", StandardCharsets.UTF_8)) {
            writer.write(animalList.get(0).getHeaders());
            writer.write("\r\n");
            for (AnimalInfo animalInfo : animalList) {
                writer.write(animalInfo.toCSV());
                writer.write("\r\n");
            }
            writer.flush();
        }
    }
}
