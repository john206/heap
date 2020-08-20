import java.util.ArrayList;

public class HeapSort {
    public static ArrayList<Integer> sort(Heap heap) {
        var sorted = new ArrayList<Integer>();

        int popped = heap.pop();

        while (popped != -1) {
            sorted.add(popped);
            popped = heap.pop();
        }

        int i = 0, j = sorted.size() - 1;

        // heap is a max heap, so need to reverse
        while (i < j) {
            int temp = sorted.get(i);
            sorted.set(i++, sorted.get(j));
            sorted.set(j--, temp);
        }

        return sorted;
    }
}
