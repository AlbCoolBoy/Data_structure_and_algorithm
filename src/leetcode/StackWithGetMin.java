package leetcode;

import java.util.Stack;

//设计一个有getMin功能的栈 P1
public class StackWithGetMin {
    public static class MyStack1 {
        Stack<Integer> stackData = new Stack<Integer>();
        Stack<Integer> stackMin = new Stack<Integer>();  //这个栈的堆顶一定是最小值

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else {
                if (value < stackMin.peek()) {   //如果当前数据小于最小值栈的栈顶数据，就同时将他压入MinStack
                    stackMin.push(value);
                }
            }
            stackData.push(value);
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int value=stackData.pop();
            if(value == this.getMin()){
                stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return stackMin.pop();
        }

    }


}
