package heap;

// heaps are usually implemented using ARRAYS
// heap[0] is taken as empty
// they're COMPLETE BINARY TREES
// values are stored in array by traversing tree level by level from left to right

// children of kth index = 2*k, 2*k + 1
// parent of kth index = k/2

public class MaxPriorityQueue {

  // in a MAX HEAP each node value is >= than values of its children
  // the MAX value is the root
  private Integer[] heap;
  private int n;

  public MaxPriorityQueue(int capacity) {
    heap = new Integer[capacity + 1]; // heap[0] is empty
    n = 0;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public void insert(int x) {
    if (n == heap.length - 1) {
      resize(2 * heap.length);
    }

    n++;
    heap[n] = x;
    heapify(n);
  }

  // swim -> bottom up heapify
  private void heapify(int k) {
    while (k > 1 && heap[k / 2] < heap[k]) {
      int temp = heap[k];
      heap[k] = heap[k / 2];
      heap[k / 2] = temp;
      k = k / 2;
    }
  }

  private void resize(int capacity) {
    Integer[] temp = new Integer[capacity];
    for (int i = 0; i < heap.length; i++) {
      temp[i] = heap[i];
    }

    heap = temp;
  }

  public void printMaxHeap() {
    for (int i = 1; i < n; i++) {
      System.out.print(heap[i] + " ");
    }
  }

  // sink (top down heapify) -> when we remove max, we have to make it satisfies
  // the heap conditions
  public int deleteMax() {
    int max = heap[1];
    swap(1, n);
    n--;
    sink(1);
    heap[n + 1] = null;
    if (n > 0 && (n == (heap.length - 1) / 4)) {
      resize(heap.length / 2);
    }

    return max;
  }

  public void sink(int k) {
    while (2 * k <= n) {
      int j = 2 * k;
      if (j < n && heap[j] < heap[j + 1]) {
        j++;
      }

      if (heap[k] >= heap[j]) {
        break;
      }

      swap(k, j);
    }
  }

  public void swap(int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
  }

  public static void main(String[] args) {
    MaxPriorityQueue priorityQueue = new MaxPriorityQueue(3);

    priorityQueue.insert(4);
    priorityQueue.insert(5);
    priorityQueue.insert(2);
    priorityQueue.insert(6);
    priorityQueue.insert(1);
    priorityQueue.insert(3);
    System.out.println(priorityQueue.size());
    priorityQueue.printMaxHeap();
  }
}
