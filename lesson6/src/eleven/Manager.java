package eleven;

import java.util.*;

public class Manager {
    private HashMap<Chef, List<Dish>> chefDishMap;

    public Manager() {
        this.chefDishMap = new HashMap<>();
    }

    public void addChef(Chef chef) {
        chefDishMap.put(chef, new ArrayList<>());
    }

    public void removeChef(Chef chef) {
        chefDishMap.remove(chef);
    }

    public void addDishForChef(Chef chef, Dish dish) {
        List<Dish> dishes = chefDishMap.get(chef);
        if (dishes != null) {
            dishes.add(dish);
        }
    }

    public List<Dish> generateMenu(List<Chef> workingChefs,
                                   List<String> unavailableIngredients,
                                   int numberOfDishes) {
        List<Dish> availableDishes = getAvailableDishes(workingChefs, unavailableIngredients);
        sortDishesByPriority(availableDishes);
        return availableDishes.subList(0, Math.min(numberOfDishes, availableDishes.size()));
    }

    private List<Dish> getAvailableDishes(List<Chef> workingChefs, List<String> unavailableIngredients) {
        List<Dish> availableDishes = new ArrayList<>();
        for (Chef chef : workingChefs) {
            List<Dish> chefDishes = chefDishMap.get(chef);
            if (chefDishes != null) {
                for (Dish dish : chefDishes) {
                    if (dishContainsIngredients(dish, unavailableIngredients)) {
                        availableDishes.add(dish);
                    }
                }
            }
        }
        return availableDishes;
    }

    private boolean dishContainsIngredients(Dish dish, List<String> unavailableIngredients) {
        Set<String> dishIngredients = new HashSet<>(dish.getIngredients());
        return !dishIngredients.containsAll(unavailableIngredients);
    }

    private void sortDishesByPriority(List<Dish> dishes) {
        dishes.sort(Comparator.comparingInt(Dish::getKingRating)
                .thenComparingInt(Dish::getCourtRating)
                .reversed());
    }
}
