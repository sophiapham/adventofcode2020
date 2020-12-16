import javax.xml.stream.events.Characters;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6 {
    public static void main(String[] args) throws IOException {
        //get the input from file
        Path path = Paths.get("C:\\Users\\Pixie Waffle\\Desktop\\adventofcode2020\\adventofcode2020\\textfiles\\day6.txt");
        String file = Files.readString(path);

        //The sum of the counts
        int yesPerGroup = 0;

        //Split the paragraphs into groups
        List<String> groups = Arrays.asList(file.split("\n\n"));

        //The Hashset does not accept duplicates so we can check each group
        //by adding it to the hashset and clearing after we have counted the
        //unique characters
        Set set = new HashSet<>();
        for (int i = 0; i < groups.size(); i++){
            char[] group = groups.get(i).replace("\n", "").toCharArray();
            for (int j = 0; j < group.length; j++){
                if(set.add(group[j])){
                    yesPerGroup++;
                }
            }
            set.clear();
        }
        System.out.println(yesPerGroup);
    }
}
