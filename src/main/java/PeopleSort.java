import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import pojo.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PeopleSort {

    /**
     * Sorts an Iterable of people based on sortField and ordering.
     * Building up the peopleList takes O(n) time where n is size of people Iterable.
     * Sorting list based on sortField takes O(nlogn) where n is size of people Iterable.
     * Extra space O(n) is used in populating the peopleList from the people Iterable
     * @param people Iterable of people to sort
     * @param sortField field to sort by
     * @param ascending order of sort
     * @return list of people sorted by sortField in ascending / descending order
     */
    public static List<Person> sort(Iterable<Person> people, String sortField,
                             String ascending) {
        List<Person> peopleList = new ArrayList<>();

        // Copying data from Iterable into a List so as to easily sort list
        // later since Iterable class doesn't support sorting
        people.forEach(peopleList::add);
        switch (sortField) {
            case "ssn":
                peopleList.sort((o1, o2) -> o1.getSsn().compareTo(o2.getSsn()) * sortDirection(ascending));
                break;
            case "dateOfBirth":
                peopleList.sort((o1, o2) -> o1.getDateOfBirth().compareTo(o2.getDateOfBirth()) * sortDirection(ascending));
                break;
            case "firstName":
                peopleList.sort((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()) * sortDirection(ascending));
                break;
            case "lastName":
                peopleList.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()) * sortDirection(ascending));
                break;
            case "heightIn":
                peopleList.sort((o1, o2) -> o1.getHeightIn().compareTo(o2.getHeightIn()) * sortDirection(ascending));
                break;
            case "weightLb":
                peopleList.sort((o1, o2) -> o1.getWeightLb().compareTo(o2.getWeightLb()) * sortDirection(ascending));
                break;
        }

        return peopleList;
    }

    /**
     * Another solution is using a min heap for ascending and max heap for descending
     * Building the heap takes O(nlogn) where n is the size of the people Iterable.
     * Heap maintains order so no need to sort further.
     * Extra space of O(n) is used in building the heap whose contents are later
     * moved into a list.
     */
    public static List<Person> sort2(Iterable<Person> people, String sortField,
                                    String ascending) {

        PriorityQueue<Person> heap = new PriorityQueue<>();
        switch (sortField) {
            case "ssn":
                heap = new PriorityQueue<>((o1, o2) -> o1.getSsn().compareTo(o2.getSsn()) * sortDirection(ascending));
                people.forEach(heap::add);
                break;
            case "dateOfBirth":
                heap = new PriorityQueue<>((o1, o2) -> o1.getDateOfBirth().compareTo(o2.getDateOfBirth()) * sortDirection(ascending));
                people.forEach(heap::add);
                break;
            case "firstName":
                heap = new PriorityQueue<>((o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()) * sortDirection(ascending));
                people.forEach(heap::add);
                break;
            case "lastName":
                heap = new PriorityQueue<>((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()) * sortDirection(ascending));
                people.forEach(heap::add);
                break;
            case "heightIn":
                heap = new PriorityQueue<>((o1, o2) -> o1.getHeightIn().compareTo(o2.getHeightIn()) * sortDirection(ascending));
                people.forEach(heap::add);
                break;
            case "weightLb":
                heap = new PriorityQueue<>((o1, o2) -> o1.getWeightLb().compareTo(o2.getWeightLb()) * sortDirection(ascending));
                people.forEach(heap::add);
                break;
        }

        List<Person> peopleList = new ArrayList<>(heap.size());
        while(!heap.isEmpty()) {
            peopleList.add(heap.remove());
        }

        return peopleList;
    }

    /**
     * Determines whether to sort in ascending or descending order
     * @param ascending specifies if sorting ascending or descending
     * @return -1 if to sort in descending order, 1 if to sort in ascending order
     */
    private static int sortDirection(String ascending) {
        return ascending.equals("true") ? 1 : -1;
    }
}
