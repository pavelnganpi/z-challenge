import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import pojo.Person;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class PeopleSortTest {
    private Person person;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;

    @Before
    public void setup() {
        person = new Person("700000000", getDate(1993, 6, 29), "pavey", "nganpi", 72.0, 230.34);
        person1 = new Person("700000001", getDate(1994, 7, 24), "naruto", "uzumaki", 58.23, 130.24);
        person2 = new Person("700000002", getDate(2000, 6, 13), "sasuke", "uchiha", 78.29, 120.91);
        person3 = new Person("700000003", getDate(1964, 4, 4), "luffy", "monkey d", 61.18, 118.16);
        person4 = new Person("700000004", getDate(1960, 12, 29), "kakashi", "sensei", 56.58, 210.43);
    }

    @Test
    public void TestSortBySSNAscending() {
        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "ssn", "true");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "ssn", "true");

        // then
        assertSortedPeople(sortedPeople, person, person1, person2, person3, person4);
        assertSortedPeople(sortedPeople2, person, person1, person2, person3, person4);
    }

    @Test
    public void TestSortBySSNDescending() {
        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "ssn", "false");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "ssn", "false");

        // then
        assertSortedPeople(sortedPeople, person4, person3, person2, person1, person);
        assertSortedPeople(sortedPeople2, person4, person3, person2, person1, person);
    }

    @Test
    public void TestSortByDateOfBirthAscending() {

        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "dateOfBirth", "true");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "dateOfBirth", "true");

        // then
        assertSortedPeople(sortedPeople, person4, person3, person, person1, person2);
        assertSortedPeople(sortedPeople2, person4, person3, person, person1, person2);
    }

    @Test
    public void TestSortByDateOfBirthDescending() {
        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "dateOfBirth", "false");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "dateOfBirth", "false");

        // then
        assertSortedPeople(sortedPeople, person2, person1, person, person3, person4);
        assertSortedPeople(sortedPeople2, person2, person1, person, person3, person4);
    }

    @Test
    public void TestSortByFirstNameAscending() {

        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "firstName", "true");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "firstName", "true");

        // then
        assertSortedPeople(sortedPeople, person4, person3, person1, person, person2);
        assertSortedPeople(sortedPeople2, person4, person3, person1, person, person2);
    }

    @Test
    public void TestSortByFirstNameDescending() {
        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "firstName", "false");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "firstName", "false");

        // then
        assertSortedPeople(sortedPeople, person2, person, person1, person3, person4);
        assertSortedPeople(sortedPeople2, person2, person, person1, person3, person4);
    }

    @Test
    public void TestSortByLastNameAscending() {

        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "lastName", "true");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "lastName", "true");

        // then
        assertSortedPeople(sortedPeople, person3, person, person4, person2, person1);
        assertSortedPeople(sortedPeople2, person3, person, person4, person2, person1);
    }

    @Test
    public void TestSortByLastNameDescending() {
        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "lastName", "false");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "lastName", "false");

        // then
        assertSortedPeople(sortedPeople, person1, person2, person4, person, person3);
        assertSortedPeople(sortedPeople2, person1, person2, person4, person, person3);
    }

    @Test
    public void TestSortByHeightInAscending() {

        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "heightIn", "true");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "heightIn", "true");

        // then
        assertSortedPeople(sortedPeople, person4, person1, person3, person, person2);
        assertSortedPeople(sortedPeople2, person4, person1, person3, person, person2);
    }

    @Test
    public void TestSortByHeightInDescending() {
        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "heightIn", "false");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "heightIn", "false");

        // then
        assertSortedPeople(sortedPeople, person2, person, person3, person1, person4);
        assertSortedPeople(sortedPeople2, person2, person, person3, person1, person4);
    }

    @Test
    public void TestSortByWeightLbAscending() {

        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "weightLb", "true");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "weightLb", "true");

        // then
        assertSortedPeople(sortedPeople, person3, person2, person1, person4, person);
        assertSortedPeople(sortedPeople2, person3, person2, person1, person4, person);
    }

    @Test
    public void TestSortByWeightLbDescending() {
        // given
        List<Person> people = setupPeopleData();

        // when
        List<Person> sortedPeople = PeopleSort.sort(people, "weightLb", "false");
        List<Person> sortedPeople2 = PeopleSort.sort2(people, "weightLb", "false");

        // then
        assertSortedPeople(sortedPeople, person, person4, person1, person2, person3);
        assertSortedPeople(sortedPeople2, person, person4, person1, person2, person3);
    }

    private List<Person> setupPeopleData() {
        return Arrays.asList(person, person1, person2, person3, person4);
    }

    private Date getDate(int year, int month, int day) {
        return new GregorianCalendar(year,month,day).getTime();
    }

    private void assertSortedPeople(List<Person> actual, Person expected, Person expected1, Person expected2, Person expected3, Person expected4) {
        assertEquals(actual.get(0), expected);
        assertEquals(actual.get(1), expected1);
        assertEquals(actual.get(2), expected2);
        assertEquals(actual.get(3), expected3);
        assertEquals(actual.get(4), expected4);
    }
}
