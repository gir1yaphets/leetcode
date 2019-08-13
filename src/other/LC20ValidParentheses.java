package other;

import java.util.ArrayList;
import java.util.List;

public class LC20ValidParentheses {
    public static boolean isValid(String s) {
        Stack openStack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            String value = s.charAt(i) + "";

            switch (value) {
                case "(":
                case "[":
                case "{":
                    openStack.put(value);
                    break;
                default:
                    break;
            }

            if (openStack.getSize() > 0) {
                String stackTopValue = openStack.getValue(openStack.getSize() - 1);
                switch (value) {
                    case ")":
                        if (stackTopValue.equals("(")) {
                            openStack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case "]":
                        if (stackTopValue.equals("[")) {
                            openStack.pop();
                        } else {
                            return false;
                        }
                        break;
                    case "}":
                        if (stackTopValue.equals("{")) {
                            openStack.pop();
                        } else {
                            return false;
                        }
                        break;
                }
            } else {
                return false;
            }
        }

        return openStack.getSize() == 0;
    }

    static class Stack {

        public int getSize() {
            return container.size();
        }

        public String getValue(int index) {
            return container.get(index);
        }

        public List<String> getContainer() {
            return container;
        }

        List<String> container = new ArrayList<>();

        public void put(String s) {
            container.add(s);
        }

        public void pop() {
            container.remove(getSize() - 1);
        }
    }
}
