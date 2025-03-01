package lectures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;

import beans.Car;
import mockdata.MockData;

public class Lecture8 {

	@Test
	public void simpleGrouping() throws Exception {
		Map<String, List<Car>> groupedCarByMake = MockData.getCars().stream()
				.collect(Collectors.groupingBy(Car::getMake));
		
		groupedCarByMake.forEach((make, cars) ->{
			System.out.println(make);
			cars.forEach(eachCar -> System.out.println(eachCar));
		});
	}

	@Test
	public void groupingAndCounting() throws Exception {
		ArrayList<String> names = Lists.newArrayList("John", "John", "Mariam", "Alex", "Mohammado", "Mohammado",
				"Vincent", "Alex", "Alex");

	}

}