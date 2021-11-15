package sorting;

public class QuickSort {

  public void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }

    System.out.println();
  }

  public int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low;
    int j = low;

    while (i <= high) {
      if (arr[i] <= pivot) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
      i++;
    }

    return j - 1;
  }

  public void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = partition(arr, low, high);
      quickSort(arr, low, pivot - 1);
      quickSort(arr, pivot + 1, high);
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 5, 1, 2, 9, 10 };

    MergeSort ms = new MergeSort();
    // ms.quickSort(arr, 0, arr.length - 1);
    ms.printArray(arr);
  }
}
