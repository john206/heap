import java.util.ArrayList;

public class Heap {
    private ArrayList<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public Heap(ArrayList<Integer> init) {
        this.heap = new ArrayList<>();
        for (int i: init) {
            push(i);
        }
    }

    public ArrayList<Integer> getHeap() {
        return heap;
    }

    public void push(int i) {
        // insert item onto tail. heapify.
        heap.add(i);
        heapify();
    }

    public int pop() {
        // remove head. insert tail at head. heapify.
        if (heap.size() == 0) return -1;

        int popped = heap.get(0);
        int last = heap.get(heap.size() - 1);
        heap.remove(heap.size() - 1);

        if (heap.size() == 0) return popped;

        heap.set(0, last);

        heapify();
        return popped;
    }

    public void heapify() {
        // start from leaf. while parent < max(lc , rc) swap parent with max child
        if (heap.isEmpty() || heap.size() < 2) return;

        for (int i = heap.size() - 1; i > 0; i = getParent(i)) {
            while (i > 0 && heap.get(getParent(i)) < heap.get(i)) {

                int lc, rc;

                int parent = getParent(i);

                lc = getLeft(parent);
                rc = getRight(parent);

                int maxChild;
                if (rc >= heap.size()) {
                    maxChild = lc;
                } else {
                    maxChild = heap.get(lc) > heap.get(rc) ? lc : rc;
                }

                int parentVal = heap.get(parent);
                int childVal = heap.get(maxChild);

                if (parentVal < childVal) {
                    int temp = parentVal;
                    heap.set(parent, childVal);
                    heap.set(maxChild, temp);
                }

                i = parent;
            }
        }
    }

    private int getLeft(int parent) {
        return 2 * parent + 1;
    }

    private int getRight(int parent) {
        return 2 * parent + 2;
    }

    private int getParent(int child) {
        return (child - 1) / 2;
    }
}
