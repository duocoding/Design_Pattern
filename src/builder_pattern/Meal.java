package builder_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Meal
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:46
 * @Version 1.0
 */
public class Meal {

    public List<Item> items = new ArrayList<Item>();

    public void add(Item item){
        items.add(item);
    }

    public float getPrice(){
        float cost = 0.0f;
        for(Item item: items){
            cost+=item.price();
        }
        return cost;
    }

    public void showItems(){
        for(Item item: items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
