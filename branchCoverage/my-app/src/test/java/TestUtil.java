import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void testOneArg(){
    assertFalse("Method with one argument must return false.", c.compute(10));
  }

  @Test
  public void testEvenArgs(){
    c=new Util();
    assertFalse("Method with even # of arguments must return false", c.compute(4,5));
  }

  @Test
  public void testDividedByArgument(){
    c=new Util();
    assertTrue("Sum of arguments is perfectly divided by at least one argument.",c.compute(3,4,5));
  }
  
  @Test
  public void testNotDividedByArgument(){
    c=new Util();
    assertFalse("Sum of arguments is perfectly divided by at least one argument.", c.compute(2,4,7));
  }

  @Test(expected=RuntimeException.class)
  public void testArgEqualsZero(){
    c=new Util();
    assertFalse("An argument is equal to zero, runtime exception must be throwed.", c.compute(3,5,0));
  }
}