package utils;

public class StringReplacer {
    private String str;
    private String replacesString;

    public String removeSymbols(String str){
        String temp = str.replaceAll("[\\s\\$]", "");
        return replacesString = temp.replaceAll("[\\,]", ".");
    }
}
