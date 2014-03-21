import com.google.common.base.Predicate;

import java.util.List;

import static com.google.common.base.Predicates.and;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

public class PersonRepository {
List<Person> people = newArrayList(
		new Person("name1", 16),
		new Person("name1", 17),
		new Person("name1", 18),
		new Person("name", 19),
		new Person("name1", 20)
);
	public List<Person> getAbove18() {
		return newArrayList(filter(people, ageAbove18()));
	}

	public List<Person> getNameContains1() {
		return newArrayList(filter(people, nameContains1()));
	}

	public List<Person> getAbove18AndNameContains1() {
		return newArrayList(filter(people, and(nameContains1(), ageAbove18())));
	}

	private Predicate<Person> nameContains1() {
		return new Predicate<Person>() {
			@Override
			public boolean apply(Person person) {
				return person.getName().contains("1");
			}
		};
	}

	private Predicate<Person> ageAbove18() {
		return new Predicate<Person>() {
			@Override
			public boolean apply(Person person) {
				return person.getAge() > 18;
			}
		};
	}
}