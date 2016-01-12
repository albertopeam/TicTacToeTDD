package apa.tictactoe.game;

/**
 * Created by alberto on 11/1/16.
 */
public class TicTacToe {

    public static final Character X = 'X';
    public static final Character O = 'O';
    private Character[][] board = {{'\0', '\0', '\0'},
                                   {'\0', '\0', '\0'},
                                   {'\0', '\0', '\0'}};
    private Character turn = X;


    public void play(int xAxis, int yAxis) throws OutSideBoardException, PlaceOccupiedException{
        checkXAxisPosition(xAxis);
        checkYAxisPosition(yAxis);
        checkOccupiedPosition(xAxis, yAxis);
        setBox(xAxis, yAxis);
        updateTurn();
    }


    public Character getTurn(){
        return turn;
    }


    private void checkXAxisPosition(int xAxis) throws OutSideBoardException{
        if (xAxis < 1 || xAxis > 3){
            throw new OutSideBoardException();
        }
    }


    private void checkYAxisPosition(int yAxis) throws OutSideBoardException{
        if(yAxis < 1 || yAxis > 3){
            throw new OutSideBoardException();
        }
    }


    private void checkOccupiedPosition(int xAxis, int yAxis) throws PlaceOccupiedException{
        if(board[xAxis - 1][yAxis - 1] != '\0'){
            throw new PlaceOccupiedException();
        }
    }


    private void setBox(int xAxis, int yAxis){
        board[xAxis - 1][yAxis - 1] = 'X';
    }


    private void updateTurn(){
        if (turn == 'X'){
            turn = O;
        }else if(turn == 'O'){
            turn = X;
        }
    }
}
