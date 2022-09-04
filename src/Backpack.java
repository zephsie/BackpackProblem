import java.util.List;

public class Backpack {
    private final List<Item> items;
    private final int capacity;
    private final int cost;

    public Backpack(int capacity, List<Item> items) {
        this.items = items;
        this.capacity = capacity;
        this.cost = items.stream().mapToInt(Item::cost).sum();
    }

    public List<Item> getItems() {
        return List.copyOf(items);
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Capacity: ").append(this.capacity).append("\n").append("Cost: ").append(this.cost).append("\n");
        items.forEach(item -> sb.append(item).append("\n"));

        return sb.toString();
    }
}
