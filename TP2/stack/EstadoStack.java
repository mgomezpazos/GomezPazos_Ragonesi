package stack;

import java.util.List;
import java.util.ArrayList;

public class EstadoStack {
	
	public int size;
	public List <OOStack> estadosDelStack = new ArrayList <OOStack>();
	
	public void push(Object estado) {
		estadosDelStack.add(new OOStack(this));
		
		top.push(estado);
	}
	
	public EstadoStack (List elements) {
		this.estadosDelStack = new ArrayList <OOStack> (elements);
	}
	
	public List getEstadosDelStack() {
		return new ArrayList<OOStack>(estadosDelStack);
	}
}
