package iot.PetShop.manager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Redactor {
    public String checkText(String text) {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher(text);
        char[] charText = text.toCharArray();
        while (m.find()) {
            char lastLetter = m.group().charAt(m.group().length() - 1);
            charText[m.end() - 1] = Character.toUpperCase(lastLetter);
        }
        return String.valueOf(charText);
    }
}
