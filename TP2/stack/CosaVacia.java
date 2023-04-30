package stack;

public class CosaVacia extends SuperCosa{
	
	public Object pop(OOStack ooStack) {
		
		throw new Error ("OOStack.stackEmptyErrorDescription") ;
		//return null;
	}
	
	public Object top(OOStack ooStack) {
		
		return ooStack.topExplosivo(); // falta definir top exclusivo
	}

}
