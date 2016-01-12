package apa.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import apa.tictactoe.game.OutSideBoardException;
import apa.tictactoe.game.PlaceOccupiedException;
import apa.tictactoe.game.TicTacToe;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class TicTacToeUnitTest {

    TicTacToe ticTacToe;

    @Before
    public void setUp(){
        ticTacToe = new TicTacToe();
    }

    @After
    public void tearDown() {
        ticTacToe = null;
    }

    @Test(expected=OutSideBoardException.class)
    public void testWhenInsertOutsideXAxis() throws Exception {
        ticTacToe.play(4,1);
    }

    @Test(expected=OutSideBoardException.class)
    public void testWhenInsertOutsideYAxis() throws Exception {
        ticTacToe.play(1,4);
    }

    @Test(expected=PlaceOccupiedException.class)
    public void testWhenPlaceIsOccupied() throws Exception {
        ticTacToe.play(1,1);
        ticTacToe.play(1,1);
    }


    @Test
    public void testWhenFirstBoxIsOccupiedThenX() throws OutSideBoardException, PlaceOccupiedException{
        assertThat(TicTacToe.X, equalTo(ticTacToe.getTurn()));
    }


    @Test
    public void testWhenSecondBoxIsOccupiedThenO() throws OutSideBoardException, PlaceOccupiedException{
        ticTacToe.play(1,1);
        assertThat(TicTacToe.O, equalTo(ticTacToe.getTurn()));
    }


    @Test
    public void testWhenThirdBoxIsOccupiedThenX() throws OutSideBoardException, PlaceOccupiedException{
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        assertThat(TicTacToe.X, equalTo(ticTacToe.getTurn()));
    }


    @Test
    public void testWhenNoWinner()  throws OutSideBoardException, PlaceOccupiedException{
        Character winner = ticTacToe.play(1, 1);
        assertThat(TicTacToe.NO_WINNER, equalTo(winner));
    }


    @Test
    public void testWhenHorizontalAreXThenWinX()  throws OutSideBoardException, PlaceOccupiedException{
        ticTacToe.play(1,1);
        ticTacToe.play(2,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,2);
        Character winner = ticTacToe.play(1,3);
        assertThat(TicTacToe.X, equalTo(winner));
    }


    @Test
    public void testWhenVerticalAreXThenWinX()  throws OutSideBoardException, PlaceOccupiedException{
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,1);
        ticTacToe.play(1,3);
        Character winner = ticTacToe.play(3,1);
        assertThat(TicTacToe.X, equalTo(winner));
    }


    @Test
    public void testWhenDiagonalAreXThenWinX()  throws OutSideBoardException, PlaceOccupiedException{
        ticTacToe.play(1,1);
        ticTacToe.play(1,2);
        ticTacToe.play(2,2);
        ticTacToe.play(1,3);
        Character winner = ticTacToe.play(3,3);
        assertThat(TicTacToe.X, equalTo(winner));
    }


    @Test
    public void testWhenSecondaryDiagonalAreOThenWinO()  throws OutSideBoardException, PlaceOccupiedException{
        ticTacToe.play(1,1);    //x
        ticTacToe.play(1,3);    //o
        ticTacToe.play(3,3);    //x
        ticTacToe.play(2,2);    //o
        ticTacToe.play(2,3);    //x
        Character winner = ticTacToe.play(3,1);//o
        assertThat(TicTacToe.O, equalTo(winner));
    }


    @Test
    public void testWhenDraw()  throws OutSideBoardException, PlaceOccupiedException{
        ticTacToe.play(1,2);    //x
        ticTacToe.play(1,1);    //o
        ticTacToe.play(2,1);    //x
        ticTacToe.play(1,3);    //o
        ticTacToe.play(2,3);    //x
        ticTacToe.play(2,2);    //0
        ticTacToe.play(3,1);    //x
        ticTacToe.play(3, 2);    //0
        Character draw = ticTacToe.play(3,3);    //x
        assertThat(TicTacToe.DRAW, equalTo(draw));
    }



























}