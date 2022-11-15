package swe.cardGame2;

import java.util.Random;
import java.util.Stack;

public class CardDeck {
    private Stack<Card> cardStack;
    private Card[] cards = assignCards();
    private Card topCard;


    public CardDeck(Stack<Card> cardStack) {
        this.cardStack = new Stack<>();
    }


    public CardDeck() {
        cardStack = new Stack<>();
    }

    public void mix() {
        Random random = new Random();
        for(int i = 0; i < cards.length; i++) {
            int index = random.nextInt(cards.length);
            Card k = cards[index];
            cards[index] = cards[i];
            cards[i] = k;
        }
    }

    public void push(Card karte) {
        cardStack.push(karte);
    }

    public CardDeck pushStack(CardDeck cardDeck){
        for (int i = 0; i < cardDeck.cardStack.size(); i++) {
            cardStack.push(cardDeck.cardStack.pop());
        }
        return cardDeck;
    }

    public Stack<Card> pop1() {
        cardStack.pop();
        return cardStack;
    }

    public Card[] assignCards() {
        cards = new Card[52];
        int i = 0;
        for (Colour a: Colour.values()) {
            for (Value b: Value.values()) {
                cards[i] = new Card(a, b);
                i++;
            }
        }
        return cards;
    }

    public int countCards() {
        return cardStack.size();
    }

    public Stack<Card> getCardStack() {
        return cardStack;
    }

    public Card getTopCard() {
        return cardStack.peek();
    }

    public void addPushDeckToPlayer(CardDeck cardDeck) {
        while (!cardStack.isEmpty()) {
            cardDeck.push(cardStack.pop());
        }
    }

    public Stack<Card> fillDeck() {
        cardStack = new Stack<Card>();
        for(int i = 0; i < cards.length; i++) {
            cardStack.add(cards[i]);
        }
        return cardStack;
    }

    public boolean isEmpty() {
        return cardStack.empty();
    }


    @Override
    public String toString() {
        return "CardStack (" +
                "cardStack = " + cardStack +
                ')';
    }
}
