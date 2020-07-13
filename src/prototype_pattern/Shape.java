package prototype_pattern;

/**
 * @ClassName Shape
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/12 8:34
 * @Version 1.0
 */
public abstract class Shape implements Cloneable{

    private String id;
    public String type;

    abstract void draw();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }


    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }


}
