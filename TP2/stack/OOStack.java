package stack;  // TEST


import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	private ArrayList palabras = new ArrayList();
	
	
	public boolean isEmpty() {
		return palabras.isEmpty();
		// TODO Auto-generated method stub
	}

	public OOStack push(String string) {
		 palabras.add(string);
			return this;
		}
		// TODO Auto-generated method stub

	public Object pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		else {
			return palabras.remove(palabras.size()-1);
		}
	}

	public Object top() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		else {
			return palabras.get(palabras.size()-1);
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return 0;
		}
		else {
			return palabras.size();
		}
	}
	

	static abstract class SuperClass {
		public abstract OOStack isEmpty();
		public abstract OOStack push(String v );
		public abstract OOStack pop();
		public abstract OOStack top();
		public abstract OOStack size();
	}
	
	static class Empty extends SuperClass {
		public OOStack isEmpty() { return True() }

		
		static OOStack True() {
			 OOStack t = new OOStack();
			 t.palabras = new Empty();
			 return t;
		};
	}
}
