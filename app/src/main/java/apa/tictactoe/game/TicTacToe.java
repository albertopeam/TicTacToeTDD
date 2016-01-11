package apa.tictactoe.game;

/**
 * Created by alberto on 11/1/16.
 */
public class TicTacToe {


    private Character[][] board = {{'\0', '\0', '\0'},
                                   {'\0', '\0', '\0'},
                                   {'\0', '\0', '\0'}};


    public void play(int xAxis, int yAxis) throws OutSideBoardException, PlaceOccupiedException{
        if (xAxis < 1 || xAxis > 3){
            throw new OutSideBoardException();
        }else if(yAxis < 1 || yAxis > 3){
            throw new OutSideBoardException();
        }else if(board[xAxis][yAxis] != '\0'){
            throw new PlaceOccupiedException();
        }
        board[xAxis][yAxis] = 'X';
    }
}
