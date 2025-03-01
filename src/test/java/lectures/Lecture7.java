package lectures;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.junit.Test;

import beans.Car;
import beans.Person;
import mockdata.MockData;

public class Lecture7 {

	
	
	@Test
	public void count() throws Exception {
		
		long countFemale = MockData.getPeople().stream().filter(people -> people.getGender().equalsIgnoreCase("female")).count();
		System.out.println("Female count - "+countFemale);
	}

	@Test
	public void min() throws Exception {
		double minAge= MockData.getPeople().stream().filter(people -> people.getGender().equalsIgnoreCase("female"))
				.mapToDouble(Person::getAge).min().getAsDouble();
		System.out.println("Min Female age - "+minAge);
	}

	@Test
	public void max() throws Exception {
		int maxAge= MockData.getPeople().stream().filter(people -> people.getGender().equalsIgnoreCase("female"))
				.map(Person::getAge).max(Comparator.naturalOrder()).get();
		System.out.println("Max Female age - "+maxAge);
	}

	@Test
	public void average() throws Exception {
		List<Car> cars = MockData.getCars();
		double averageCarPrice = cars.stream().mapToDouble(Car::getPrice).average().getAsDouble();
		System.out.println("average car price - "+averageCarPrice);
	}

	@Test
	public void sum() throws Exception {
		List<Car> cars = MockData.getCars();
		double sum = cars.stream().mapToDouble(Car::getPrice).sum();
		BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
		System.out.println(sum);
		System.out.println(bigDecimalSum);

	}

	@Test
	public void statistics() throws Exception {
		List<Car> cars = MockData.getCars();
		DoubleSummaryStatistics statistics = cars.stream().mapToDouble(Car::getPrice).summaryStatistics();
		System.out.println(statistics);
		System.out.println(statistics.getAverage());
		System.out.println(statistics.getCount());
		System.out.println(statistics.getMax());
		System.out.println(statistics.getMin());
		System.out.println(statistics.getSum());
	}

}