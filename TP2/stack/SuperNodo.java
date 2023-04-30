package stack;

public abstract class SuperNodo {
	String informacion;
	SuperNodo anterior;
	
	public abstract boolean isEmpty();
	
	public abstract Object pop();
	
	public abstract Object top();

	public abstract int size();
}
