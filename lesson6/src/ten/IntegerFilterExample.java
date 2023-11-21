package ten;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Predicate;

public class IntegerFilterExample implements BlackListFilter<Integer>{
    public static void main(String[] args) {
        Collection<Integer> numbers;
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Predicate<Integer> evenNumberPredicate = num -> num % 2 == 0;

        IntegerFilterExample filterExample = new IntegerFilterExample();
        Iterable<Integer> filteredNumbers = filterExample.filterComments(numbers, evenNumberPredicate);

        for (Integer number : filteredNumbers) {
            System.out.println(number);
        }
    }
}
