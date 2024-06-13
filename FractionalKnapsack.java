import java.util.*;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    // Function to calculate maximum value using Greedy Fractional Knapsack
    public static double fractionalKnapsack(int capacity, List<Item> items) {
        // Sort items by value per unit weight in descending order
        items.sort((a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0;
        int remainingCapacity = capacity;

        // Iterate through each item
        for (Item item : items) {
            if (item.weight <= remainingCapacity) {
                // Take the whole item if it fits
                totalValue += item.value;
                remainingCapacity -= item.weight;
            } else {
                // Otherwise, take a fraction of the item to fill the knapsack
                totalValue += (double) item.value * remainingCapacity / item.weight;
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(10, 60));
        items.add(new Item(20, 100));
        items.add(new Item(30, 120));

        int capacity = 50;

        double maxValue = fractionalKnapsack(capacity, items);
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
