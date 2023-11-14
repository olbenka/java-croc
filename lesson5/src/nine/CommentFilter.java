package nine;

import java.util.*;

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
        String[] commentWords = comment.split("\\s+|[.,!?;]");
        for (String word : commentWords) {
            if (blackList.contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void upgradeFilterComments(List<String> comments, Set<String> blackList) {
        for (String comment : comments) {
            String[] commentWords = comment.split("\\s+");
            StringBuilder filteredComment = new StringBuilder();

            for (String word : commentWords) {
                if (blackList.contains(word.toLowerCase())) {
                    filteredComment.append("*".repeat(word.length())).append(" ");
                } else {
                    filteredComment.append(word).append(" ");
                }
            }

            int index = comments.indexOf(comment);
            comments.set(index, filteredComment.toString().trim());
        }

    }
}



