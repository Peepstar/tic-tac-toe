import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class RunGame {

    static int empate;
    static boolean endGame;
    static String[] board;
    static String turn;
    static boolean repeatGame;

    public static void main(String[] args) throws IOException {
        repeatGame = true;
        int position;
        InputStreamReader captureKeyboard = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(captureKeyboard);
        //If user choose 1, game will be repeated
        while(repeatGame) {
            initGame();
            //While no tied result/winner is decided, game goes on
            while (true) {
                //Verify TIED result/Empate
                if (empate == 9) {
                    System.out.println("\n--- EMPATE ---\n");
                    printBoard();
                    break;
                }
                //Check that value is a number and
                System.out.println("Ingrese un numero entre el 1 y 9 para marcar casilla. Turno de:  " + turn);
                position = inputValidPlay(reader);

                //Mark new turn and print updated game table
                newTurn(turn, position);
                printBoard();

                //Check if is there a winner
                endGame = Logica.winnerDecision(board, turn);
                if (Boolean.compare(endGame, true) == 0) {
                    System.out.println("\nWINNER!!!!  " + turn);
                    break;
                }

                //Change turn to X or 0
                changeTurn(turn);
                //Count for tied result/empate
                empate++;
            }
            System.out.println("\nPresione 1 para continuar juego. Presione cualquier otro caracter para finalizar.\n");
            if(!reader.readLine().equals("1")){
                repeatGame = false;
            }
        }
        System.out.println("\nSaliendo de la aplicación\n");

    }




    static void printBoard()
    {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | "
                + board[1] + " | " + board[2]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | "
                + board[4] + " | " + board[5]
                + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | "
                + board[7] + " | " + board[8]
                + " |");
        System.out.println("|---|---|---|");
    }

    static void newTurn (String currentTurn, int posicion){
        board[posicion - 1] = currentTurn;
    }
    static void changeTurn(String currentTurn){
        if(currentTurn.equals("X")){
            turn = "O";
        }
        else{
            turn = "X";
        }
    }

    static int inputValidPlay(BufferedReader reader) throws IOException {
        int tempPosition = 0;

        do {
            try {
                tempPosition = Integer.parseInt(reader.readLine());

                if (tempPosition < 1 || tempPosition > 9) {
                    System.out.println("Input invalido. Numero debe ser entre 1 y 9");
                } else if (Boolean.compare(Logica.protectBox(board, tempPosition), true) == 0) {
                    System.out.println("Escoja una casilla que no haya sido marcada");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input invalido. Elija un numero entero");
            }
        //Repeat loop until all requirements are satisifed.
        } while (tempPosition < 1 || tempPosition > 9 || Boolean.compare(Logica.protectBox(board, tempPosition), true) == 0);

        return tempPosition;
    }


    static void initGame(){
        empate = 0;
        turn = "X";
        board = new String[9];
        //Create and fulfil table game
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
        System.out.println("TIC TAC TOE\n");
        printBoard();
    }


}


