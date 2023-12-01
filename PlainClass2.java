import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PlainClass2 {
    static PlainInterface anInterface;
    static PlainInterface2 anInterface2;

    public static void main(String[] args) {

        anInterface = (x, y) -> String.valueOf(x + y);
        print(5, 5);
        anInterface = (x, y) -> String.valueOf(x - y);
        print(5, 5);
        anInterface = (x, y) -> String.valueOf(x * y);
        print(5, 5);
        // PlainInterface2 interface2 = (x, y) -> Integer.compare(x, y);
        anInterface2 = Integer::compare; // аналог записи выше
        System.out.println(anInterface2.action(5, 15));

        List<String> myList = Arrays.asList("Привет", "мир", "!", "Я", "родился", "!");
        myList.stream().filter(s -> s.length() > 4).forEach(System.out::println);
        IntStream.range(1, 4).average().ifPresent(System.out::println);
        List<String> list = Arrays.asList("Не", "заменят", "край", "родимый",
                "Никакие", "чудеса!", "Только", "здесь", "всё", "так", "любимо",
                "Реки", "горы", "и", "леса.");
        list.stream()
            .filter(n -> n.length() > 4)
            .filter(c -> c.toLowerCase().contains("а"))
            .forEach(n -> System.out.print(n + " "));
        list.stream()
            .skip(list.size()/2) // пропустить заданное количество первых элементов
            .filter(n -> n.length() >4)
            .filter(n -> n.toLowerCase().contains("а"))
            .forEach(n -> System.out.print(n+" "));
        list.stream()
            .limit(list.size()/2) // Ограничивает обработку указанным количеством первых элементов
            .filter(n -> n.length() >4)
            .filter(n -> n.toLowerCase().contains("а"))
            .forEach(n -> System.out.print(n+" "));
        List<String> list2 = Arrays.asList("а", "б", "а", "в", "а", "г", "а", "д");
        list2.stream()
            .distinct()  // пропускает поток без повторов
            .forEach(n -> System.out.print(n));
        myList.stream()
            .sorted((s, t1) -> t1.length() - s.length()) // сортирует поток, можно передать компаратор
            .forEach(System.out::println);
        List<String> list3 = Arrays.asList("Привет", "Как дела?", "Пропеллер!", "никель");
        list3.stream().map(n -> n.length()).forEach(System.out::println);
        System.out.println(myList.stream().filter(s -> s.length()>4).findFirst());
        System.out.println(myList.stream().filter(s -> s.length()>4).findAny()); //возвращает первый обработанный
        List<String> myList2 = Arrays.asList("Привет", "мир", "!", "Я", "родился", "!", "Море", "Поле");
        List<String> tmpList = myList2.stream()
            .sorted((s, t1) -> {
                int tmp = t1.length() - s.length();
                if (tmp<0) return 1;
                else if (tmp>0) return -1;
                return 0;
            })
            .collect(Collectors.toList());


    }

    private static void print(int x, int y) {
        System.out.println(anInterface.action(x, y));
    }

}

@FunctionalInterface // проверяет, является ли интерфейс функциональным, то есть описывает всего один
                     // метод
interface PlainInterface {
    String action(int x, int y);
}

@FunctionalInterface
interface PlainInterface2 {
    int action(int x, int y);
}
