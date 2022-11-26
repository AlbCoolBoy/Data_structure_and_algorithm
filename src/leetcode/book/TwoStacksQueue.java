package leetcode.book;

import java.util.Stack;

/**
 * <h3>Data structure and algorithm</h3>
 * <p>用两个栈设计一个队列</p>
 *
 * @author : ALB
 * @date : 2022-11-26 19:01
 **/
public class TwoStacksQueue<T> {
    public Stack<T> pushStack=new Stack<>();
    public Stack<T> popStack=new Stack<>();

    public TwoStacksQueue(){
        pushStack=new Stack<T>();
        popStack=new Stack<T>();
    }

    public void pushToPop(){
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                T t=pushStack.pop();
                popStack.push(t);
            }
        }
    }

    public void add(T t){
        pushStack.push(t);
        pushToPop();
    }

    public T poll(){
        if (popStack.isEmpty()&&pushStack.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }else{
            pushToPop();
            return popStack.pop();
        }
    }

    public T peek(){
        if (popStack.isEmpty()&&pushStack.isEmpty()) {
            throw new RuntimeException("queue is empty!");
        }else{
            pushToPop();
            return popStack.peek();
        }
    }

}
