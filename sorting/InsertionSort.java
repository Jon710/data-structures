package sorting;

public class InsertionSort {

  public void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();
  }

  public void sort(int[] arr) {

    // arr[0] is already sorted, so we start from 1
    for (int i = 1; i < arr.length; i++) { // unsorted part
      int temp = arr[i];
      int j = i - 1; // sorted part

      while (j >= 0 && arr[j] > temp) {
        arr[j + 1] = arr[j]; // shifting larger elements to temp by 1
        j = j - 1;
      }
      arr[j + 1] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 5, 1, 2, 9, 10 };

    InsertionSort ls = new InsertionSort();
    ls.sort(arr);
    ls.printArray(arr);
  }

}
