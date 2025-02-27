package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class Lecture3 {

  @Test
  public void min() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer minNumber = numbers.stream().min(Comparator.naturalOrder()).get();
    System.out.println(minNumber);
    assertThat(minNumber).isEqualTo(1);

  }

  @Test
  public void max() throws Exception {
    final List<Integer> numbers = ImmutableList.of(1, 2, 3, 100, 23, 93, 99);
    Integer maxNo = numbers.stream().max(Comparator.naturalOrder()).get();
    assertThat(maxNo).isEqualTo(100);
    System.out.println(maxNo);
  }
}
