
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;
import java.util.List;

//<!> Time Complexity: O(n^4)
public class Day6p2 {
    public static void main(String[] args) throws IOException {
        //get the input from file
        Path path = Paths.get("C:\\Users\\Pixie Waffle\\Desktop\\adventofcode2020\\adventofcode2020\\textfiles\\day6.txt");
        String file = Files.readString(path);

        //The sum of the counts
        int yesQuestionsPerGroup = 0;

        //Split the paragraphs into groups
        List<String> groups = Arrays.asList(file.split("\n\n"));

        //If a character exist as many times as the amount of people then count the question
        for (int i = 0; i < groups.size(); i++) { //For every group
            String[] group = groups.get(i).split("\n"); //Split into persons
            int tmp = 0;
            for (int k = 0; k < group[0].length(); k++) { //How many letters match with the first person
                for (int j = 0; j < group.length; j++) { //Compare with every person in that group
                    if (!group[j].contains(group[0].substring(k, k + 1))) {
                        tmp = 0;
                        break;
                    } else {
                        tmp++;
                    }
                    if (tmp == group.length) {
                        yesQuestionsPerGroup++;
                        tmp = 0;
                    }
                }
            }
        }
        System.out.println(yesQuestionsPerGroup);
    }
}
