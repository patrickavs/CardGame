package swe.cardGame2;

//import kotlin.reflect.jvm.internal.ReflectProperties;

public enum Value {
    TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6),
    EIGHT(7), NINE(8), TEN(9), BUBE(10), DAME(11), KOENIG(12), ASS(13);

    private int value;

    Value(int i) {
        this.value = i;
    }
}
