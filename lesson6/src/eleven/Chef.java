package eleven;

import java.util.Set;

public class Chef {
    private final String name;
    private final Set<Dish> dishes;

    public Chef(String name, Set<Dish> dishes) {
        this.name = name;
        this.dishes = dishes;
    }

    public String getName() {
        return name;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }


}
