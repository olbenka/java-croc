package eleven;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Chef chef1 = new Chef("Вася");
        Chef chef2 = new Chef("Петя");
        manager.addChef(chef1);
        manager.addChef(chef2);

        Dish dish1 = new Dish("Спагетти", Arrays.asList("паста", "томатный соус", "мясо"), "основное блюдо", 80, 90);
        Dish dish2 = new Dish("Салат цезарь", Arrays.asList("салат", "курица", "помидоры"), "закуска", 70, 85);
        Dish dish3 = new Dish("Шоколадный торт", Arrays.asList("мука", "шоколад", "сахар"), "десерт", 90, 80);
        Dish dish4 = new Dish("Яичница", Arrays.asList("яйцо", "приправы", "масло"), "завтрак", 80, 70);
        manager.addDishForChef(chef1, dish1);
        manager.addDishForChef(chef1, dish2);
        manager.addDishForChef(chef2, dish2);
        manager.addDishForChef(chef2, dish3);
        manager.addDishForChef(chef2, dish4);
        List<Chef> workingChefs = Arrays.asList(chef1, chef2);
        List<String> unavailableIngredients = Arrays.asList("курица", "шоколад");
        // не успеваю исправить :( 
        List<Dish> menu = manager.generateMenu(workingChefs, unavailableIngredients, 2);

        System.out.println("Меню:");
        for (Dish dish : menu) {
            System.out.println(dish.getName());
        }
    }
}
