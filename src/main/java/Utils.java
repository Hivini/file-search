import java.util.Stack;

public class Utils {

    public static String infixToPrefix(String exp) {
        StringBuilder result = new StringBuilder();
        StringBuilder input = new StringBuilder(exp);
        input.reverse();
        Stack<String> stack = new Stack<>();

        char[] charsExp = new String(input).toCharArray();
        for (int i = 0; i < charsExp.length; i++) {
            if (charsExp[i] == '(') {
                charsExp[i] = ')';
                i++;
            } else if (charsExp[i] == ')') {
                charsExp[i] = '(';
                i++;
            }
        }

        for (int i = 0; i < charsExp.length; i++) {
            String c = charsExp[i] + "";
            if (precendence(c) > 0) {
                while (!stack.isEmpty() && precendence(stack.peek()) >= precendence(c)) {
                    result.append(stack.pop());
                }
                stack.push(c);
            } else if (c.equals(")")) {
                String x = stack.pop();
                while (!x.equals("(")) {
                    result.append(x);
                    x = stack.pop();
                }
            } else if (c.equals("(")) {
                stack.push(c);
            } else {
                StringBuilder num = new StringBuilder();
                int pointer = i;
                while(pointer < charsExp.length
                        && !(charsExp[pointer] + "").equals("(")
                        && !(charsExp[pointer] + "").equals(")")
                        && precendence(charsExp[pointer] + "") < 0) {
                    num.append(charsExp[pointer]);
                    pointer++;
                }
                result.append(num.toString()).append("_");
                i = pointer-1;
            }
        }

        for (int i = 0; i <= stack.size(); i++) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    private static int precendence(String s) {
        switch(s) {
            case "+":
                return 1;
            case "*":
                return 2;
        }
        return -1;
    }


}
