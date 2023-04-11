package src.booleans;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ BooleTest.class, FalsoTest.class, VerdaderoTest.class })
public class AllTests {

}
