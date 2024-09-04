package CrackingTheCodingInterview.Questions.Chap3StacksQueues;

import Common.MyStack;

public class C3Q4_QueueViaStacks {
    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>();
        q.push(1);
        q.push(4);
        q.push(5);
        q.push(2);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}

class MyQueue<T> {
    private final MyStack<T> s1;
    private final MyStack<T> s2;

    public MyQueue() {
        s1 = new MyStack<>();
        s2 = new MyStack<>();
    }

    public void push(T item) {
        s1.push(item);
    }

    public T pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        T item = s2.pop();
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        return item;
    }
}
