public class PlainClass {
    public static void main(String[] args) {
        // PlainInterface anInterface = new PlainInterface() {
        //     @Override
        //     public String action(int x, int y) {
        //     return String.valueOf(x+y);
        //     }
        // };
        PlainInterface anInterface = (x,y) -> String.valueOf(x+y); // аналог записи выше
        System.out.println(anInterface.action(5, 5));

    }        
}

@FunctionalInterface  // проверяет, является ли интерфейс функциональным, то есть описывает всего один метод
interface PlainInterface {String action(int x, int y);}
