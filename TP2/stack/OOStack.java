package stack;  // TEST


//import java.util.ArrayList;
//import java.util.List;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	//public List stack = new ArrayList();
	public static SuperNodo primerElemento;
	//public List estadoStack = new ArrayList();
	
	public OOStack() {
		primerElemento = new NodoVacio();
	}
	
	public OOStack push(String string) {
	 // stack.add(string);
	  SuperNodo nuevoEstado = new NodoNoVacio ();
	  nuevoEstado.informacion = string;
	  nuevoEstado.anterior = primerElemento;
	  primerElemento = nuevoEstado;
	  return this;
	  
	}

	public boolean isEmpty() {
		return primerElemento.isEmpty();
	}

	//public OOStack push(String string) {
	//	 stack.add(string);
	//		return this;
	//	}

	public Object pop() {
		primerElemento.pop();
		Object infoDelReturn = primerElemento.informacion;
		primerElemento = primerElemento.anterior;
		return infoDelReturn;
	}

	public Object top() {
		primerElemento.top();
		return primerElemento.informacion;
	}

//	public Object topBasico() {
//		return stack.get(stack.size()- 1);		
//	}
//	
//	public Object topExplosivo() throws Error{
//		throw new Error (OOStack.stackEmptyErrorDescription);
//	}
	
	public int size() {
			return 0;
	}
	
}
