package stack;  // TEST


import java.util.ArrayList;
import java.util.List;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	public List stack = new ArrayList();
	public List estadoStack = new ArrayList();
	
	
	SuperNodo cosa;
	
	public OOStack push(String string) {
	  stack.add(string);
	  return this;
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	//public OOStack push(String string) {
	//	 stack.add(string);
	//		return this;
	//	}

	public Object pop() {
		return cosa.pop(this);
	}

	public Object top() {
		return cosa.top(this);
	}

	public Object topBasico() {
		return stack.get(stack.size()- 1);		
	}
	
	public Object topExplosivo() throws Error{
		throw new Error (OOStack.stackEmptyErrorDescription);
	}
	
	public int size() {
			return stack.size();
	}
	
}
