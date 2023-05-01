package stack;

public abstract class SuperNodo {
	String informacion;
	SuperNodo anterior;
	
	public abstract boolean isEmpty();
	
	public abstract void pop();
	
	public abstract void top();

	public abstract void size();
}
