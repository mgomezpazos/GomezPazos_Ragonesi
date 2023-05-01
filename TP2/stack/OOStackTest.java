package stack;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;


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
    System.out.print(stack.size());
    assertEquals( stack.size(), 1 );
    stack.top();
    System.out.print(stack.size());
    assertEquals( stack.size(), 1 );
  }
  

  @Test public void test08CanNotPopWhenThereAreNoObjectsInTheStack() {
    OOStack stack = newStack();
    try {
      stack.pop();
      fail( expectedMessageNotUnderstood );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( OOStack.stackEmptyErrorDescription ) );
    }
  }

  @Test public void test09CanNotPopWhenThereAreNoObjectsInTheStackAndTheStackHadObjects() {
    OOStack stack = newStack();
    stack.push( something );
    stack.pop();
    try {
      stack.pop();
      fail( expectedMessageNotUnderstood );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( OOStack.stackEmptyErrorDescription ) );
    }
  }

  @Test public void test10CanNotTopWhenThereAreNoObjectsInTheStack() {
    OOStack stack = newStack();
    try {
      stack.top();
      fail( expectedMessageNotUnderstood );
    } catch (Error e) {
      assertTrue( e.getMessage().equals( OOStack.stackEmptyErrorDescription ) );
    }
  }

  private OOStack newStack() {
	  OOStack stack = new OOStack();
	  return stack;
}
}