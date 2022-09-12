package br.unicap.ed1.challenge04;

public class CircularListNode<Value> {

    private Value value;
    private CircularListNode<Value> previous;
    private CircularListNode<Value> next;

    public CircularListNode(Value value, CircularListNode<Value> previous, CircularListNode<Value> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public CircularListNode<Value> getPrevious() {
        return previous;
    }

    public void setPrevious(CircularListNode<Value> previous) {
        this.previous = previous;
    }

    public CircularListNode<Value> getNext() {
        return next;
    }

    public void setNext(CircularListNode<Value> next) {
        this.next = next;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof CircularListNode<?>){
            CircularListNode<?> other = (CircularListNode<?>) obj;
            return this.value.equals(other.value);
        }
        return false;
    }

}

