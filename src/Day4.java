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
                //Check is not Null or Empty Value
                if (isNotNullOrEmpty(passportsWithKeyValue.get(i).get(j).getValue())){
                    //Check Birth Year
                    if (passportsWithKeyValue.get(i).get(j).getKey().equals("byr")){
                        int byrValue = Integer.parseInt(passportsWithKeyValue.get(i).get(j).getValue());
                        if (byrValue >= 1920 && byrValue <= 2002){
                            correctFields++;
                        }
                    }
                    //Check Issue Year
                    if (passportsWithKeyValue.get(i).get(j).getKey().equals("iyr")){
                        int iyrValue = Integer.parseInt(passportsWithKeyValue.get(i).get(j).getValue());
                        if (iyrValue >= 2010 && iyrValue <= 2020){
                            correctFields++;
                        }
                    }
                    //Check Expiration Year
                    if (passportsWithKeyValue.get(i).get(j).getKey().equals("eyr")){
                        int eyrValue = Integer.parseInt(passportsWithKeyValue.get(i).get(j).getValue());
                        if (eyrValue >= 2020 && eyrValue <= 2030){
                            correctFields++;
                        }
                    }
                    //Check Height
                    if(passportsWithKeyValue.get(i).get(j).getKey().equals("hgt")){
                        String hgtValue = passportsWithKeyValue.get(i).get(j).getValue();
                        String cmOrIn = hgtValue.substring(hgtValue.length()-2);
                        int height = 0;
                        if(hgtValue.length() > 2)
                            height = Integer.parseInt(hgtValue.substring(0, hgtValue.length()-2));
                        if (cmOrIn.equals("cm")){
                            if(height >= 150 && height <= 193) correctFields++;
                        }
                        if (cmOrIn.equals("in")){
                            if(height >= 59 && height <= 76) correctFields++;
                        }
                    }

                    //Check Hair Color
                    if(passportsWithKeyValue.get(i).get(j).getKey().equals("hcl")){
                        String hclValue = passportsWithKeyValue.get(i).get(j).getValue();
                        String hashTag = hclValue.substring(0, 1);
                        String hairColor = hclValue.substring(1);
                        if (hashTag.equals("#") && hairColor.length() == 6) {
                            correctFields++;
                        }
                    }

                    //Check Eye Color
                    if(passportsWithKeyValue.get(i).get(j).getKey().equals("ecl")){
                        String eclValue = passportsWithKeyValue.get(i).get(j).getValue();
                        if (eclValue.equals("amb") || eclValue.equals("blu") || eclValue.equals("brn") ||
                                eclValue.equals("gry") || eclValue.equals("grn") || eclValue.equals("hzl") ||
                                eclValue.equals("oth"))
                        {
                            correctFields++;
                        }
                    }

                    //Check Passport ID
                    if(passportsWithKeyValue.get(i).get(j).getKey().equals("pid")){
                        String pidValue = passportsWithKeyValue.get(i).get(j).getValue();
                        if(pidValue.length() == 9) {
                            int pid = Integer.parseInt(pidValue);
                            if (pid > 0){
                                correctFields++;
                            }
                        }
                    }
                }
            }
            if(correctFields >= 7){
                validPassports++;
            }
        }
        System.out.println(validPassports);
    }

    private static boolean isNotNullOrEmpty(String str){
        return (str != null && !"".equals(str));
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
