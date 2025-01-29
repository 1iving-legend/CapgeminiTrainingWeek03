package main.stackandqueue.sortstack;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, top);



    }

    public static void insertInSortedOrder(Stack<Integer> stack, int value) {

        if(stack.isEmpty()||stack.peek()<value)
        {
            stack.push(value);
            return;
        }

        int temp=stack.pop();
        insertInSortedOrder(stack,value);
        stack.push(temp);
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(21);
        stack.push(3);
        stack.push(9);
        stack.push(55);
        stack.push(6);

        System.out.println("Original Stack: " + stack);

        System.out.println();

        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }



}
