package cn.programminglife.bean;

/**
 * @author programmerlc
 * @create 2019-10-15-19:22
 */
public class OrderItem {
    private int product_id;
    private int product_num;
    private int user_id;
    //是否加入订单结算(0表示不加入，1表示加入)
    private int fororder;

    public OrderItem() {

    }

    public OrderItem(int product_id, int product_num, int user_id, int fororder) {
        this.product_id = product_id;
        this.product_num = product_num;
        this.user_id = user_id;
        this.fororder = fororder;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_num() {
        return product_num;
    }

    public void setProduct_num(int product_num) {
        this.product_num = product_num;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getFororder() {
        return fororder;
    }

    public void setFororder(int fororder) {
        this.fororder = fororder;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "product_id=" + product_id +
                ", product_num=" + product_num +
                ", user_id=" + user_id +
                ", fororder=" + fororder +
                '}';
    }
}
