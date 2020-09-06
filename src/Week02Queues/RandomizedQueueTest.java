package Week02Queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedQueueTest {

    RandomizedQueue<Integer> que;

    @BeforeEach
    void setUp() {
        que = new RandomizedQueue<>();
    }

    @Test
    void isEmpty() {
        assertTrue(que.isEmpty());
        que.enqueue(3);
        assertFalse(que.isEmpty());
        que.dequeue();
        assertTrue(que.isEmpty());
    }

    @Test
    void filoWithoutResizing() {
        que.enqueue(1);
        que.enqueue(2);

        assertEquals(que.dequeue(), 1);
        assertEquals(que.dequeue(), 2);
        assertEquals(que.capacity, 4);
    }
}