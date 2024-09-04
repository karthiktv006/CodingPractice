package CrackingTheCodingInterview.Questions.Chap3StacksQueues;

import Common.MyStack;

import java.util.EmptyStackException;

public class C3Q2_StackMin {
    public static void main(String[] args) {
        MyStackMin<Integer> stack = new MyStackMin<>();
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.push(10);
        stack.push(4);
        stack.push(2);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());

        System.out.println("====");

        MyStackMin2 stack2 = new MyStackMin2();
        stack2.push(5);
        stack2.push(3);
        stack2.push(4);
        stack2.push(10);
        stack2.push(4);
        stack2.push(2);
        System.out.println(stack2.min());
        System.out.println(stack2.pop());
        System.out.println(stack2.min());
        System.out.println(stack2.pop());
        System.out.println(stack2.pop());
        System.out.println(stack2.min());
        System.out.println(stack2.pop());
        System.out.println(stack2.min());
        System.out.println(stack2.pop());
        System.out.println(stack2.min());
    }
}

class MyStackMin<Integer> {
    private static class StackNode<Integer> {
        public int data;
        public StackNode<Integer> next;
        public StackNode<Integer> nextMin;

        public StackNode(int data) {
            this.data = data;
        }
    }

    private StackNode<Integer> top;
    private StackNode<Integer> minTop;

    public int pop() {
        if (top == null) throw new EmptyStackException();
        int item = top.data;
        int minItem = minTop.data;
        top = top.next;
        if (item == minItem) {
            minTop = minTop.nextMin;
        }
        return item;
    }

    public void push(int item) {
        StackNode<Integer> t = new StackNode<>(item);
        if (minTop == null) {
            t.nextMin = minTop;
            minTop = t;
        }
        if (item < minTop.data) {
            t.nextMin = minTop;
            minTop = t;
        }
        t.next = top;
        top = t;
    }

    public int min() {
        if (minTop == null) throw new EmptyStackException();
        return minTop.data;
    }

    public int peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

class MyStackMin2 extends MyStack<Integer> {
    public MyStack<Integer> s2;

    public MyStackMin2() {
        s2 = new MyStack<Integer>();
    }

    public void push(int val) {
        if (val <= min()) {
            s2.push(val);
        }
        super.push(val);
    }

    public Integer pop() {
        int item = super.pop();
        if (item == s2.peek()) s2.pop();
        return item;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }
}



