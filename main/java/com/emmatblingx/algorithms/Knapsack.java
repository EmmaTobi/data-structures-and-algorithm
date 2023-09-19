package com.emmatblingx.algorithms;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Knapsack Challenge using Greedy algorithm
 * this algorithm is used when there is need for optimization
 */
public class Knapsack {

    Item one = new Item("1", 10, 2);
    Item two = new Item("2", 5, 3);
    Item three = new Item("3", 15, 5);
    Item four = new Item("4", 7, 7);
    Item five = new Item("5", 6, 1);
    Item six = new Item("6", 18, 4);
    Item seven = new Item("7", 3, 1);

    List<Item> items = new ArrayList<>();

    {
        items.add(one);
        items.add(two);
        items.add(three);
        items.add(four);
        items.add(five);
        items.add(six);
        items.add(seven);
    }

    Map<Item, Double> fillBags(int capacity) {
        //get factor from item properties/normalization (p / w)
        //sort descending
        //add item from sorted list sequentially until bag is full
        //to maximise cost
        double total = 0;
        System.out.println(items);
        Collections.sort(items);
        System.out.println(items);

        Map<Item, Double> bag = new HashMap<>();
        int index = items.size();

        if(items.get(items.size() - 1).weight > capacity) return bag;

        while (total <= capacity) {
            if (--index < 0 ) index = items.size() - 1;
            double weight = items.get(index).weight;

            if ((total + weight) <= capacity) {
                total += weight;
                double prevAmount = bag.getOrDefault(items.get(index), 0.0);
                bag.put(items.get(index), prevAmount + weight);
            } else  {
                double fractionalWeight = ((total + weight) - capacity) / weight;
                total +=  fractionalWeight;
                double prevAmount = bag.getOrDefault(items.get(index), 0.0);
                bag.put(items.get(index), prevAmount + Math.floor(fractionalWeight));
            }
        }

        System.out.println(bag);

        return bag;
    }

    class Item implements Comparable<Item>{
        String name;
        double profit;
        double weight;

        public Item(String name, double profit, double weight) {
            this.name = name;
            this.profit = profit;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return name;
        }

        public double getFactor() {
            return profit / weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Item)) return false;

            Item item = (Item) o;

            return name != null ? name.equals(item.name) : item.name == null;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public int compareTo(Item otherItem) {
            return Double.compare(this.getFactor(), otherItem.getFactor());
        }
    }
}
