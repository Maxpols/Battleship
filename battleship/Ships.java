package battleship;



public class Ships {



    public static void initializeShips(String [][] ships) {
        for (int i = 0; i < 5 ;i++) {
            for (int j = 0; j < 5 ;j++) {
                ships[i][j] = "X";
            }
        }
    }

    public static boolean checkShips(String [][] ships) {
        int counter;
        for (int i = 0; i < 5 ;i++) {
            counter = 0;
            for (int j = 0; j < 5 ;j++) {
                if (ships[i][j].equals("X")) {
                    counter++;
                    if (counter == 5) {
                        //Changes a single variable in the array to not match "X" as to not give the same positive boolean
                        ships[i][4] = "D";
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }
        return false;
    }

    public static boolean checkAllShips(String [][] ships) {
        int shipsSunk = 0;
        for (int i = 0; i < 5 ;i++) {
            if (ships[i][4].equals("D")) {
                shipsSunk++;
                if (shipsSunk == 5) {
                    return true;
                }
            }

        }
        return false;
    }



    protected static int shipToFillIn = 0;

    public static void resetShipToFillIn() {
        shipToFillIn = 0;
    }

    public static void fillInShip(int size, String[] placedShips, String[][] ships) {
        for (int i=0; i < size; i++) {
            ships[shipToFillIn][i] = placedShips[i];
        }
        shipToFillIn++;
    }

    public static void blowMe(String input, String[][] ships) {
        for (int i = 0; i < 5 ;i++) {
            for (int j = 0; j < 5; j++) {
                if (ships[i][j].equals(input)) {
                    ships[i][j] = "X";
                }
            }
        }
    }

    public static void printShips(String [][] ships) {
        for (int i = 0; i < 5 ;i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(ships[i][j] + " ");
            }
            System.out.println();
        }
    }
//
//    public static boolean CheckGameEnd() {
//        int gameEnd = 0;
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (!ships[i][j].equals("X")) {
//                    gameEnd++;
//                }
//            }
//        }
//
//        if (gameEnd == 0) {
//            return true;
//        }
//    }

}
