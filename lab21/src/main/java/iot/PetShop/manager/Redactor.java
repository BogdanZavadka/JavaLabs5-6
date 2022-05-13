package iot.PetShop.manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Redactor {
    public String changeLastLetters(String text) {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(text);
        char[] charText = text.toCharArray();
        while (m.find()) {
            charText[m.end() - 1] = Character.toUpperCase(m.group().charAt(m.group().length() - 1));
        }
        return String.valueOf(charText);
    }
}
