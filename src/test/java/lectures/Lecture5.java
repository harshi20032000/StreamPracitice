package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
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
    List<PersonDTO> collectedPersonDTOs = people.stream().map(eachPeople ->
    	new PersonDTO(eachPeople.getId(), eachPeople.getFirstName()+" "+eachPeople.getLastName(), eachPeople.getAge()
    )).collect(Collectors.toList());
    System.out.println(collectedPersonDTOs);
    assertThat(collectedPersonDTOs).hasSize(1000);
  }

  @Test
  public void averageCarPrice() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    double averagePrice = cars.stream().mapToDouble(Car::getPrice).average().getAsDouble();
    System.out.println(averagePrice);
    assertThat(averagePrice).isEqualTo(52693.19979);
  }

  @Test
  public void test() throws Exception {

  }
}



