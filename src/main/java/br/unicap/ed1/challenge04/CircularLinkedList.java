package br.unicap.ed1.challenge04;

public class CircularLinkedList<Value> {

    private CircularListNode<Value> sentinel;

    public CircularLinkedList() {
        this.sentinel = new CircularListNode<Value>(null, null, null);
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
    }

    public CircularListNode<Value> getHead() {
        return this.sentinel.getNext();
    }

    public CircularListNode<Value> getTail() {
        return this.sentinel.getPrevious();
    }

    public boolean isEmpty() {
        return this.getHead() == this.sentinel && this.getTail() == this.sentinel;
    }

    public void addFirst(Value value) {
        CircularListNode<Value> newCircularNode = new CircularListNode<Value>(value, sentinel.getPrevious(), sentinel.getNext());
        if(isEmpty()){
            this.sentinel.setPrevious(newCircularNode);
        }
        else{
            this.sentinel.getNext().setPrevious(newCircularNode);
        }
        this.sentinel.setNext(newCircularNode);
    }

    public void addLast(Value value) {
        if (isEmpty()) {
            addFirst(value);
        } else {
            CircularListNode<Value> currentTail = this.sentinel;
            boolean isNotTail = currentTail.getNext() == this.sentinel;
            while (!isNotTail) {
                currentTail = currentTail.getNext();
                isNotTail = currentTail.getNext() == this.sentinel;
            }
            CircularListNode<Value> newTail = new CircularListNode<Value>(value, currentTail, this.sentinel);
            currentTail.setNext(newTail);
            this.sentinel.setPrevious(newTail);
        }
    }

    public void delete(CircularListNode<Value> nodeDelete) {
        CircularListNode<Value> nextNode = nodeDelete.getNext();
        CircularListNode<Value> previousNode = nodeDelete.getPrevious();
        nextNode.setPrevious(previousNode);
        previousNode.setNext(nextNode);
    }

}