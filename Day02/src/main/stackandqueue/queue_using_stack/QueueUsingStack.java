package main.stackandqueue.queue_using_stack;

import java.util.*;

public class QueueUsingStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    //add item to the queue
    public void enqueue(int item) {
        stack1.push(item);
    }

    //delete item from the queue
    public int dequeue() {
        // If both stacks are empty, the queue is empty
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or you can throw an exception
        }

        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    // Peek the front item of the queue
    public int peek() {
        // If both stacks are empty, the queue is empty
        if (stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // or you can throw an exception
        }

        // Transfer elements from stack1 to stack2 if stack2 is empty
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    }


