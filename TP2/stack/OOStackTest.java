package stack;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class OOStackTest {

  public static String expectedMessageNotUnderstood = "Expected MessageNotUnderstood Error was not thrown.";
  public static String something = "Something";

@Test public void test01StackShouldBeEmptyWhenCreated() {
    assertTrue( new OOStack().isEmpty() );
  }
  
  @Test public void test02PushAddElementsToTheStack() {
    assertFalse( new OOStack().push( something ).isEmpty() );
  }
  
  @Test public void test03PopRemovesElementsFromTheStack() {
    OOStack stack = newStack();
    stack.push( something );
    stack.pop();
    assertTrue( stack.isEmpty() );
  }

  @Test public void test04PopReturnsLastPushedObject() {
    OOStack stack = newStack();
    String pushedObject = something;
    stack.push( pushedObject );
    assertEquals( stack.pop(), pushedObject );
  }
  
  @Test public void test05StackBehavesLIFO() {
    OOStack stack = newStack();
    String firstPushedObject = "First";
    String secondPushedObject = "Second";

    stack.push( firstPushedObject );
    stack.push( secondPushedObject );

    assertEquals( stack.pop(), secondPushedObject );
    assertEquals( stack.pop(), firstPushedObject );
    assertTrue( stack.isEmpty() );
  }
  
  @Test public void test06TopReturnsLastPushedObject() {
    String pushedObject = something;
    assertEquals( new OOStack().push( pushedObject ).top(), 
                  pushedObject );
  }

  @Test public void test07TopDoesNotRemoveObjectFromStack() {
    OOStack stack = newStack();
    stack.push( something );
    assertEquals( stack.size(), 1 );
    stack.top();
    assertEquals( stack.size(), 1 );
  }
  

  @Test public void test08CanNotPopWhenThereAreNoObjectsInTheStack() {
    OOStack stack = newStack();
    assertThrowsLike(OOStack.stackEmptyErrorDescription,()-> stack.pop());
  }

  @Test public void test09CanNotPopWhenThereAreNoObjectsInTheStackAndTheStackHadObjects() {
    OOStack stack = newStack();
    stack.push( something );
    stack.pop();
    assertThrowsLike(OOStack.stackEmptyErrorDescription,()-> stack.pop());
  }

  @Test public void test10CanNotTopWhenThereAreNoObjectsInTheStack() {
    OOStack stack = newStack();
    assertThrowsLike(OOStack.stackEmptyErrorDescription,()-> stack.top());
  }

  private OOStack newStack() {
	  OOStack stack = new OOStack();
	  return stack;
}
  
  private void assertThrowsLike(String msg, Executable codeToRun) {
		assertEquals(msg, assertThrows(Error.class, codeToRun).getMessage());
	}
}