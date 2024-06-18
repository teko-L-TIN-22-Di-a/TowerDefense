package towers;

public class Card {
    private String label;
    private int cost;

    public Card(String label, int cost) {
        this.label = label;
        this.cost = cost;
    }

    public String getLabel() {
        return label;
    }

    public int getCost() {
        return cost;
    }
}
