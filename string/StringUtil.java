package string;

public class StringUtil {

  public boolean isPalindrome(String word) {
    char[] charArray = word.toCharArray();
    int start = 0;
    int end = word.length() - 1;

    while (start < end) {
      if (charArray[start] != charArray[end]) {
        return false;
      }

      start++;
      end--;
    }

    return true;
  }

  public static void main(String[] args) {
    StringUtil string = new StringUtil();

    if (string.isPalindrome("madam")) {
      System.out.println("It's a palindrome!");
    } else {
      System.out.println("Not a palindrome!");
    }
  }
}
