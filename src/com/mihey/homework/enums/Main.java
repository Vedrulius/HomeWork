package com.mihey.homework.enums;

public class Main {
    public static void main(String[] args) {
        for (Planets p : Planets.values()) {
            System.out.println("My weight on planet " + p + " is " + p.getMyMassOnPlanet(75) + " kg");
        }
    }
}

enum CardSuit {
    HEARTS, SPADES, DIAMONDS, CLUBS
}

enum CardRanks {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11),
    QUEEN(12), KING(13);

    private int rank;

    CardRanks(int i) {
        rank = i;
    }

    public int getRank() {
        return rank;
    }
}

enum Planets {
    MERCURY(0.26), VENUS(0.9), EARTH(1), MARS(0.37), JUPITER(2.64), SATURN(1.13);

    private double weightCoef;

    Planets(double weightCoef) {
        this.weightCoef = weightCoef;
    }

    public double getMyMassOnPlanet(int earthweight) {
        return earthweight * weightCoef;
    }
}
