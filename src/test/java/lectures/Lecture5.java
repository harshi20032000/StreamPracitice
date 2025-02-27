package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    Predicate<? super Car> simplePredicate = eachCar -> eachCar.getPrice()<20000;
	List<Car> affordableCars = cars.stream().filter(simplePredicate).collect(Collectors.toList());
	System.out.println(affordableCars.size());
	System.out.println(affordableCars);
	assertThat(affordableCars).hasSize(156);
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices

  }

  @Test
  public void test() throws Exception {

  }
}



