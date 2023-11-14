package nine;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        CommentFilter commentFilter = new CommentFilter();
        List<String> comments = new ArrayList<>();
        comments.add("Хороший комментарий");
        comments.add("У меня нож тоже");
        comments.add("У меня с собой нож");
        comments.add("Ножницы есть?");
        comments.add("I'm sad sad sad sad");
        comments.add("But you said it so sadly");
        comments.add("SAD");
        comments.add("Нож пропал");
        comments.add("Подножка");

        Set<String> blackList = Set.of("нож", "sad");

        System.out.println("Исходные комментарии:");
        for (String comment : comments) {
            System.out.println(comment);
        }
        // удаление комментариев
        // commentFilter.filterComments(comments, blackList);
        // замена на звездочки
        commentFilter.upgradeFilterComments(comments, blackList);
        System.out.println("-----------");
        System.out.println("Оставшиеся комментарии:");
        for (String comment : comments) {
            System.out.println(comment);
        }


    }
}
