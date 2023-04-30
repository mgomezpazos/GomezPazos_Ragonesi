package stack;  

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	public static SuperNodo primerElemento;
	
	
	public int contar() {
		int contador = 0;
		return contador++;
	}
	public OOStack() {
		primerElemento = new NodoVacio();
	}
	
	public OOStack push(String string) {
	  SuperNodo nuevoEstado = new NodoNoVacio ();
	  nuevoEstado.informacion = string;
	  nuevoEstado.anterior = primerElemento;
	  primerElemento = nuevoEstado;
	  contar();
	  return this;
	  
	}

	public boolean isEmpty() {
		return primerElemento.isEmpty();
	}

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

	public int size() {
		return primerElemento.size();
	}
	
}
