import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {
    Node node;
    LinkedList linkedList;

    @BeforeEach
    public void setup() {
        linkedList = new LinkedList();
    }

    @Test
    public void initializeLinkedListTest() {
        assertNull(linkedList.getHead(), "linked lists are initialized with a null head node");
    }

    @Test
    public void isEmptyNewObjectTest() {
        assertTrue(linkedList.isEmpty(), "getEmpty should return true for newly created linkedList objects");
    }

    @Test
    public void addOneTest() {
        assertTrue(linkedList.isEmpty());
        linkedList.add(456);
        assertFalse(linkedList.isEmpty());
        assertEquals(456, linkedList.getFirst());
        assertEquals(456, linkedList.getLast());
    }

    @Test
    public void addThreeTest() {
        assertTrue(linkedList.isEmpty());
        linkedList.add(101);
        linkedList.add(102);
        linkedList.add(103);
        assertFalse(linkedList.isEmpty());
        assertEquals(101, linkedList.getFirst());
        assertEquals(103, linkedList.getLast());
    }

    @Test
    public void addThreeFirstTest() {
        assertTrue(linkedList.isEmpty());
        linkedList.addFirst(101);
        linkedList.addFirst(102);
        linkedList.addFirst(103);

        assertFalse(linkedList.isEmpty());
        assertEquals(103, linkedList.getFirst());
        assertEquals(101, linkedList.getLast());
    }

    @Test
    public void addThreeLastTest() {
        // Setup
        assertTrue(linkedList.isEmpty());
        linkedList.addLast(101);
        linkedList.addLast(102);
        linkedList.addLast(103);

        assertFalse(linkedList.isEmpty());
        assertEquals(101, linkedList.getFirst());
        assertEquals(103, linkedList.getLast());
    }

    @Test
    public void deleteMiddleNodeTest() {
        // Setup
        linkedList.add("abc");
        linkedList.add("def");
        linkedList.add("ghi");

        // Execute:
        linkedList.remove("def");

        // Test:
        assertEquals("abc", linkedList.getFirst());
        assertEquals("ghi", linkedList.getLast());
    }

    @Test
    public void deleteFirstNodeTest() {
        // Setup
        linkedList.add("abc");
        linkedList.add("def");
        linkedList.add("ghi");

        // Execute:
        linkedList.remove("abc");

        // Test:
        assertEquals("def", linkedList.getFirst());
        assertEquals("ghi", linkedList.getLast());
    }

    @Test
    public void deleteLastNodeTest() {
        // Setup
        linkedList.add("abc");
        linkedList.add("def");
        linkedList.add("ghi");

        // Execute:
        linkedList.remove("ghi");

        // Test:
        assertEquals("abc", linkedList.getFirst());
        assertEquals("def", linkedList.getLast());
    }

    @Test
    public void getNodeFromEmptyLinkedListTest() {
        // Setup
        //   nothing

        // Test:
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));

    }

    @Test
    public void getFirstNodeTest() {
        // Setup
        linkedList.add(1.23);
        linkedList.add(3.45);
        linkedList.add(6.78);

        // Execute:
        Object result = linkedList.get(0);

        // Test:
        assertEquals(1.23, result);

    }

    @Test
    public void getMiddleNodeTest() {
        // Setup
        linkedList.add(1.23);
        linkedList.add(3.45);
        linkedList.add(6.78);

        // Execute:
        Object result = linkedList.get(1);

        // Test:
        assertEquals(3.45, result);

    }

    @Test
    public void getLastNodeTest() {
        // Setup
        linkedList.add(1.23);
        linkedList.add(3.45);
        linkedList.add(6.78);

        // Execute:
        Object result = linkedList.get(2);

        // Test:
        assertEquals(6.78, result);

    }

    @Test
    public void getNegativeIndexTest() {
        // Setup
        linkedList.add(1.23);
        linkedList.add(3.45);
        linkedList.add(6.78);

        // Test:
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));

    }

    @Test
    public void getOutOfBoundsIndexTest() {
        // Setup
        linkedList.add(1.23);
        linkedList.add(3.45);
        linkedList.add(6.78);

        // Test:
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(4));

    }

    @Test
    public void containsReturnsNeg1OnEmptyLinkedListTest() {
        assertEquals(-1, linkedList.contains('a'));
    }

    @Test
    public void containsReturnsFirstNodeIndexTest() {
        linkedList.add('a');
        linkedList.add('b');
        linkedList.add('c');
        assertEquals(0, linkedList.contains('a'));
    }

    @Test
    public void containsReturnsLastNodeIndexTest() {
        linkedList.add('a');
        linkedList.add('b');
        linkedList.add('c');
        assertEquals(2, linkedList.contains('c'));
    }

    @Test
    public void deleteObjectFromEmptyLinkedListTest() {

        assertEquals(-1, linkedList.contains("a"));

        linkedList.delete("a");

        assertEquals(-1, linkedList.contains("a"), "Nothing should happen when deleting from an empty linked list");

    }

    @Test
    public void deleteObjectFromBeginningLinkedListTest() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertEquals(0, linkedList.contains("a"));

        linkedList.delete("a");

        assertEquals(-1, linkedList.contains("a"), "\"a\" should have been deleted from the linked list");

    }

    @Test
    public void deleteObjectFromMiddleLinkedListTest() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertEquals(1, linkedList.contains("b"));

        linkedList.delete("b");

        assertEquals(-1, linkedList.contains("b"), "\"b\" should have been deleted from the linked list");

    }

    @Test
    public void deleteObjectFromEndLinkedListTest() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertEquals(2, linkedList.contains("c"));

        linkedList.delete("c");

        assertEquals(-1, linkedList.contains("c"), "\"c\" should have been deleted from the linked list");

    }

    @Test
    public void deleteObjectUsingIndexFromBeginningLinkedListTest() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertEquals(0, linkedList.contains("a"));

        linkedList.delete(0);

        assertEquals(-1, linkedList.contains("a"), "\"a\" should have been deleted from the linked list");

    }

    @Test
    public void deleteObjectUsingIndexFromMiddleLinkedListTest() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertEquals(1, linkedList.contains("b"));

        linkedList.delete(1);

        assertEquals(-1, linkedList.contains("b"), "\"b\" should have been deleted from the linked list");

    }

    @Test
    public void deleteObjectUsingIndexFromEndLinkedListTest() {
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");

        assertEquals(2, linkedList.contains("c"));

        linkedList.delete(2);

        assertEquals(-1, linkedList.contains("c"), "\"c\" should have been deleted from the linked list");

    }

    @Test
    public void deleteUsingIndexFromEmptyLinkedList() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.delete(0));
    }

    @Test
    public void deleteWithOutOfBoundsIndex() {
        linkedList.add("abc");
        linkedList.add("def");
        linkedList.add("hij");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.delete(3), "should throw an IndexOutOfBoundsException when deleting the 3rd index in a list with 3 items");
    }
}

