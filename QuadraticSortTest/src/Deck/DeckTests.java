package Deck;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DeckTests {

    @Test
    public void deck_init_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        int expected = 0;
        int actual = deck.get_size();
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void deck_addFront_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.add_front(1);

        int expected = 1;
        int actual = deck.get_size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_addFront_ValueTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.add_front(1);

        int expected = 1;
        int actual = deck.peek_front();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_addBack_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.add_back(1);

        int expected = 1;
        int actual = deck.get_size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_addBack_ValueTest() {
        Deck<Integer> deck = new Deck<Integer>();
        deck.add_back(1);

        int expected = 1;
        int actual = deck.peek_back();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_peekBack_ValueTest() {
        Deck<Integer> deck = new Deck<Integer>();
        deck.add_back(1);

        int expected = 1;
        int actual = deck.peek_back();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_peekFront_ValueTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.add_front(1);

        int expected = 1;
        int actual = deck.peek_front();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_popFront_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.add_front(1);
        deck.add_front(1);
        deck.pop_front();

        int expected = 1;
        int actual = deck.get_size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_popFront_ValueTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.add_front(1);
        deck.add_front(2);
        deck.pop_front();

        int expected = 1;
        int actual = deck.peek_front();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_popBack_sizeTest() {
        Deck<Integer> deck = new Deck<Integer>();

        deck.add_back(1);
        deck.add_back(1);
        deck.pop_back();

        int expected = 1;
        int actual = deck.get_size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void deck_popBack_ValueTest() {
        Deck<Integer> deck = new Deck<Integer>();
        deck.add_back(1);
        deck.add_back(2);
        deck.pop_back();

        int expected = 1;
        int actual = deck.peek_back();
        Assertions.assertEquals(expected, actual);
    }
}