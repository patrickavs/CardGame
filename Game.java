package swe.cardGame2;

public class Game {
    private Player player1;
    private Player player2;
    private CardDeck gameDeck;
    private Player currentPlayer;

    public Game(Player player1, Player player2, CardDeck cardDeck) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameDeck = cardDeck;
    }

    public void splitDeck() {
        gameDeck.mix();
        gameDeck.fillDeck();
        CardDeck tempStack = new CardDeck();
        for (int i = 0; i < 26; i++) {
            tempStack.getCardStack().push(gameDeck.getCardStack().pop());
        }
        player1.takeGameDeck(tempStack);
        player2.takeGameDeck(gameDeck);
    }

    public int compareCards(Card card1, Card card2) {
        if (card1.getValue().ordinal() < card2.getValue().ordinal()) {
            return 1;
        } else if (card1.getValue().ordinal() == card2.getValue().ordinal()) {
            return 0;
        } else {
            return -1;
        }
    }

    public void changePlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else if (currentPlayer == player2) {
            currentPlayer = player1;
        }
    }

    public void play () {
        splitDeck();
        currentPlayer = player1;
        CardDeck pushDeck = new CardDeck();
        boolean gameFinish = false;
        int turnCount = 0;
        while (gameFinish == false) {
            boolean turnFinish = false;
            turnCount += 1;
            System.out.println("\t --------->Turn: " + turnCount + "<-----------");
            Card card1 = currentPlayer.topCard();
            if (currentPlayer.hasCards()) {
                currentPlayer.takeCard();
                pushDeck.push(currentPlayer.playCard());
                System.out.println(currentPlayer.getName() + " take Card: " + currentPlayer.getTopCard() + ", Cards: " + currentPlayer.getAmountOfCards());
                System.out.println("Cards on PushDeck: " + pushDeck.getTopCard() + "\n");
                changePlayer();
            } else {
                turnFinish = true;
                gameFinish = true;
                changePlayer();
                System.out.println("\t <--------" + currentPlayer.getName() + " has won the game!!!" + ", Cards: " + currentPlayer.getAmountOfCards() + "-------->" + "\n");
            }
            while (turnFinish == false) {
                if (currentPlayer.hasCards()) {
                    Card card2 = currentPlayer.topCard();
                    currentPlayer.takeCard();
                    System.out.println(currentPlayer.getName() + " take Card: " + currentPlayer.getTopCard() + ", Cards: " + currentPlayer.getAmountOfCards());
                    if (compareCards(card1, card2) == 1) {
                        pushDeck.push(currentPlayer.playCard());
                        System.out.println("Cards on PushDeck: " + pushDeck.getTopCard() + "\n");
                        pushDeck.addPushDeckToPlayer(currentPlayer.getDeck());
                        System.out.println("<---------" + currentPlayer.getName() + " has won this turn" + ", Cards: " + currentPlayer.getAmountOfCards() + "--------->" + "\n");
                        turnFinish = true;
                        changePlayer();
                    } else {
                        pushDeck.push(currentPlayer.playCard());
                        System.out.println("Cards on PushDeck: " + pushDeck.getTopCard() + "\n");
                        changePlayer();
                    }
                }
                else {
                    changePlayer();
                    System.out.println("<-------" + currentPlayer.getName() + " has won the game!!!" + ", Cards: " + currentPlayer.getAmountOfCards() + "---------->");
                    turnFinish = true;
                    gameFinish = true;
                }
            }
        }
    }
}
