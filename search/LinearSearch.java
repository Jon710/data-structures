package search;

public class LinearSearch {

  public int search(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        return i;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 5, 1, 9, 2, 10, 15, 20 };

    LinearSearch ls = new LinearSearch();
    System.out.println(ls.search(arr, 9));
  }
}
