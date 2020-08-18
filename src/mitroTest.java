import java.util.Stack;

public class mitroTest {
    public static void main(String[] args) {
        String s="an2[d]r2[o2[i]d]";

        System.out.print(findActualString(s));

    }

    private static String findActualString(String input) {
        int n = input.length();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (input.charAt(i) == '[') {
                stack.push(i);

            }
            if (i+1<n&&input.charAt(i+1) == '[') {
                countStack.push(Integer.parseInt(String.valueOf(input.charAt(i))));
            }
            else
            {
                if(input.charAt(i)!='['&&input.charAt(i)!=']')
                sb.append(input.charAt(i));
            }


            if (input.charAt(i) == ']') {


                for (int j = 0; j < countStack.pop(); j++) {
                    sb.append(input, stack.peek()+1, i);
                }

            }
            while (!stack.isEmpty()){
                sb.append(input, stack.peek()+1, i);
            }



        }
        return sb.toString();


    }


}




