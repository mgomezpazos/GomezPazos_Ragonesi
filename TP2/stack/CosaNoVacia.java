package stack;

public class CosaNoVacia extends SuperCosa {
	
	public Object pop(OOStack ooStack) {
		
		return ooStack.stack.remove(ooStack.stack.size()-1);
	}
	
	public Object top(OOStack ooStack) {
		
		return ooStack.topBasico();
	}

}
