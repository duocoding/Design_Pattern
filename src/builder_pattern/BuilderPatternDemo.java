package builder_pattern;

/**
 * @ClassName BuilderPatternDemo
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:55
 * @Version 1.0
 */
public class BuilderPatternDemo {

    public static void main(String[] args) {

        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " +vegMeal.getPrice());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("Non Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getPrice());
    }
}
