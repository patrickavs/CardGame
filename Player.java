package swe.cardGame2;

public class Player {
    private String name;
    private CardDeck gameDeck;
    private CardDeck pushDeck;
    private Card topCard;

    public Player(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardDeck takeGameDeck(CardDeck gameDeck) {
        this.gameDeck = gameDeck;
        return gameDeck;
    }

    public void setTopCard(Card topCard) {
        this.topCard = topCard;
    }

    public Card getTopCard() {
        return topCard;
    }

    public void takeCard() {
        setTopCard(gameDeck.getCardStack().pop());
    }

    public Card topCard() {
        return gameDeck.getCardStack().pop();
    }

    public Card playCard() {
        return topCard;
    }

    public void setPushDeck(CardDeck pushDeck) {
        this.pushDeck = pushDeck;
    }

    public int getAmountOfCards() {
        return gameDeck.countCards();
    }

    public boolean hasCards() {
        if (gameDeck.isEmpty()) {
            return false;
        }
        else return true;
    }

    public CardDeck getDeck() {
        return gameDeck;
    }

    @Override
    public String toString() {
        return "Player (" +
                "name = " + name + '\'' +
                ", gameStack = " + gameDeck +
                ")";
    }
}
