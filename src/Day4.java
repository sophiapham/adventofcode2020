import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Day4 {
    public static void main(String[] args) throws IOException {
        //get the input from file
        Path path = Paths.get("C:\\Users\\Pixie Waffle\\Desktop\\adventofcode2020\\adventofcode2020\\textfiles\\day4.txt");
        String file = Files.readString(path);

        //Counter for the valid passports
        int validPassports = 0;

        //Split the paragraphs as passports
        List<String> passports = Arrays.asList(file.split("\n\n"));

        //Divide the passport information into keys and values
        List<List<CustomPair>> passportsWithKeyValue = new ArrayList<>();
        for (int i = 0; i < passports.size(); i++){
            String[] splitKeyValue = passports.get(i).split("[: \n]");
            List<CustomPair> tmpPassport = new ArrayList<>();
            for(int j = 0; j < splitKeyValue.length; j+=2){
                CustomPair pair = new CustomPair(splitKeyValue[j], splitKeyValue[j+1]);
                tmpPassport.add(pair);
            }
            passportsWithKeyValue.add(tmpPassport);
        }

        //Check if passport is valid
        for(int i = 0; i < passportsWithKeyValue.size(); i++){
            int correctFields = 0;
            for (int j = 0; j < passportsWithKeyValue.get(i).size(); j++){
                String key = passportsWithKeyValue.get(i).get(j).getKey();
                String val = passportsWithKeyValue.get(i).get(j).getValue();
                //Check if the Field is Valid
                if(isCorrectField(key, val))
                    correctFields++;
            }
            if(correctFields >= 7){
                validPassports++;
            }
        }
        System.out.println(validPassports);
    }

    private static boolean isCorrectField(String key, String val){
        switch (key) {
            //Check Height
            case "hgt":
                String cmOrIn = val.substring(val.length()-2);
                int height = 0;
                if(val.length() > 2)
                    height = Integer.parseInt(val.substring(0, val.length()-2));
                if (cmOrIn.equals("cm")){
                    return height >= 150 && height <= 193;
                }
                if (cmOrIn.equals("in")){
                    return height >= 59 && height <= 76;
                }
            //Check Hair Color
            case "hcl":
                String hashTag = val.substring(0, 1);
                String hairColor = val.substring(1);
                return hashTag.equals("#") && hairColor.length() == 6;
            //Check Eye Color
            case "ecl":
                return val.equals("amb") || val.equals("blu") || val.equals("brn") ||
                        val.equals("gry") || val.equals("grn") || val.equals("hzl") ||
                        val.equals("oth");
            //Check Passport ID
            case "pid":
                return val.length() == 9 && Integer.parseInt(val) > 0;
                default:
                    //Check Birth Year/Issue Year/Expiration Year
                    return isCorrectYear(key, val);
        }
    }
    private static boolean isCorrectYear(String key, String value){
        switch (key){
            //Check Birth Year
            case "byr":
                int byrValue = Integer.parseInt(value);
                return byrValue >= 1920 && byrValue <= 2002;
            //Check Issue Year
            case "iyr":
                int iyrValue = Integer.parseInt(value);
                return iyrValue >= 2010 && iyrValue <= 2020;
            //Check Expiration Year
            case "eyr":
                int eyrValue = Integer.parseInt(value);
                return eyrValue >= 2020 && eyrValue <= 2030;
        }
        return false;
    }

    static class CustomPair{
        private CustomPair(String key, String value){
            this.key = key;
            this.value = value;
        }

        private String key;
        private String value;

        public String getValue() {
            return value;
        }

        public String getKey() {
            return key;
        }
    }
}
