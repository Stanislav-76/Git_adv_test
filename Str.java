import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Str {
public static void main(String[] args) {
    List<PersonID> personIDS = Arrays.asList(
    new PersonID("Иванов И.И.", new Date(1992, Calendar.FEBRUARY, 7), genSalary()),
    new PersonID("Петров П.В.", new Date(1987, Calendar.APRIL , 27), genSalary()),
    new PersonID("Селиванов В.А.", new Date(1995, Calendar.AUGUST, 15), genSalary()),
    new PersonID("Кладовцева Я.И.", new Date(1996, Calendar.JUNE, 28), genSalary()),
    new PersonID("Стильнов В.М.", new Date(1981, Calendar.SEPTEMBER, 18), genSalary()),
    new PersonID("Иванова С.В.", new Date(1991, Calendar.FEBRUARY, 17), genSalary()),
    new PersonID("Одоевцева М.В.", new Date(2001, Calendar.JANUARY, 6), genSalary()),
    new PersonID("Кузеванов А.И.", new Date(2003, Calendar.JUNE, 14), genSalary()),
    new PersonID("Донцев Ю.Ф.", new Date(1991, Calendar.MAY, 22), genSalary()),
    new PersonID("Кривцова А.И.", new Date(1976, Calendar.DECEMBER, 4), genSalary()),
    new PersonID("Бронникова И.И.", new Date(1999, Calendar.OCTOBER, 19), genSalary()),
    new PersonID("Остафьев И.А.", new Date(1995, Calendar.FEBRUARY, 24), genSalary())
    );
    List<String> tmpList = personIDS.stream().map(n ->
    n.getDOB()).collect(Collectors.toList());
    System.out.println(tmpList);
    }
    private static int genSalary(){return new Random().nextInt(63758)+16242;}
}