package Week02Queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;

interface IDeque<Item> extends Iterable<Item> {


    // is the deque empty?
    public boolean isEmpty();

    // return the number of items on the deque
    public int size();

    // add the item to the front
    public void addFirst(Item item);

    // add the item to the back
    public void addLast(Item item);

    // remove and return the item from the front
    public Item removeFirst();

    // remove and return the item from the back
    public Item removeLast();

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator();

}

public class Deque<T> implements IDeque<T> {
    private class Node {
        T value;
        Node next;
        Node prev;

        public Node(T value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    Node first = null;
    Node last = null;
    int size = 0;


//    @Override
//    public void forEach(Consumer<? super T> action) {
//        for (T t : this) {
//            action.accept(t);
//        }
//    }
//
//    @Override
//    public Spliterator<T> spliterator() {
//        return null;
//    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);
        int i = 0;
        int lastVal = 0;
        for (int v : deque) {
            assertEquals(v, ++i);
            lastVal = v;
        }
        System.out.println(lastVal);
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void addFirst(T item) {
        assertNonNull(item);
        Node oldFirst = first;
        first = new Node(item, oldFirst, null);
        if (last == null) {
            last = first;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        assertNonNull(item);
        Node oldLast = last;
        Node newNode = new Node(item, null, last);
        if (oldLast != null) {
            oldLast.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = last;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (first == null) throw new NoSuchElementException();
        Node node = first;
        first = node.next;
        size--;
        return node.value;
    }

    @Override
    public T removeLast() {
        if (last == null) throw new NoSuchElementException();
        Node oldLast = last;
        last = oldLast.prev;
        size--;
        return oldLast.value;
    }

    private void assertNonNull(T item) {
        if (item == null) throw new IllegalArgumentException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node cursor = first;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                Node curr = cursor;
                if (curr == null) throw new NoSuchElementException();
                cursor = curr.next;
                return curr.value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
