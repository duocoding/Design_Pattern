package builder_pattern;

/**
 * @ClassName MealBuilder
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:52
 * @Version 1.0
 */
public class MealBuilder {

    public Meal prepareVegMeal(){
        Meal meal = new Meal();

        meal.add(new VegBurger());
        meal.add(new Coke());

        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();

        meal.add(new ChickenBurger());
        meal.add(new Pepsi());
        meal.add(new Coke());

        return meal;
    }
}
