package stack;

import java.util.*;

class ElementStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int target = Integer.parseInt(sc.nextLine());
        
        Pilha stack = new Pilha(nums.length);

        for (int i = 0; i < nums.length; i++)
            stack.push(Integer.parseInt(nums[i]));
        
        searchStack(stack, target);

        sc.close();
    }
    
    private static String searchStack(Pilha stack, int target) {
        if (target > stack.size()) {
            return "indice invalido";
        }

        Pilha aux = new Pilha(stack.size());

        int i = stack.size();
        int val = 0;
        while (i > target) {
            aux.push(stack.pop());
        }
        
        val = stack.peek();

        while (i <= stack.size()) {
            stack.push(aux.pop());
        }

        return Integer.toString(val);
    }
}
