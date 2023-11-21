package ten;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterExample implements BlackListFilter<String> {
    public static void main(String[] args) {
        List<String> comments = new ArrayList<>();
        comments.add("Хороший комментарий");
        comments.add("У меня нож тоже");
        comments.add("У меня с собой нож");
        comments.add("Ножницы есть?");

        Predicate<String> forbiddenWordPredicate = comment -> !comment.contains("нож");

        FilterExample filterExample = new FilterExample();
        Iterable<String> filteredComments = filterExample.filterComments(comments, forbiddenWordPredicate);

        for (String comment : filteredComments) {
            System.out.println(comment);
        }

    }
}
