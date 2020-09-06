package Week02Queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {
    Deque<Integer> deque;

    @BeforeEach
    void setUp() {
        deque = new Deque<>();
    }

    @Test
    void isEmpty() {
        assertTrue(deque.isEmpty());
        deque.addFirst(2);
        assertFalse(deque.isEmpty());
    }

    @Test
    void size() {
        assertEquals(deque.size(), 0);
        deque.addFirst(2);
        assertEquals(deque.size(), 1);
        deque.addLast(3);
        assertEquals(deque.size(), 2);
        deque.addFirst(2);
        assertEquals(deque.size(), 3);
        deque.addLast(3);
        assertEquals(deque.size(), 4);

        deque.removeFirst();
        assertEquals(deque.size(), 3);

        deque.removeLast();
        assertEquals(deque.size(), 2);
    }


    @Test
    void removeFirst() {
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        assertEquals(deque.removeFirst(), 1);
        assertEquals(deque.removeFirst(), 2);
        assertEquals(deque.removeFirst(), 3);
    }

    @Test
    void removeLast() {

        deque.addLast(3);
        deque.addLast(2);
        deque.addLast(1);
        assertEquals(deque.removeLast(), 1);
        assertEquals(deque.removeLast(), 2);
        assertEquals(deque.removeLast(), 3);
    }


    @Test
    void doubleEndedQueue() {
        deque.addFirst(3);
        deque.addFirst(2);
        deque.addFirst(1);
        deque.addLast(4);
        deque.addLast(5);
        deque.addLast(6);

        AtomicInteger i = new AtomicInteger();
        AtomicInteger lastVal = new AtomicInteger();
        deque.forEach(v -> {
            assertEquals(v, i.incrementAndGet());
            lastVal.set(v);
        });
        assertEquals(lastVal.get(), 6);
    }

    @Test
    void throwsWhenAddFirstWithNull() {
        assertThrows(IllegalArgumentException.class, () -> deque.addFirst(null));
    }

    @Test
    void throwsWhenAddLastWithNull() {
        assertThrows(IllegalArgumentException.class, () -> deque.addLast(null));
    }

    @Test
    void throwsWhenDequeueFirstWhenEmpty() {
        assertThrows(NoSuchElementException.class, () -> deque.removeFirst());
    }

    @Test
    void throwsWhenDequeueLastWhenEmpty() {
        assertThrows(NoSuchElementException.class, () -> deque.removeLast());
    }

    @Test
    void iteratorThrowsWhenNoNext() {
        Iterator<Integer> it = deque.iterator();
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }
}