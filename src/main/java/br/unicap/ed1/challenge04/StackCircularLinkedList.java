package br.unicap.ed1.challenge04;

public class StackCircularLinkedList<Value> implements IStack<Value>{

    CircularLinkedList<Value> stackCircularList = new CircularLinkedList<>();

    public boolean isEmpty() {
        return stackCircularList.isEmpty();
    }

    @Override
    public void push(Value key) {
        stackCircularList.addLast(key);
        
    }

    public Value pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        CircularListNode<Value> last = this.stackCircularList.getTail();
        this.stackCircularList.delete(last);
        return last.getValue();
    }



}