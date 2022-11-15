package swe.cardGame2;

public class Card {
    private Colour colour;
    private Value value;

    public Card (Colour colour, Value value) {
        this.colour = colour;
        this.value = value;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card (" +
                "colour = " + colour +
                ", value = " + value +
                ')';
    }
}
