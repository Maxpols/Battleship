package battleship;
import java.util.*;

import static battleship.Battlefield.printField;


public class Main {
    public static void main(String[] args) {
        settings settings = new settings();

        int fieldSize = settings.getFieldSize();

        String[][] battlefieldp1 = new String[fieldSize][fieldSize];
        String[][] battlefieldp2 = new String[fieldSize][fieldSize];
        String[][] foggedFieldp1 = new String[fieldSize][fieldSize];
        String[][] foggedFieldp2 = new String[fieldSize][fieldSize];
        String[] placedshipsp1 = new String[5];
        String[] placedshipsp2 = new String[5];
        String[][] shipsP1 = new String[5][5];
        String[][] shipsP2 = new String[5][5];

        Ships.initializeShips(shipsP1);
        Ships.initializeShips(shipsP2);
        Battlefield.initializePlayingField(fieldSize, foggedFieldp1);
        Battlefield.initializePlayingField(fieldSize, foggedFieldp2);
        Battlefield.initializePlayingField(fieldSize, battlefieldp1);
        Battlefield.initializePlayingField(fieldSize, battlefieldp2);

        System.out.println("Player 1, place your ships on the game field");
        printField(fieldSize, battlefieldp1);
        placeShips(battlefieldp1, placedshipsp1, shipsP1);
        Ships.resetShipToFillIn();
        placementNext();


        System.out.println("Player 2, place your ships on the game field");
        printField(fieldSize, battlefieldp2);
        placeShips(battlefieldp2, placedshipsp2, shipsP2);

        System.out.println("The game starts!");
        printField(settings.fieldSize, foggedFieldp1);
        while (true) {
            nextPlayer(foggedFieldp2, battlefieldp1);
            play(battlefieldp2, foggedFieldp2, shipsP2);
            nextPlayer(foggedFieldp1, battlefieldp2);
            play(battlefieldp1, foggedFieldp1, shipsP1);
        }
    }


    //ship placement and checking
    //->->->->->->->->->->->->->->->->->->->->

    //main method
    static void placeShips(String[][] battlefield, String[] placedships, String[][] ships ) {
        //
        Scanner xyInput = new Scanner(System.in);
        String ship = "Error";

        int shipsize = 404;

        for (int i = 0; i < 5; i++) {
            ship = shipCycling(i, ship);
            shipsize = shipSizeCycling(ship, shipsize);

            boolean valid = false;

            do {
                System.out.printf("Enter the coordinates of the %s (%d cells):\n", ship, shipsize);
                String firstCoordinates = xyInput.next();
                String secondCoordinates = xyInput.next();

                if (validPlacement(firstCoordinates, secondCoordinates, battlefield, shipsize, placedships, ships)) {
                    valid = true;
                }
            }while (!valid);
        }
    }

    //prompting the right ship
    //->->->->->->->->->->
    static String shipCycling(int i, String ship) {
        switch (i) {
            case 0:
                ship = "Aircraft Carrier";
                break;
            case 1:
                ship = "Battleship";
                break;
            case 2:
                ship = "Submarine";
                break;
            case 3:
                ship = "Cruiser";
                break;
            case 4:
                ship = "Destroyer";
                break;
        }
        return ship;
    }

    static int shipSizeCycling(String ship, int shipsize) {
        switch (ship) {
            case "Aircraft Carrier":
                shipsize = 5;
                break;
            case "Battleship":
                shipsize = 4;
                break;
            case "Submarine":
                shipsize = 3;
                break;
            case "Cruiser":
                shipsize = 3;
                break;
            case "Destroyer":
                shipsize = 2;
                break;

        }
        return shipsize;
    }
    //->->->->->->->->->->

    //Check for valid ship placement
    //-->-->-->-->-->-->-->-->-->
    static boolean validPlacement(String first, String second, String[][] battlefield, int size, String[] placedships, String[][] ships) {
        int fieldSize = settings.fieldSize;
        //By passing the string to a new variable we can manipulate it with the toLowerCase method
        String firstPass = first.toLowerCase();
        String secondPass = second.toLowerCase();
        try {
            //intializing the variables
            int firstX;
            int secondX;
            //detects the case that there is a 10 involved making the "normal" implementation unusable. Instead I fixed it with this cheap hack.
            if (firstPass.contains("10") || secondPass.contains("10")) {
                if (firstPass.contains("10")) {
                    firstX = ':';
                } else {
                    firstX = firstPass.charAt(1);
                }

                if (secondPass.contains("10")) {
                    secondX = ':';
                } else {
                    secondX = secondPass.charAt(1);
                }
            } else {
                firstX = firstPass.charAt(1);
                secondX = secondPass.charAt(1);
            }

            //picks out the first char for the y axis, always a char ranging from a to j
            int firstY = firstPass.charAt(0);
            int secondY = secondPass.charAt(0);
            //sets the variables to actual values according to the array
            firstX = firstX - '0';
            secondX = secondX - '0';

            firstY = firstY - '`';
            secondY = secondY - '`';

            int xDifference = firstX - secondX;

            int yDifference = firstY - secondY;

//            boolean validAdjacency = ;


            //Checking if the size is correct, if one of the coordinates is out of bounds the error will be
            // caught and the user will be prompted for another input
            if (xDifference + yDifference == size-1 || xDifference + yDifference == (size-1) * -1 ) {
                if (adjecencyCheck(firstX, firstY, size, battlefield, xDifference, yDifference)) {
                    if (firstY == secondY || firstX == secondX) {


                     placedships[0] = firstPass;




                     battlefield[firstY][firstX] = "O";
                     battlefield[secondY][secondX] = "O";

                     


                     //fills in the hexes in between two outer points
                        //I don't wanna talk about it
                     for (int i = 1; i < size; i++) {
                         if (xDifference > 0) {
                             battlefield[firstY][firstX - i] = "O";
                             placedships[i] = Character.toString((char)firstY + '`') + Character.toString((char)firstX - i + '0') ;
                         } else if (xDifference < 0) {
                             battlefield[firstY][firstX + i] = "O";
                             placedships[i] =  Character.toString((char)firstY + '`') + Character.toString((char)firstX + i + '0');
                         } else if (yDifference > 0) {
                             battlefield[firstY - i][firstX] = "O";
                             placedships[i] =  Character.toString((char)firstY - i + '`') + Character.toString((char)firstX + '0') ;
                         } else if (yDifference < 0) {
                             battlefield[firstY + i][firstX] = "O";
                             placedships[i] = Character.toString((char)firstY + i + '`') + Character.toString((char)firstX + '0') ;
                         }
                     }
                     
                     Ships.fillInShip(size, placedships, ships);

                     printField(fieldSize, battlefield);
                     return true;
                    } else {
                     System.out.println("Error: the input is not diagonal or vertical");
                     return false;
                 }
                } else {
                    System.out.println("Error: The input overlaps with another ship");
                    return false;
                }
            } else {
                System.out.printf("Error: The size was incorrect, should be %d cells \n", size);
                return false;
            }
            //Catches the out of bound error and returns th
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: input not complete/invalid");
            e.getMessage();
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Given coordinates out of bounds(between 1-10 & a-j)");
            e.getMessage();
            return false;
        }
    }

    //this method takes care of the whole adjacency check.
    static boolean adjecencyCheck(int firstX,int firstY, int size, String[][] battlefield, int xDifference, int yDifference) {
        String direction = "Placeholder";
        boolean validAdjecency = true;

        //similar to :182, but this time commands are not immediately executed but instead saved to the direction variable.
        if (xDifference > 0) {
            direction = "W";
        } else if (xDifference < 0) {
            direction = "E";
        } else if (yDifference > 0) {
            direction = "N";
        } else if (yDifference < 0) {
            direction = "S";
        }



        //Iterates through the right direction checking the availability of the coordinates the ship will be placed in
        //and calls the neighbors method every time for the coordinate it is checking.
        for (int i = 0; i < size; i++) {
            switch (direction) {
                case "W":
                    validAdjecency = !battlefield[firstY][firstX - i].equals("O") && neighbors(firstX - i, firstY, battlefield);
                    break;
                case "E":
                    validAdjecency = !battlefield[firstY][firstX + i].equals("O") && neighbors(firstX + i, firstY, battlefield);
                    break;
                case "S":
                    validAdjecency = !battlefield[firstY + i][firstX].equals("O") && neighbors(firstX, firstY + i, battlefield);
                    break;
                case "N":
                    validAdjecency = !battlefield[firstY - i][firstX].equals("O") && neighbors(firstX, firstY - i, battlefield);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + direction);
            }
            if (!validAdjecency) {
                break;
            }
        }
        return validAdjecency;
    }


    //Small method that takes care of the adjecency check with direct neighbors
    static boolean neighbors(int firstX, int firstY, String[][] battlefield) {

        if ((battlefield[firstY + 1][firstX].equals("O") || battlefield[firstY - 1][firstX].equals("O")
             || battlefield[firstY][firstX + 1].equals("O") || battlefield[firstY][firstX - 1].equals("O"))) {
            return false;
        }
        return true;
    }
    //-->-->-->-->-->-->-->-->-->
    //->->->->->->->->->->->->->->->->->->->->


    static void play(String[][] battlefield, String[][] foggedField, String[][] ships) {
        System.out.println("Take a shot!");

        //TODO ships class aanpassen op basis van input hier

        Scanner scan = new Scanner(System.in);

        String unmodInput = scan.next();
        String input = unmodInput.toLowerCase();


            try {
                int y = input.charAt(0);

                int x;
                int inputLength = input.length();
                if (inputLength > 2) {
                    String stringX = input.substring(1);
                    x = Integer.parseInt(stringX);
                } else {
                    x = input.charAt(1);
                    x = x - '0';
                }


                y = y - '`';

            if ((x > 0 && x < 11) && (y > 0 && y < 11)) {
                if (battlefield[y][x].equals("O")) {
                    battlefield[y][x] = "X";
                    foggedField[y][x] = "X";
                    Ships.blowMe(input, ships);
                    if (Ships.checkShips(ships)) {
                        System.out.println("You sank a ship! Specify a new target:");
                    } else {
                        System.out.println("You hit a ship!");
                    }
                } else if(battlefield[y][x].equals("X")) {
                  System.out.println("Error: you already fired at that exact same coordinate once before");
                } else {
                    battlefield[y][x] = "M";
                    foggedField[y][x] = "M";
                    System.out.println("You missed!");
                }
                printField(settings.fieldSize, foggedField);
                if (Ships.checkAllShips(ships)) {
                    System.out.println("You sank the last ship. You won. Congratulations!");
                    System.exit(0);
                }
            } else {
                System.out.println("Error! your coordinates are out of bounds(not on the field)");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error! you entered wrong coordinates! Try again:");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error! your input was insufficient");
        } catch (NumberFormatException e) {
            System.out.println("Error! Input a single character (a to j) and a single number (1 to 10)");
        }
    }

    static void placementNext() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter and pass the move to another player\n");
        while (true) {
            if (scanner.nextLine().isEmpty()) {
                break;
            }
        }
    }



    static void nextPlayer(String[][] foggedfield, String[][] battlefield) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter and pass the move to another player\n");
        while (true) {
            if (scanner.nextLine().isEmpty()) {
                printField(settings.fieldSize, foggedfield);
                System.out.println("---------------------");
                printField(settings.fieldSize, battlefield);
                settings.turn *= -1;
                System.out.println(String.format("Player %d, it's your turn: ",  settings.turn>0?1:2));
                break;
                }
            }
    }


}