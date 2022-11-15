package swe.cardGame2;

public class GameTest2 {
    public static void main(String[] args) {
        Player player1 = new Player("Patrick");
        Player player2 = new Player("Niklas");
        CardDeck cardStack1 = new CardDeck();
        //cardStack1.mix();
        //cardStack1.fillDeck();
        Game game1 = new Game(player1, player2, cardStack1);
        game1.play();
    }
}
