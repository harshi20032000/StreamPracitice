package lectures;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.util.Lists;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

import beans.Person;
import mockdata.MockData;

public class Lecture1 {

	@Test
	public void imperativeApproach() throws IOException {
		List<Person> people = MockData.getPeople();
		int counter = 0;
		// 1. Find people aged less or equal 18
		List<Person> youngPeople = Lists.newArrayList();
		for (Person eachPerson : people) {
			if (eachPerson.getAge() < 18) {
				youngPeople.add(eachPerson);
				counter++;
			}
			if (counter ==10)
				break;
		}
		for (Person eachPerson : youngPeople) {
			System.out.println(eachPerson);
		}

		// 2. Then change implementation to find first 10 people

	}

	@Test
	public void declarativeApproachUsingStreams() throws Exception {
		ImmutableList<Person> people = MockData.getPeople();
		List<Person> youngPeople = people.stream().filter(eP->eP.getAge()<=18).collect(Collectors.toList());
		youngPeople.forEach(System.out::println);

	}
}
