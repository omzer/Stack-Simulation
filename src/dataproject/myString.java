
package dataproject;

import java.util.StringTokenizer;

public class myString {
  private String input;
  Istack operators = new Istack();

  public myString(String s) {
    input = s;
  }

  public String toPostfix() {

    String post = "";
    StringTokenizer tk = new StringTokenizer(input, "+-*/()", true);

    while (tk.hasMoreTokens()) {
      String a = tk.nextToken();
      if (a.equals(")")) {
        while (getPresedence(operators.peek() + "") != 2) {

          post += operators.pop() + " ";
          if (operators.peek() == null) {
            post = correct(post);
            break;
          }
        }
        operators.pop();
        continue;
      }

      if (isNumber(a)) {
        post += a + " ";
        continue;
      }

      if (a.equals("(")) {
        operators.push(a);
        continue;
      }

      if (operators.getSize() == 0 || getPresedence(a) > getPresedence(operators.peek() + "")
          || (operators.peek() + "").equals("("))
        operators.push(a);
      else {
        while (getPresedence(operators.peek() + "") >= getPresedence(a) && operators.getSize() != 0) {
          post += operators.pop() + " ";
        }
        operators.push(a);
      }
    }
    while (operators.getSize() != 0) {
      post += operators.pop() + " ";
    }
    return post;
  }

  private int getPresedence(String s) {
    if (s.charAt(0) == '(')
      return 2;
    if (s.charAt(0) == ')')
      return 3;
    if (s.charAt(0) == '*' || s.charAt(0) == '/')
      return 1;
    if (s.charAt(0) == '+' || s.charAt(0) == '-')
      return 0;
    return 10; // stands for an error
  }

  private boolean isNumber(String s) {
    try {
      Integer.parseInt(s);
    } catch (Exception e) {
      return false;
    }
    return true;
  }

  public String correct(String s) {
    String a = "";
    for (int i = 0; i < s.length(); i++)
      if (s.charAt(i) != '(')
        a += s.charAt(i) + "";
      else {
        i++;
      }
    return a;
  }

}
