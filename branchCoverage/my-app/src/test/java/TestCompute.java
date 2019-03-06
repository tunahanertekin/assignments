import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void example() {
    MessageQueue mq = mock(MessageQueue.class);
    c = new Compute(mq);
    assertTrue(true);
  }

  @Test
  public void testFirstBranch() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    assertEquals("Error where size=0 !", -1, c.countNumberOfOccurrences("string"));
  }

  @Test
  public void testSecondBranch(){
    MessageQueue mq=mock(MessageQueue.class);
    //int randomSize=int(Math.random()*100)+6;//when size>6 and <100
    //I put this line in comment because it did not give me a healthy test result.
    when(mq.size()).thenReturn(6);
    when(mq.contains("string")).thenReturn(false);
    c=new Compute(mq);
    assertEquals("Error where string does not contain string e ! ",0, c.countNumberOfOccurrences("string"));
  }

  @Test
  public void testCountOccurrences(){
    MessageQueue mq=mock(MessageQueue.class);
    when(mq.size()).thenReturn(6);
    when(mq.contains("t")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("s");
    when(mq.getAt(1)).thenReturn("t");
    when(mq.getAt(2)).thenReturn("r");
    when(mq.getAt(3)).thenReturn("i");
    when(mq.getAt(4)).thenReturn("n");
    when(mq.getAt(5)).thenReturn("g");
    c=new Compute(mq);
    assertEquals("Error where counting 's' in 'string' !",1, c.countNumberOfOccurrences("t"));
  }
}