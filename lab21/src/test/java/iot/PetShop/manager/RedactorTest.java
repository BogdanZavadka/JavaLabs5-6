package iot.PetShop.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RedactorTest {

    @Test
    void checkText() {
        var redactor = new Redactor();
        String text = "Firstly, you need to know how to work with a computer, which is a hard skill. " +
                "Everyone who works in the IoT sphere has to write code for machines or other devices that is possible only if you know some programming languages and opportunities of the computer. " +
                "Consequently, this is a key skill that everyone should have working with IoT.";
        String actualText = redactor.checkText(text);
        Assertions.assertFalse(actualText.isEmpty());
        String expectedText = "FirstlY, yoU neeD tO knoW hoW tO worK witH A computeR, whicH iS A harD skilL. " +
                "EveryonE whO workS iN thE IoT spherE haS tO writE codE foR machineS oR otheR deviceS thaT iS possiblE onlY iF yoU knoW somE programminG languageS anD opportunitieS oF thE computeR. " +
                "ConsequentlY, thiS iS A keY skilL thaT everyonE shoulD havE workinG witH IoT.";
        Assertions.assertEquals(actualText, expectedText);
        int indexOfWhitespace = 0;
        StringBuilder anotherExpectedText = new StringBuilder();
        while (text.length() > 0) {
            for (int i = 0; i < text.length(); i++) {
                if (Character.isWhitespace(text.charAt(i))) {
                    indexOfWhitespace = i;
                    break;
                }
            }
            if (Character.isLetter(text.charAt(indexOfWhitespace - 1))) {
                anotherExpectedText.append(" ").append(text.substring(0, indexOfWhitespace - 1))
                        .append(Character.toUpperCase(text.charAt(indexOfWhitespace - 1)));
                text = text.substring(indexOfWhitespace + 1, text.length());
            } else {
                if (indexOfWhitespace < text.length()) {
                    anotherExpectedText.append(" ").append(text.substring(0, indexOfWhitespace - 2))
                            .append(Character.toUpperCase(text.charAt(indexOfWhitespace - 2))).append(text.charAt(indexOfWhitespace - 1));
                    text = text.substring(indexOfWhitespace + 1, text.length());
                } else {
                    anotherExpectedText.append(" ").append(text.substring(0, indexOfWhitespace - 2)).append(Character.toUpperCase(text.charAt(text.length() - 2))).append(text.charAt(text.length() - 1));
                    text = "";
                }
            }
        }
        Assertions.assertEquals(actualText, anotherExpectedText.substring(1));
    }
}
