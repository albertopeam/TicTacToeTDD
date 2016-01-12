package apa.tictactoe.game;

/**
 * Created by alberto on 11/1/16.
 */
public class TicTacToe {

    public static final Character X = 'X';
    public static final Character O = 'O';
    public static final Character NO_WINNER = '-';
    public static final Character DRAW = '=';
    private Character[][] board = {{'\0', '\0', '\0'},
                                   {'\0', '\0', '\0'},
                                   {'\0', '\0', '\0'}};
    private Character turn = X;


    public Character play(int xAxis, int yAxis) throws OutSideBoardException, PlaceOccupiedException{
        checkXAxisPosition(xAxis);
        checkYAxisPosition(yAxis);
        checkOccupiedPosition(xAxis, yAxis);
        setBox(xAxis, yAxis, getTurn());
        Character currentTurn = turn;
        updateTurn();
        if (checkIfWinner()) {
            return currentTurn;
        }else if(isDraw()){
            return DRAW;
        }else {
            return NO_WINNER;
        }
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


    private void setBox(int xAxis, int yAxis, Character thisTurn){
        board[xAxis - 1][yAxis - 1] = thisTurn;
    }


    private void updateTurn(){
        if (turn == 'X'){
            turn = O;
        }else if(turn == 'O'){
            turn = X;
        }
    }


    private Boolean checkIfWinner(){
        for (int i=0;i<board.length;i++){
            if (!board[i][0].equals('\0') && board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])){
                return Boolean.TRUE;
            }
            if (!board[0][i].equals('\0') && board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])){
                return Boolean.TRUE;
            }
        }
        if (!board[0][0].equals('\0') && board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])){
            return Boolean.TRUE;
        }
        if (!board[2][0].equals('\0') && board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])){
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    private Boolean isDraw(){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j].equals('\0')){
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }
}
