package twelve;

import java.util.function.Predicate;
import java.util.function.Function;
import java.time.LocalDate;

public class TernaryOperator {

    public static <T, R> R ternaryOperator(T input, Predicate<T> predicate, Function<T, R> trueFunction, Function<T, R> falseFunction) {
        return predicate.test(input) ? trueFunction.apply(input) : falseFunction.apply(input);
    }

    public static void main(String[] args) {
        // чётное нечётное
        int number = 7;
        String res1 = ternaryOperator(
                number,
                x -> x % 2 == 0,
                x -> "Even",
                x -> "Odd"
        );
        System.out.println(res1);

        // содержит ли слово в себе другое
        String example = "ножницы";
        Boolean res2 = ternaryOperator(
                example,
                s -> s.contains("нож"),
                s -> true,
                s -> false
        );
        System.out.println(res2);

        // какое время указано
        LocalDate currentDate = LocalDate.now();
        LocalDate futureDate = currentDate.minusDays(1);
        String res3 = ternaryOperator(
                futureDate,
                date -> date.isAfter(currentDate),
                date -> "Будущее",
                date -> "Прошлое"
        );
        System.out.println(res3);
    }

}
