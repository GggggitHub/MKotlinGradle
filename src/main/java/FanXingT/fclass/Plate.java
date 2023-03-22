package FanXingT.fclass;

/**
 * @author Ajie
 * @date 2022/11/24
 * @function
 */ // 盘子  最简单的容器类
public class Plate<T> {
    private T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

}
