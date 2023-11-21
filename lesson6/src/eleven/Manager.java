package eleven;

import java.util.*;
import java.util.function.Predicate;

public class Manager {
    private final Map<Chef, Set<Dish>> chefDishesMap;

    public Manager(Map<Chef, Set<Dish>> chefDishesMap) {
        this.chefDishesMap = chefDishesMap;
    }

    public void addChef(Chef chef) {
        chefDishesMap.computeIfAbsent(chef, k -> {
            Set<Dish> dishes = chef.getDishes();
            return dishes.isEmpty() ? new HashSet<>() : new HashSet<>(dishes);
        });
    }

    public void deleteChef(Chef chef) {
        chefDishesMap.remove(chef);
    }

    public List<Dish> generateMenu(Set<Chef> workingChefs, Set<String> unavailableIngredients, int numberOfDishes) {
        Set<Dish> uniqueDishes = new HashSet<>();

        for (Chef chef : workingChefs) {
            uniqueDishes.addAll(chefDishesMap.getOrDefault(chef, Collections.emptySet()));
        }
        List<Dish> availableDishes = new ArrayList<>(uniqueDishes);
        availableDishes.removeIf(dish -> {
            Set<String> dishIngredients = dish.getIngredients();
            for (String ingredient : dishIngredients) {
                if (unavailableIngredients.contains(ingredient)) {
                    return true;
                }
            }
            return false;
        });
        availableDishes.sort(Comparator.comparing(Dish::getKingRating).thenComparing(Dish::getCourtRating).reversed());
        return availableDishes.subList(0, Math.min(numberOfDishes, availableDishes.size()));
    }

    public List<Dish> generateUpdatedMenu(Set<Chef> workingChefs, Set<String> unavailableIngredients, int numberOfDishes, Predicate<Dish> specialRequirement) {
        List<Dish> possibleDishes = generateMenu(workingChefs, unavailableIngredients, numberOfDishes);
        possibleDishes.removeIf(specialRequirement.negate());
        return possibleDishes;
    }
}
