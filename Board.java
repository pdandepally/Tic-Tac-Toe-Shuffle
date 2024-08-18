import java.util.*;
import java.lang.*;
import java.io.*;

public class Board {

    Scanner input = new Scanner (System.in);
    int[][] array = new int[3][3];
    
    boolean done = false;
    boolean check = false;
    boolean finish = false;
    int numTurns = 0;
    int row; 
    int column; 
    int r2;
    int c2;
    
    public Board(){}

    public void start(){
        
    array[0][0] = 2;
    array[0][1] = 2;
    array[0][2] = 2;
    array[1][0] = 2;
    array[1][1] = 2;
    array[1][2] = 2;
    array[2][0] = 2;
    array[2][1] = 2;
    array[2][2] = 2;
    
        while (done != true){
            while (check != true){
            if (numTurns <= 5 && numTurns % 2 == 0){
                System.out.println("Player 1, please place a tile.");
                System.out.println("Player 1, please enter your desired row number.");
                row = input.nextInt();
                System.out.println("Player 1, please enter your desired column number.");
                column = input.nextInt();
                    
                if (array[row][column] == 2){
                    array[row][column] = 0;
                    
                    check = true;
                    printGrid();
                    numTurns++;
                    finish = winOrLose();
                    
                    if (finish == true){
                        done = true;
                        System.out.println("Player 1 wins!");
                    }
                }
                        
                else if (array[row][column] == 0 || array[row][column] == 1){
                    System.out.println("There is another tile in this position!");
                }
            }
            else if (numTurns > 5 && numTurns %2 == 0){
                System.out.println("Player 1, please change a tile.");
                System.out.println("Player 1, please enter the row of the tile you wish to change.");
                row = input.nextInt();
                System.out.println("Player 1, please enter the column of the tile you wish to change.");
                column = input.nextInt();
                    
                if (array[row][column] == 0){
                    array[row][column] = 2;
                    System.out.println("Player 1, please enter your new row.");
                    r2 = input.nextInt();
                    System.out.println("Player 1, please enter your new column.");
                    c2 = input.nextInt();
                    array[r2][c2] = 0;
                    
                    check = true;
                    printGrid();
                    numTurns++;
                    finish = winOrLose();
                    
                    if (finish == true){
                        done = true;
                        System.out.println("Player 1 wins!");
                    }
                }
                else {
                    System.out.println("Sorry, that's not valid! Please try again.");
                }
            }
            else if (numTurns <= 5 && numTurns % 2 == 1){
                System.out.println("Player 2, please place a tile.");
                System.out.println("Player 2, please enter your desired row number.");
                row = input.nextInt();
                System.out.println("Player 2, please enter your desired column number.");
                column = input.nextInt();
                    
                if (array[row][column] == 2){
                    array[row][column] = 1;
                    
                    check = true;
                    printGrid();
                    numTurns++;
                    finish = winOrLose();
                    
                    if (finish == true){
                        done = true;
                        System.out.println("Player 2 wins!");
                    }
                }
                        
                else if (array[row][column] == 0 || array[row][column] == 1){
                    System.out.println("There is another tile in this position!");
                }
            }
            
            else if (numTurns > 5 && numTurns %2 == 1){
                System.out.println("Player 2, please change a tile.");
                System.out.println("Player 2, please enter the row of the tile you wish to change.");
                row = input.nextInt();
                System.out.println("Player 2, please enter the column of the tile you wish to change.");
                column = input.nextInt();
                    
                if (array[row][column] == 1){
                    array[row][column] = 2;
                    System.out.println("Player 2, please enter your new row.");
                    r2 = input.nextInt();
                    System.out.println("Player 2, please enter your new column.");
                    c2 = input.nextInt();
                    array[r2][c2] = 1;
                    
                    check = true;
                    printGrid();
                    numTurns++;
                    finish = winOrLose();
                    
                    if (finish == true){
                        done = true;
                        System.out.println("Player 2 wins!");
                    }
                }
                else {
                    System.out.println("Sorry, that's not valid! Please try again.");
                }
            }
            }
        check = false;
        System.out.println();
        }
    }
    
    
    public boolean winOrLose(){
        if (results(array[0][0], array[0][1], array[0][2])){
            return true;
        }
        if (results(array[0][0], array[1][0], array[2][0])){
            return true;
        }
        if (results(array[0][0], array[1][1], array[2][2])){
            return true;
        }
        if (results(array[0][1], array[1][1], array[2][1])){
            return true;
        }
        if (results(array[0][2], array[1][1], array[2][0])){
            return true;
        }
        if (results(array[0][2], array[1][2], array[2][2])){
            return true;
        }
        if (results(array[1][0], array[1][1], array[1][2])){
            return true;
        }
        if (results(array[2][0], array[2][1], array[2][2])){
            return true;
        }
        return false;
    }
    
    public boolean results(int s1, int s2, int s3){
        if (s1 + s2 + s3 < 6){
            if (s1 == 0){
                if (s1 == s2 && s2 == s3){
                    return true;
                }
            }
            else if (s1 == 1){
                if (s1 == s2 && s2 == s3){
                    return true;
                }
            }
        }
        return false;
    }

    public void printGrid(){
        System.out.println("   0  1  2");
        System.out.println("   __ __ __");
        for (int i = 0; i < 3; i++){
            System.out.print(i);
            for (int j = 0; j < 3; j++){
                if (array[i][j] == 0){
                    System.out.print(" |X");
                } 
                else if (array[i][j] == 1){
                    System.out.print(" |O");
                } 
                else {
                    System.out.print(" | ");
                }
            }
            System.out.println(" |\n   __ __ __");
        }
    }
    
}