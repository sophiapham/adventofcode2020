
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("C:\\Users\\Pixie Waffle\\Desktop\\adventofcode2020\\adventofcode2020\\textfiles\\day1-input.txt");
        Scanner sc = new Scanner(file);

        int sum = 2020;
        List<Integer> integers = new ArrayList<>();

        while (sc.hasNextInt()) {
                integers.add(sc.nextInt());
        }

        for (int j = 0; j < integers.size(); j++){
            if (integers.contains(sum-integers.get(j))){
                int expenseReport = integers.get(j) * (sum-integers.get(j));
                System.out.println(expenseReport);
                break;
            }
        }

    }
}

