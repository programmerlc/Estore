package cn.programminglife.bean;

/**
 * @author programmerlc
 * @create 2019-10-15-19:25
 */
public class Shopcart {
    private int product_id;
    private int product_num;
    private int user_id;

    public Shopcart() {

    }

    public Shopcart(int product_id, int product_num, int user_id) {
        this.product_id = product_id;
        this.product_num = product_num;
        this.user_id = user_id;
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

    @Override
    public String toString() {
        return "Shopcart{" +
                "product_id=" + product_id +
                ", product_num=" + product_num +
                ", user_id=" + user_id +
                '}';
    }
}
