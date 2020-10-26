package battleship;

public class Battlefield {
    //TODO enum for the two battlefield? try creating a class,
    // the fog of war map and normal battlefield can both be seen as "objects" from the parent class.

    //playing field
    //----------------------------------------
    public static void initializePlayingField(int fieldSize, String[][] battlefield) {
        char yCoords = 'a';
        for (int i = 1; i < fieldSize; yCoords+= 1, i++) {
            //top left corner " "
            battlefield[0][0] = " ";
            //top row 1 to 10
            battlefield[0][i] = Integer.toString(i);
            //left row a to j
            battlefield[i][0] = Character.toString(yCoords);
            for (int j = 1; j < fieldSize; j++) {
                battlefield[i][j] = "~";
            }
        }
    }
    public static void printField(int fieldsize, String[][] battlefield){
        for (int i = 0; i < fieldsize-1; i++) {
            for (int j = 0; j < fieldsize-1; j++) {
                System.out.printf("%s ",battlefield[i][j]);

            }
            System.out.println();
        }
    }
    //----------------------------------------
}
