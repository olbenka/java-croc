package eleven;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Chef chef1 = new Chef("Петя", new HashSet<>());
        Chef chef2 = new Chef("Ваня", new HashSet<>());

        Dish dish1 = new Dish("Спагетти", new HashSet<>(Arrays.asList("паста", "томатный соус", "мясо")), "основное блюдо", 80, 90);
        Dish dish2 = new Dish("Салат цезарь", new HashSet<>(Arrays.asList("салат", "курица", "помидоры")), "закуска", 70, 85);
        Dish dish3 = new Dish("Шоколадный торт", new HashSet<>(Arrays.asList("мука", "шоколад", "сахар")), "десерт", 90, 80);
        Dish dish4 = new Dish("Яичница", new HashSet<>(Arrays.asList("яйцо", "приправы", "масло")), "завтрак", 80, 70);
        chef1.getDishes().add(dish1);
        chef1.getDishes().add(dish2);
        chef2.getDishes().add(dish2);
        chef2.getDishes().add(dish3);
        chef2.getDishes().add(dish4);


        Map<Chef, Set<Dish>> chefDishesMap = new HashMap<>();
        Manager manager = new Manager(chefDishesMap);

        manager.addChef(chef1);
        manager.addChef(chef2);

        Set<Chef> workingChefs = new HashSet<>(Arrays.asList(chef1, chef2));
        Set<String> unavailableIngredients = new HashSet<>(List.of("курица", "шоколад"));
        List<Dish> menu = manager.generateMenu(workingChefs, unavailableIngredients, 2);

        System.out.println("Обычное меню:");
        for (Dish dish : menu) {
            System.out.println(dish.getName());
        }

        // нужны только завтраки
        Predicate<Dish> dessertRequirement = dish -> dish.getCategory().equals("завтрак");
        List<Dish> specialMenu = manager.generateUpdatedMenu(workingChefs, unavailableIngredients, 2, dessertRequirement);

        System.out.println("\nОбновленное меню:");
        for (Dish dish : specialMenu) {
            System.out.println(dish.getName());
        }

        System.out.println("\nCостав шефов:");
        for (Chef chef : chefDishesMap.keySet()) {
            System.out.println(chef.getName());
            for (Dish dish : chefDishesMap.get(chef)) {
                System.out.println(" - " + dish.getName());
            }
        }

        System.out.println("\nУдаляем " + chef2.getName());
        manager.deleteChef(chef2);

        System.out.println("\n Новый состав шефов:");
        for (Chef chef : chefDishesMap.keySet()) {
            System.out.println(chef.getName());
            for (Dish dish : chefDishesMap.get(chef)) {
                System.out.println(" - " + dish.getName());
            }
        }

    }
}
