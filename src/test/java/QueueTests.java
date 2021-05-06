import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTests {
    Queue q;

    @BeforeEach
    void setup() {
        q = new Queue();
    }

    @Test
    void isEmpty() {
        assertTrue(q.isEmpty(), "Newly created queue should be empty");
    }

    @Test
    void addOne() {
        assertTrue(q.isEmpty(), "Queue should be empty before adding elements");
        String expected = "abc";
        q.add(expected);
        assertFalse(q.isEmpty(), "Queue should not be empty after adding one element");
        Object result = q.peek();
        assertEquals(expected, result, "q.peek() should return the data that was added to the queue");
    }

    @Test
    void addThree() {
        // Note: There's no way of accessing the 2nd or 3rd items until q.remove() is implemented
        assertTrue(q.isEmpty(), "Queue should be empty before adding elements");
        String expected = "abc";
        q.add(expected);
        q.add("def");
        q.add("hij");
        assertFalse(q.isEmpty(), "Queue should not be empty after adding three elements");
        Object result = q.peek();
        assertEquals(expected, result, "q.peek() should return the first data that was added to the queue");
    }

    @Test
    void addNone() {
        assertTrue(q.isEmpty(), "Queue should be empty before adding elements");
        assertThrows(NullPointerException.class, () -> q.peek(), "q.peek() should throw a NullPointerException for an empty queue");
    }

    @Test
    void addOneRemoveOne() {
        Integer expected = 123;
        q.add(expected);
        Object result = q.remove();
        assertEquals(expected, result, "q.remove() returns the element that was added to the Queue");
        assertTrue(q.isEmpty(), "Queue should be empty after adding and removing one element");
    }

    @Test
    void addThreeRemoveOne() {
        Integer expectedRemovedVal = 123;
        Integer expectedPeekVal = 456;
        q.add(expectedRemovedVal);
        q.add(expectedPeekVal);
        q.add(789);
        Object removedVal = q.remove();
        Object peekVal = q.peek();
        assertEquals(expectedRemovedVal, removedVal, "q.remove() should return the first element added");
        assertEquals(expectedPeekVal, peekVal, "After removing one element, q.peek() should return the new head");
    }

    @Test
    void addThreeRemoveThree() {
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.remove();
        q.remove();
        assertTrue(q.isEmpty(), "Queue should be empty after adding a removing three items");
    }

    @Test
    void addThreeRemoveThreeAddThree() {
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.remove();
        q.remove();
        q.add("first");
        q.add("second");
        q.add("third");
        assertEquals("first", q.remove(), "Queue should be work properly after adding and removing items");
        assertEquals("second", q.remove(), "Queue should be work properly after adding and removing items");
        assertEquals("third", q.remove(), "Queue should be work properly after adding and removing items");
    }
}