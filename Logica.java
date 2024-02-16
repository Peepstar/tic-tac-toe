import java.io.IOException;
import java.util.*;

public class Logica {

    public static boolean winnerDecision(String[] currGame, String currTurn) {
        ArrayList<Integer> positionsOnTable = new ArrayList<>();
        for (int i = 0; i < currGame.length; i++) {
            if (currGame[i].equals(currTurn)) {
                positionsOnTable.add(i + 1);
            }
        }
        //Check all possible cases for a winner
        if (positionsOnTable.contains(1) && positionsOnTable.contains(2) && positionsOnTable.contains(3)) {
            return true;
        } else if (positionsOnTable.contains(1) && positionsOnTable.contains(4) && positionsOnTable.contains(7)) {
            return true;
        } else if (positionsOnTable.contains(1) && positionsOnTable.contains(5) && positionsOnTable.contains(9)) {
            return true;
        } else if (positionsOnTable.contains(2) && positionsOnTable.contains(5) && positionsOnTable.contains(8)) {
            return true;
        } else if (positionsOnTable.contains(3) && positionsOnTable.contains(6) && positionsOnTable.contains(9)) {
            return true;
        } else if (positionsOnTable.contains(3) && positionsOnTable.contains(5) && positionsOnTable.contains(7)) {
            return true;
        } else if (positionsOnTable.contains(4) && positionsOnTable.contains(5) && positionsOnTable.contains(6)) {
            return true;
        } else if (positionsOnTable.contains(7) && positionsOnTable.contains(8) && positionsOnTable.contains(9)) {
            return true;
        }
        //No winner yet
        return false;
    }

    //Avoid that the same box is played more than once
    public static boolean protectBox(String[] currGame, int position) {
        if(position > 9) {
            return true;
        }
        if(currGame[position - 1].equals("X") || currGame[position - 1].equals("O")) {
            return true;
        }

        return false;
    }


}





