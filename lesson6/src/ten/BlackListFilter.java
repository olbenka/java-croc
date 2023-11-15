package ten;

import java.util.Collection;
import java.util.function.Predicate;

public interface BlackListFilter<T> {
    default Collection<T> filterComments(Collection<T> comments, Predicate<T> predicate) {
        Collection<T> filteredComments;

        try {
            filteredComments = comments.getClass().getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Не удалось создать новый экземпляр типа коллекции.", e);
        }

        for (T comment : comments) {
            if (predicate.test(comment)) {
                filteredComments.add(comment);
            }
        }

        return filteredComments;
    }
}
