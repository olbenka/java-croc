package nine;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CommentFilter implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        Iterator<String> iterator = comments.iterator();
        while (iterator.hasNext()) {
            String comment = iterator.next().toLowerCase();
            if (inBlackList(comment, blackList)) {
                iterator.remove();
            }
        }
    }

    private boolean inBlackList(String comment, Set<String> blackList) {
        for (String word : blackList) {
            String lowerWord = word.toLowerCase();
            if (comment.contains(lowerWord)) {
                int index = comment.indexOf(lowerWord);
                if (isNotCognates(comment, index, lowerWord.length())) {
                    return true;
                }
            }
        }
        return false;
    }

    // Проверка однокоренных
    private boolean isNotCognates(String comment, int index, int length) {
        char symbolBefore = (index > 0) ? comment.charAt(index - 1) : ' ';
        char symbolAfter = (index + length < comment.length()) ? comment.charAt(index + length) : ' ';
        boolean isLetterBefore = (('a' <= symbolBefore && symbolBefore <= 'я') || ('a' <= symbolBefore && symbolBefore <= 'z'));
        boolean isLetterAfter = (('a' <= symbolAfter && symbolAfter <= 'я') || ('a' <= symbolAfter && symbolAfter <= 'z'));
        return !(isLetterBefore || isLetterAfter);
    }


}


