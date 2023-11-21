package ten;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public interface BlackListFilter<T> {
    default Iterable<T> filterComments(Iterable<T> comments, Predicate<T> commentPredicate) {
        ArrayList<T> filteredComments = new ArrayList<>();

        for (T comment : comments) {
            if (commentPredicate.test(comment)) {
                filteredComments.add(comment);
            }
        }

        return filteredComments;
    }

}
