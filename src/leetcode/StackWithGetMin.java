package leetcode;

import com.sun.xml.internal.ws.model.RuntimeModelerException;

import java.util.Stack;


//设计一个有getMin功能的栈 P1
public class StackWithGetMin {
    public static class MyStack1 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin ; //这个栈的堆顶一定是最小值

        public MyStack1() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public int push(int value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else {
                if (value < stackMin.peek()) {   //如果当前数据小于最小值栈的栈顶数据，就同时将他压入MinStack
                    stackMin.push(value);
                }
            }
            stackData.push(value);
            return value;
        }

        public int pop() {
            if (this.stackData.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int value=this.stackData.pop();
            if(value == this.getMin()){
                stackMin.pop();
            }
            return value;
        }

        public int getMin() {
            if(this.stackMin.isEmpty()){
                throw new RuntimeException("stack is empty");
            }
            return this.stackMin.peek();
        }

        public int peek() {
            if(this.stackData.isEmpty()) {
                throw new RuntimeModelerException("stack is empty");
            }
            return stackData.peek();
        }

    }
    
    //for test
    public static void main(String[] args) {
        boolean flag=true;
        for (int i = 0; i < 500000; i++) {
            MyStack1 stack=new MyStack1();
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < 1000; j++) {
                int temp=stack.push((int) (Math.random()*((5000-1)+1)));
                min=temp<min?temp:min;

            }
            flag=(stack.getMin()==min);
           
        }
        if(flag){
            System.out.println("runs like butter");
        }else{
            System.out.println("shit!");
        }
    }
}
