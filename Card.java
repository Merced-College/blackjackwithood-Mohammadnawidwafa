//Names: Mohammad Nawid Wafa, Nathan Perez 
//Professor: Kanemoto 
//Class: CPSC-39-12110//*

package cardGame;

public class Card {
    private String suit;
    private String name;
    private int value;
    private String picture;

    // Constructor
    public Card(String suit, String name, int value, String picture) {
        this.suit = suit;
        this.name = name;
        this.value = value;
        this.picture = picture;
    }

    // Getters (Accessors)
    public String getSuit() { return suit; }
    public String getName() { return name; }
    public int getValue() { return value; }
    public String getPicture() { return picture; }

    // Setters (Mutators)
    public void setSuit(String suit) { this.suit = suit; }
    public void setName(String name) { this.name = name; }
    public void setValue(int value) { this.value = value; }
    public void setPicture(String picture) { this.picture = picture; }

    // Override equals method to compare cards based on name (rank)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return name.equals(card.name);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return name + " of " + suit + " (Value: " + value + ")";
    }
}