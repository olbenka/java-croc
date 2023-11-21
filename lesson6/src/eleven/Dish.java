package eleven;

import java.util.List;
import java.util.Set;

public class Dish {
    private final String name;
    private final Set<String> ingredients;
    private final String category;
    private final int kingRating;
    private final int courtRating;

    public Dish(String name, Set<String> ingredients, String category, int kingRating, int courtRating) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;

        if (kingRating < 0 || kingRating > 100) {
            throw new IllegalArgumentException("kingRating should be in the range of 0 to 100.");
        }
        this.kingRating = kingRating;

        if (courtRating < 0 || courtRating > 100) {
            throw new IllegalArgumentException("courtRating should be in the range of 0 to 100.");
        }
        this.courtRating = courtRating;
    }

    public String getName() {
        return name;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public String getCategory() {
        return category;
    }

    public int getKingRating() {
        return kingRating;
    }

    public int getCourtRating() {
        return courtRating;
    }



}
