import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {

    public static Backpack solve(final int capacity, final Set<Item> itemSet) {
        int numberOfItems = itemSet.size();
        Item[] items = new Item[numberOfItems];
        itemSet.toArray(items);

        Backpack[][] backpacks = new Backpack[numberOfItems + 1][capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            backpacks[0][i] = new Backpack(0, new ArrayList<>());
        }
        for (int i = 1; i <= numberOfItems; i++) {
            backpacks[i][0] = new Backpack(0, new ArrayList<>());
        }

        for (int i = 1; i <= numberOfItems; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (items[i - 1].weight() > j) {
                    backpacks[i][j] = backpacks[i - 1][j];
                } else {
                    if (backpacks[i - 1][j].getCost() > backpacks[i - 1][j - items[i - 1].weight()].getCost() + items[i - 1].cost()) {
                        backpacks[i][j] = backpacks[i - 1][j];
                    } else {
                        List<Item> itemsSet = new ArrayList<>(backpacks[i - 1][j - items[i - 1].weight()].getItems());
                        itemsSet.add(items[i - 1]);
                        backpacks[i][j] = new Backpack(j, itemsSet);
                    }
                }
            }
        }

        return backpacks[numberOfItems][capacity];
    }
}
