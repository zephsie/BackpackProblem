public record Item(String name, int weight, int cost) {

    @Override
    public String toString() {
        return "Item: " + this.name + ", weight: " + this.weight + ", cost: " + this.cost;
    }

    @Override
    public int hashCode() {
        int result;
        result = this.name.hashCode();
        result = 31 * result + this.weight;
        result = 31 * result + this.cost;

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (this.weight != item.weight) {
            return false;
        }
        if (this.cost != item.cost) {
            return false;
        }
        return this.name.equals(item.name);
    }
}
