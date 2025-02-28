package lectures;


import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.Test;

public class Lecture6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer integer = Arrays.stream(numbers).filter(num-> num>5).findAny().get();
    System.out.println("findany - "+integer);
  }

  /*The difference between findFirst and 
   * FindAny is that FindFirst is deterministic in nature 
   * no matter how many times you run it you get the same output for same input.
   * 
   */
  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer integer = Arrays.stream(numbers).filter(num-> num>5).findFirst().get();
    System.out.println("findfirst - "+integer);

  }
}

