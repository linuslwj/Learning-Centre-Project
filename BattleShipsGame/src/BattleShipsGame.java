import java.util.Scanner;

public class BattleShipsGame {
    public static int nRows = 10;
    public static int nCols = 10;
    public static String[][] mapGrid = new String[nRows][nCols];
    public static int playerShips = 5;
    public static int compShips = 5;
    public static int[][] storeMissedGuesses = new int[nRows][nCols];
    public static void main(String[] args) {
        System.out.println("+++WELCOME TO THE BATTLESHIP GAME+++\n");
        System.out.println("Right now, the sea is empty...\n");
        createMap();
        deployPlayerShips();
        deployComputerShips();
        showMap();
        while(playerShips != 0 && compShips != 0 ) {
            Battle();
        }
        gameOver();
    }

    public static void createMap() {
        //Top
        System.out.print("  ");
        for(int i = 0; i < nCols; i++)
            System.out.print(i);
        System.out.println();

        //Middle
        for(int i = 0; i < nRows; i++) {
            System.out.print(i + "|");
            for (int j = 0; j < nCols; j++) {
                mapGrid[i][j] = " ";
                System.out.print(mapGrid[i][j]);
            }
            System.out.print("|" + i);
            System.out.println();
        }
        //Bottom
        System.out.print("  ");
        for(int i = 0; i < nCols; i++)
            System.out.print(i);
        System.out.println();
    }

    public static void deployPlayerShips() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Deploy your ships:");
        for(int i=1;i<= playerShips;) {
            System.out.printf("Enter the X coordinate for Ship %d: ",i);
            int x = input.nextInt();
            if (x<0 || x >9) {
                System.out.println("You CANNOT place ships outside the 10 by 10 grid");
            }
            else {
                System.out.printf("Enter the Y coordinate for Ship %d: ", i);
                int y = input.nextInt();

                if (((y >= 0 && y < 10)) && (!mapGrid[x][y].equals("@"))) {
                    mapGrid[x][y] = "@";
                    i++;
                } else if (((y >= 0 && y < 10)) && (mapGrid[x][y].equals("@"))) {
                    mapGrid[x][y] = "@";
                    System.out.println("You CANNOT place two or more ships on the same location");
                } else {
                    System.out.println("You CANNOT place ships outside the 10 by 10 grid");
                }
            }
        }
    }

    public static void deployComputerShips() {
        System.out.println();
        System.out.println("Computer is deploying ships:");
        int sum = 0;
        for (int i = 1; i <= compShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);
            if(((x>=0 && x <10) && (y>=0 && y <10)) && (!mapGrid[x][y].equals("@")) && (!mapGrid[x][y].equals("2")) ) {
                mapGrid[x][y] = "2";
                sum++;
                i++;
            }
        }
        System.out.printf("%d SHIPS DEPLOYED",sum);
        System.out.println();
    }

    public static void showMap() {
        System.out.println();
        //Top
        System.out.print("  ");
        for (int i = 0; i < nCols; i++) {
            System.out.print(i);
        }
        System.out.println();
        //Middle
        for (int x = 0; x < mapGrid.length; x++) {
            System.out.print(x + "|");
            for (int y = 0; y < mapGrid[x].length; y++) {
                if(mapGrid[x][y].equals("2")) {
                    System.out.print(" ");
                }
                else {
                    System.out.print(mapGrid[x][y]);
                }
            }
            System.out.print("|" + x);
            System.out.println();
        }
        //Bottom
        System.out.print("  ");
        for (int i = 0; i < nCols; i++) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void Battle() {
        playersTurn();
        computersTurn();
        showMap();
        System.out.println();
        System.out.printf("Your ships: %d | Computer ships: %d\n", playerShips,compShips);
    }

    public static void playersTurn() {
        System.out.println();
        System.out.println("YOUR TURN");
        while(true) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the X coordinate: ");
            int x = input.nextInt();
            System.out.println("Enter the Y coordinate: ");
            int y = input.nextInt();

            if ((x >= 0 && x < nRows) && (y >= 0 && y < nCols))
            {
                switch (mapGrid[x][y]) {
                    case "2":
                        System.out.println("Boom! You sunk the ship!");
                        mapGrid[x][y] = "!";
                        --compShips;
                        break;
                    case "@":
                        System.out.println("Oh no, you sunk your own ship :(");
                        mapGrid[x][y] = "x";
                        --playerShips;
                        break;
                    case "!":
                        System.out.println("Ship already sunk. You wasted your turn.");
                        break;
                    case "x":
                        System.out.println("Your ship already sunk. Stop wasting your turn.");
                        break;
                    case "-":
                        System.out.println("You already missed. Stop wasting your turn.");
                        break;
                    default:
                        System.out.println("Sorry, you missed");
                        mapGrid[x][y] = "-";
                        break;
                }
                break;
            }
            else {
                System.out.println("You CANNOT enter coordinates outside the 10 by 10 grid");
            }
            }
        }

    public static void computersTurn() {
        System.out.println();
        System.out.println("COMPUTERS TURN");
        int x = (int) (Math.random() * 10);
        int y = (int) (Math.random() * 10);
        if (mapGrid[x][y].equals("@")) {
            System.out.println("The Computer sunk one of your ships!");
            mapGrid[x][y] = "x";
            --playerShips;
        } else if (mapGrid[x][y].equals("2")) {
            System.out.println("The Computer sunk one of its own ships");
            mapGrid[x][y] = "!";
            --compShips;
        } else {
            if (storeMissedGuesses[x][y] != 1) {
                storeMissedGuesses[x][y] = 1;
                System.out.println("Computer missed. No ship on guessed coordinates.");
            }
            else {
                computersTurn();
            }

        }
    }
        public static void gameOver() {
            if (compShips ==0) {
                System.out.println("You win!\n");
            }
            else {
                System.out.println("Computer won\n");
            }
        }

    }
