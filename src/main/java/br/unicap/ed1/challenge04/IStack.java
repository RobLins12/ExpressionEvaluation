package br.unicap.ed1.challenge04;


public interface IStack<Value> {

	public boolean isEmpty();

	public void push(Value key);

	public Value pop();
}
