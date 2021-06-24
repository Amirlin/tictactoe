package com.example.demo.game;

import java.util.Arrays;

public class TicTacToe {

    char [][] board=new char[][]{{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    private char lastPlayer = '\0';

    public String play(int xCord, int yCord){

        checkCoordinate(xCord,'x');
        checkCoordinate(yCord,'y');
        setBoard(xCord,yCord);
        printBoard();
        lastPlayer=nextPlayer();
        if (isWin())
            return lastPlayer + " is the Winner";
        else if(isDraw())
            return "The result is draw";
        else
            return "No Winner";
    }

    public boolean isWin(){

        if (checkVerticalWin() || checkHorizontalWin() || checkDiagonalWin())
            return true;
        return false;
    }
    public boolean checkHorizontalWin(){
        for (int index = 0; index < 3; index++) {
            if (board[0][index] == lastPlayer &&
                    board[1][index] == lastPlayer &&
                    board[2][index] == lastPlayer) {
                return true;
            }
        }
        return false;
    }
    public boolean checkVerticalWin(){
        for (int index = 0; index < 3; index++) {
            if (board[index][0] == lastPlayer &&
                    board[index][1] == lastPlayer &&
                    board[index][2] == lastPlayer) {
                return true;
            }
        }
        return false;
    }
    public boolean checkDiagonalWin(){
        int playerTotal=lastPlayer*3;
        if ((board[0][0] + board[1][1] + board[2][2]) == playerTotal) {
            return true;
        }else if (playerTotal == (board[0][2] + board[1][1] + board[2][0]))
            return true;
        return false;
    }
    private boolean isDraw() {
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y] == '\0')
                    return false;
            }
        }
        return true;
    }

    public char nextPlayer(){
        if (lastPlayer == 'X')
            return 'O';
        return 'X';
    }
    private void setBoard(int xCord,int yCord){
        checkBoardEmpty(xCord-1,yCord-1);
        board[xCord-1][yCord-1]=nextPlayer();
    }
    void checkBoardEmpty(int x, int y){
        if (board[x][y]!='\0')
            throw new RuntimeException("Board is occupied");
    }
    void checkCoordinate(int cord, char ch){
        if (cord>3 || cord<1)
            throw new RuntimeException(ch+"Cord is outside the board");
    }

    public void printBoard(){
        System.out.println("*** The Board Is ***");
        System.out.println(Arrays.deepToString(board));
    }

}
