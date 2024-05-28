import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

class stringCheck implements StringChecker {
  String s;
  public stringCheck(String s){
    this.s = s;
  }
  public boolean checkString(String s) {
    return s.equalsIgnoreCase(this.s);
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testFilter() {
    boolean FLAG=true;
    List<String> list = Arrays.asList("ab","bc","cd");
    stringCheck sc = new stringCheck("b");
    List<String> expected = Arrays.asList("ab", "bc");
    List<String> actual = new ArrayList<>();
    try{
      actual = ListExamples.filter(list,sc);
    }
    catch(Error e){
      FLAG = false;
    }
    
    if(!FLAG){
      assertEquals(expected.size(),actual);
    }
    else{
      assertTrue(FLAG);
    }
  }
}

/**
 * types for the arguments of filter in the wrong order, so it doesn't match the expected behavior.
 * which has a great implementation saved in a file with the wrong name.
 * which has a great implementation saved in a nested directory called pa1.
 */