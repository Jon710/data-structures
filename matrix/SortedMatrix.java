package matrix;

public class SortedMatrix {

  public void search(int[][] matrix, int n, int x) {
    int i = 0;
    int j = n - 1;

    while (i < n && j >= 0) {
      if (matrix[i][j] == x) {
        System.out.println("X found at -> " + i + ", " + j);
        return;
      }

      if (matrix[i][j] > x) {
        j--; // go left
      } else {
        i++; // go down
      }
    }

    System.out.println("Value not found!");
  }

  public static void main(String[] args) {
    int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 51 } };

    SortedMatrix m = new SortedMatrix();

    m.search(matrix, matrix.length, 32);
  }
}
