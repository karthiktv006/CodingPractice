package CrackingTheCodingInterview.Questions.Chap3StacksQueues;

import Common.MyStack;

public class C2Q3_StackOfPlates {
    public static void main(String[] args) {
        SetOfStacks<Integer> stackSet = new SetOfStacks<>();
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(3);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(4);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(3);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(4);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(3);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(1);
        stackSet.push(4);
        stackSet.push(1);
        stackSet.push(1);


        System.out.println(stackSet.arrayLength);

    }
}


class SetOfStacks<T> {
    private int count;
    public int arrayLength;
    private int stackSize;
    private MyStack<T>[] stacks;

    public SetOfStacks() {
        this.count = 0;
        this.arrayLength = 1;
        this.stackSize = 10;
        stacks = new MyStack[this.arrayLength];
        MyStack<T> stack = new MyStack<T>();
        stacks[this.count / this.stackSize] = stack;
    }

    public void push(T item) {
        this.count++;
        int stackIndex = count / stackSize;
        System.out.println(this.count);
        System.out.println(stackIndex);
        System.out.println(arrayLength);
        if (stackIndex < arrayLength) {
            if (stacks[stackIndex] == null) {
                MyStack<T> stack = new MyStack<>();
                stack.push(item);
                stacks[stackIndex] = stack;
            } else {
                MyStack<T> stack = stacks[stackIndex];
                stack.push(item);
            }
        } else {
            this.arrayLength *= 2;
            System.out.println("new len" + this.arrayLength);
            MyStack<T>[] newStacks = new MyStack[this.arrayLength];
            System.arraycopy(stacks, 0, newStacks, 0, stacks.length);
            stacks = newStacks;
            MyStack<T> stack = new MyStack<T>();
            stack.push(item);
            stacks[stackIndex] = stack;
        }
    }

    public T pop() {
        this.count--;
        int stackIndex = count / stackSize;
        return stacks[stackIndex].pop();
    }

}
