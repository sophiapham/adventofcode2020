
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        //get the input from file
        File file = new File("C:\\Users\\Pixie Waffle\\Desktop\\adventofcode2020\\adventofcode2020\\textfiles\\day2.txt");
        Scanner sc = new Scanner(file);

        int validPW = 0;

        while (sc.hasNextLine()) {
            String tmp = sc.nextLine();

            //split each line and distribute each substring
            String[] arrTmp = tmp.split("[- :]");
            int minReq = Integer.parseInt(arrTmp[0]);
            int maxReq = Integer.parseInt(arrTmp[1]);
            char reqLetter = arrTmp[2].charAt(0);
            String testPW = arrTmp[4];

            //count the valid passwords
            if (isValidPassword(testPW, reqLetter, minReq, maxReq))
                validPW++;
        }
        System.out.println(validPW);
    }


    //Check is the password is valid
    public static boolean isValidPassword(String testPW, char letter, int minReq, int maxReq) {
        int amountOfSameLetter = 0;
        boolean validPosition = false;
        //if the position of a letter wrong return false
        if(testPW.charAt(minReq-1) == letter && testPW.charAt(maxReq-1) != letter
                || testPW.charAt(minReq-1) != letter && testPW.charAt(maxReq-1) == letter){
            validPosition = true;
        }
        //count how many required letters exist in the password
        for (int i = 0; i < testPW.length(); i++) {
            if (letter == testPW.charAt(i)) {
                amountOfSameLetter++;
            }
        }

        //part1: solution
        //return maxReq>= amountOfSameLetter &&  minReq <= amountOfSameLetter;
        //part2: solution
        return validPosition;
    }
}
