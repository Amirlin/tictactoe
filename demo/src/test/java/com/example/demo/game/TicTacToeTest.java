package com.example.demo.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TicTacToeTest {

    @InjectMocks
    private TicTacToe game;

    @Test
    void whenXOutsideTheBoardThenException() {
        assertThatThrownBy(()->game.play(4,1))
        .isInstanceOf(RuntimeException.class)
        .hasMessage("xCord is outside the board");
    }
    @Test
    void whenYOutsideTheBoardThenException() {
        assertThatThrownBy(()->game.play(1,8))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("yCord is outside the board");
    }
    @Test
    void whenBoardIsOccupiedThenException() {
        game.play(1,1);
        assertThatThrownBy(()->game.play(1,1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Board is occupied");
    }
    @Test
    public void givenFirstTurnWhenNextPlayerThenX() {
        assertThat(game.nextPlayer()).isEqualTo('X');
    }
    @Test
    public void givenLastTurnWasXWhenNextPlayerThenO(){
        game.play(1, 1);
        assertThat(game.nextPlayer()).isEqualTo('O');
    }
    @Test
    public void whenPlayThenNoWinner(){
        assertThat(game.play(1,1)).isEqualTo("No Winner");
    }
    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
         game.play(1, 1); // X
         game.play(1, 2); // O
         game.play(2, 1); // X
         game.play(2, 2); // O
        assertThat(game.play(3,1)).isEqualTo("X is the Winner");

    }
    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        game.play(2, 1); // X
        game.play(1, 1); // O
        game.play(3, 1); // X
        game.play(1, 2); // O
        game.play(2, 2); // X
        assertThat(game.play(1,3)).isEqualTo("O is the Winner");
    }
    @Test
    public void whenPlayAndTopBottomDiagonalLineThenWinner() {
        game.play(1, 1); // X
        game.play(1, 2); // O
        game.play(2, 2); // X
        game.play(1, 3); // O
        assertThat(game.play(3,3)).isEqualTo("X is the Winner");

    }
    @Test
    public void whenPlayAndBottomTopDiagonalLineThenWinner() {
        game.play(1, 3); // X
        game.play(1, 1); // O
        game.play(2, 2); // X
        game.play(1, 2); // O
        assertThat(game.play(3,1)).isEqualTo("X is the Winner");
    }
    @Test
    public void whenAllBoxesAreFilledThenDraw() {
        game.play(1, 1);
        game.play(1, 2);
        game.play(1, 3);
        game.play(2, 1);
        game.play(2, 3);
        game.play(2, 2);
        game.play(3, 1);
        game.play(3, 3);
        assertThat(game.play(3,2)).isEqualTo("The result is draw");

    }

}