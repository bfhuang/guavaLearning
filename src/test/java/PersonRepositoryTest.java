import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PersonRepositoryTest {

	private PersonRepository personRepository = new PersonRepository();
	private List<Person> expectedPeople;
	private List<String> expectedNames;

	@Test
	public void should_filter_the_person_who_is_under_18_years() {
		expectedPeople = newArrayList(
				new Person("name", 19),
				new Person("name1", 20)
		);
		assertThat(personRepository.getAbove18(), is(expectedPeople));

	}

	@Test
	public void should_filter_the_person_who_is_name_do_not_contain_1() {
		expectedPeople = newArrayList(
				new Person("name1", 16),
				new Person("name1", 17),
				new Person("name1", 18),
				new Person("name1", 20)
		);
		assertThat(personRepository.getNameContains1(), is(expectedPeople));
	}

	@Test
	public void should_filter_person_who_is_above_18_and_name_contains_1() {
		expectedPeople = newArrayList(new Person("name1", 20));
		assertThat(personRepository.getAbove18AndNameContains1(), is(expectedPeople));
	}

	@Test
	public void should_get_all_the_names_of_people() {
		expectedNames = newArrayList(
				"name1",
				"name1",
				"name1",
				"name",
				"name1");
		assertThat(personRepository.getAllNames(), is(expectedNames));
	}

	@Test
	public void should_get_all_the_name_of_people_who_are_above_18() {
		expectedNames = newArrayList("name", "name1");
		assertThat(personRepository.getAllNamesWhosAgeIsAbove18(), is(expectedNames));
	}
}
