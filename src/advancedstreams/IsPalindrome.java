package advancedstreams;

public class IsPalindrome {
  public static boolean isPalindrome(String string) {
    int num = Integer.parseInt(string);
    int remainder;
    int sum = 0;
    int temp = num;

    while (num > 0) {
      remainder = num % 10;
      sum = sum * 10 + remainder;
      num = num / 10;
    }
    return temp == sum;
  }
}
