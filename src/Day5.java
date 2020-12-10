import java.io.File;
import java.io.IOException;
import java.util.*;

class Day5 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Pixie Waffle\\Desktop\\adventofcode2020\\adventofcode2020\\textfiles\\day5.txt");
        Scanner sc = new Scanner(file);

        List<String> boardingPasses = new ArrayList<>();

        //Add all the lines into a list
        while (sc.hasNextLine()){
            boardingPasses.add(sc.nextLine());
        }

        ArrayList<Integer> seatIDs = new ArrayList<>();

        //add all the seatIDs into a list
        for (int i = 0; i < boardingPasses.size(); i++){
            seatIDs.add(seatID(boardingPasses.get(i)));
        }

        //print out the highest seat ID
        System.out.println("Highest Seat ID: " + Collections.max(seatIDs));
        //My seat ID
        System.out.println("Your Seat ID: " + mySeatID(seatIDs));
    }

    //get seatID
    private static int seatID(String boardingPass){
        double rowUp = 127, rowLow = 0, row;
        double colUp = 7, colLow = 0, col;
        String rowChar = boardingPass.substring(0,7);
        String colChar = boardingPass.substring(7);

        //Check the row
        for (int i = 0; i < rowChar.length()-1; i++){
            double binSpaces = Math.pow(2, (6-i));
            String rowLetter = rowChar.substring(i, i+1);
            if("B".equals(rowLetter)){
                rowLow = rowLow + binSpaces;
            }
            else {
                rowUp = rowUp - binSpaces;
            }
        }
        //Check the column
        for (int i = 0; i < colChar.length()-1; i++){
            double binSpaces = Math.pow(2, (2-i));
            String colLetter = colChar.substring(i,i+1);
            if("R".equals(colLetter)){
                colLow = colLow + binSpaces;
            }
            else {
                colUp = colUp - binSpaces;
            }
        }

        //Return the correct row/col from the final character
        if(rowChar.substring(6,7).equals("B"))
            row = rowUp;
        else
            row = rowLow;
        if(colChar.substring(2,3).equals("R"))
            col = colUp;
        else
            col = colLow;

        //Return the seatID
        return ((int) (row * 8 + col));
    }

    //get my seat ID
    private static int mySeatID(ArrayList<Integer> seatIDs){
        for(int i = 0; i < seatIDs.size(); i++){
            if(!seatIDs.contains(seatIDs.get(i)+1))
                return seatIDs.get(i)+1;
        }
        return 0;
    }
}

