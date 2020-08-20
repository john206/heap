import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

public class HeapTest {

    @Test
    public void heapPushTest() {
        var init = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));

        var heap = new Heap(init);
        var expected = new ArrayList<Integer>(Arrays.asList(70, 40, 60, 10, 30, 20, 50));
        var actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        heap.push(15);
        expected = new ArrayList<Integer>(Arrays.asList(70, 40, 60, 15, 30, 20, 50, 10));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        heap.push(25);
        expected = new ArrayList<Integer>(Arrays.asList(70, 40, 60, 25, 30, 20, 50, 10, 15));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        heap.push(45);
        expected = new ArrayList<Integer>(Arrays.asList(70, 45, 60, 25, 40, 20, 50, 10, 15, 30));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));
    }

    @Test
    public void heapPopTest() {
        var init = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        var heap = new Heap(init);

        var expected = new ArrayList<Integer>(Arrays.asList(70, 40, 60, 10, 30, 20, 50));
        var actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        var popped = heap.pop();
        assertEquals(popped, 70);

        expected = new ArrayList<Integer>(Arrays.asList(60, 40, 50, 10, 30, 20));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        popped = heap.pop();
        assertEquals(popped, 60);

        expected = new ArrayList<Integer>(Arrays.asList(50, 40, 20, 10, 30));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        popped = heap.pop();
        assertEquals(popped, 50);

        expected = new ArrayList<Integer>(Arrays.asList(40, 30, 20, 10));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        popped = heap.pop();
        assertEquals(popped, 40);

        expected = new ArrayList<Integer>(Arrays.asList(30, 10, 20));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        popped = heap.pop();
        assertEquals(popped, 30);

        expected = new ArrayList<Integer>(Arrays.asList(20, 10));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        popped = heap.pop();
        assertEquals(popped, 20);

        expected = new ArrayList<Integer>(Arrays.asList(10));
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        popped = heap.pop();
        assertEquals(popped, 10);

        expected = new ArrayList<Integer>(Arrays.asList());
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        popped = heap.pop();
        assertEquals(popped, -1);

        expected = new ArrayList<Integer>(Arrays.asList());
        actual = heap.getHeap();
        assertTrue(actual.equals(expected));
    }

    @Test
    public void heapSortTest() {
        var init = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));

        var heap = new Heap(init);
        var expected = new ArrayList<Integer>(Arrays.asList(70, 40, 60, 10, 30, 20, 50));
        var actual = heap.getHeap();
        assertTrue(actual.equals(expected));

        var sorted = HeapSort.sort(heap);
        expected = new ArrayList<Integer>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        assertTrue(sorted.equals(expected));
    }
}
