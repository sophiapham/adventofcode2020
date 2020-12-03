
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        //get the input from file
        File file = new File("C:\\Users\\Pixie Waffle\\Desktop\\adventofcode2020\\adventofcode2020\\textfiles\\day3.txt");
        Scanner sc = new Scanner(file);

        long treesSlope0 = 0; //Right 1, down 1
        long treesSlope1 = 0; //Right 3, down 1
        long treesSlope2 = 0; //Right 5, down 1
        long treesSlope3 = 0; //Right 7, down 1
        long treesSlope4 = 0; //Right 1, down 2

        List<String> mapOfTrees = new ArrayList<>();

        //Add all the lines into a list
        while (sc.hasNextLine()){
            mapOfTrees.add(sc.nextLine());
        }

        long currentPosition0 = 1, currentPosition1 = 3 ,
                currentPosition2 = 5, currentPosition3 = 7, currentPosition4 = 1;

        for(int i = 1; i < mapOfTrees.size(); i++){
            //TreeSlope0
            long newPosition0 = currentPosition0 + 1;
            if(isTree(mapOfTrees,currentPosition0,i)) treesSlope0++;
            currentPosition0 = newPosition0;

            //TreeSlope1
            long newPosition1 = currentPosition1 + 3;
            if(isTree(mapOfTrees,currentPosition1,i)) treesSlope1++;
            currentPosition1 = newPosition1;

            //TreeSlope2
            long newPosition2 = currentPosition2 + 5;
            if(isTree(mapOfTrees,currentPosition2,i)) treesSlope2++;
            currentPosition2 = newPosition2;

            //TreeSlope3
            long newPosition3 = currentPosition3 + 7;
            if(isTree(mapOfTrees,currentPosition3,i)) treesSlope3++;
            currentPosition3 = newPosition3;

        }

        int pos = 2;
        for(int i = 0; i < (mapOfTrees.size())/2; i++){
            //TreeSlope4
            long newPosition4 = currentPosition4 + 1;
            if(isTree(mapOfTrees,currentPosition4,pos)) treesSlope4++;
            pos = pos + 2;
            currentPosition4 = newPosition4;
        }
        System.out.println(treesSlope0 * treesSlope1 * treesSlope2 * treesSlope3 * treesSlope4);
    }

    public static boolean isTree(List<String> mapOfTrees, long currentPosition, int i){
        //Check if the new position contain a tree, if so count it
        if(mapOfTrees.get(i).substring((int) currentPosition%31).charAt(0) == '#'){
            return true;
        }
        return false;
    }

}
