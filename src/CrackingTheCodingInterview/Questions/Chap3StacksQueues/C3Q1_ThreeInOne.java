package CrackingTheCodingInterview.Questions.Chap3StacksQueues;

import Common.MyStack;

public class C3Q1_ThreeInOne {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
