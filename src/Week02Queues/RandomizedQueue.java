package Week02Queues;

import java.util.Iterator;

interface IRandomizedQueue<Item> extends Iterable<Item> {



    // is the randomized queue empty?
    public boolean isEmpty();

    // return the number of items on the randomized queue
    public int size();

    // add the item
    public void enqueue(Item item);

    // remove and return a random item
    public Item dequeue();

    // return a random item (but do not remove it)
    public Item sample();

    // return an independent iterator over items in random order
    public Iterator<Item> iterator();



}

public class RandomizedQueue<Item> implements IRandomizedQueue<Item> {
    // unit testing (required)
    public static void main(String[] args) {}

    private int count = 0;
    protected int capacity = 4;
    private int head = 0;
    private int tail = 0;
    private Item[] items = null;

    public RandomizedQueue() {
        resize(capacity);
    }

    void resize(int newCap) {
        Item[] newItems = (Item[]) new Object[newCap];
        for (int i = 0; i < newCap; i++) {
            newItems = null;
        }

        items = newItems;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void enqueue(Item item) {
        count += 1;

    }

    @Override
    public Item dequeue() {
        count -= 1;
        return null;
    }

    @Override
    public Item sample() {
        return null;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}