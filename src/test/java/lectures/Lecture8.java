package lectures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
	public void countEachCar() throws Exception {
		Map<String, Long> eachCarCount = MockData.getCars().stream()
				.collect(Collectors.groupingBy(Car::getMake, Collectors.counting()));
		
		eachCarCount.forEach((name, count) ->{
			System.out.println(name+" is present "+count+" times.");
		});
	}

	@Test
	public void groupingAndCounting() throws Exception {
		ArrayList<String> names = Lists.newArrayList("John", "John", "Mariam", "Alex", "Mohammado", "Mohammado",
				"Vincent", "Alex", "Alex");
		Map<String, Long> namesCount = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		namesCount.forEach((name, count) ->{
			System.out.println(name+" is present "+count+" times.");
		});

	}

}