
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        //get the input from file
        File file = new File("C:\\Users\\Pixie Waffle\\Desktop\\adventofcode2020\\adventofcode2020\\textfiles\\day1.txt");
        Scanner sc = new Scanner(file);

        int sum = 2020;
        List<Integer> integers = new ArrayList<>();

        //add all the integers into a list
        while (sc.hasNextInt()) {
                integers.add(sc.nextInt());
        }

        //check if the list contains three elements that adds up to the sum
        for (int j = 0; j < integers.size(); j++){
            for (int i = 0; i < j; i++) {
                if (integers.contains(sum - integers.get(j) - integers.get(i))) {
                    int expenseReport = integers.get(j) * integers.get(i) * (sum - integers.get(j) - integers.get(i));
                    System.out.println(expenseReport);
                    break;
                }
            }
        }

    }
}
