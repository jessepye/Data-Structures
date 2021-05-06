import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTests {
    Stack stack;

    @BeforeEach
    void setup() {
        stack = new Stack();
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty(), "Newly created stack should be empty");
    }

    @Test
    void addOne() {
        assertTrue(stack.isEmpty(), "Stack should be empty before adding elements");
        String expected = "abc";
        stack.push(expected);
        assertFalse(stack.isEmpty(), "Stack should not be empty after adding one element");
        Object result = stack.peek();
        assertEquals(expected, result, "stack.peek() should return the data that was added to the stack");
    }

    @Test
    void addThree() {
        assertTrue(stack.isEmpty(), "Stack should be empty before adding elements");
        String expected = "hij";
        stack.push("abc");
        stack.push("def");
        stack.push(expected);
        assertFalse(stack.isEmpty(), "Stack should not be empty after adding three elements");
        Object result = stack.peek();
        assertEquals(expected, result, "stack.peek() should return the last data that was added to the stack");
    }

    @Test
    void addNone() {
        assertTrue(stack.isEmpty(), "Stack should be empty before adding elements");
        assertThrows(NullPointerException.class, () -> stack.peek(), "stack.peek() should throw a NullPointerException for an empty stack");
    }

    @Test
    void addOneRemoveOne() {
        Integer expected = 123;
        stack.push(expected);
        Object result = stack.pop();
        assertEquals(expected, result, "stack.pop() returns the element that was added to the Stack");
        assertTrue(stack.isEmpty(), "Stack should be empty after adding and removing one element");
    }

    @Test
    void addThreeRemoveOne() {
        Integer expectedRemovedVal = 123;
        Integer expectedPeekVal = 456;
        stack.push(789);
        stack.push(expectedPeekVal);
        stack.push(expectedRemovedVal);
        Object removedVal = stack.pop();
        Object peekVal = stack.peek();
        assertEquals(expectedRemovedVal, removedVal, "stack.remove() should return the first element added");
        assertEquals(expectedPeekVal, peekVal, "After removing one element, stack.peek() should return the new head");
    }

    @Test
    void addThreeRemoveThree() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
        assertTrue(stack.isEmpty(), "Stack should be empty after adding a removing three items");
    }

    @Test
    void addThreeRemoveThreeAddThree() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        assertEquals("third", stack.pop(), "Stack should be work properly after adding and removing items");
        assertEquals("second", stack.pop(), "Stack should be work properly after adding and removing items");
        assertEquals("first", stack.pop(), "Stack should be work properly after adding and removing items");
    }
}