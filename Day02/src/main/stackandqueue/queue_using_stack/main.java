package main.stackandqueue.queue_using_stack;

public class main{
    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println("first element : "+queue.peek());
        System.out.println(queue.dequeue());
        queue.enqueue(6);

        System.out.println("first element : "+queue.peek());
        System.out.println(queue.dequeue());

        System.out.println("first element : "+queue.peek());

    }
 }
