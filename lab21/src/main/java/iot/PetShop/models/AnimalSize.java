package iot.PetShop.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AnimalSize {
    protected double lengthInCm;
    protected double widthInCm;
    protected double weightInKg;

    public String getHeaders() {
        return "lengthInCm, widthInCm, weightInKg, ";
    }

    public String toCSV() {
        return lengthInCm + ", " + widthInCm + ", " + weightInKg + ", ";
    }
}
