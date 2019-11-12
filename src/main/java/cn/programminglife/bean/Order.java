package cn.programminglife.bean;

import java.sql.Timestamp;

/**
 * @author programmerlc
 * @create 2019-10-15-19:22
 */
public class Order {
    private int id;
    private double price;
    private String receiver_name;
    private String receiver_phone;
    private String receiver_address;
    private int pay_status;
    private Timestamp ordertime;
    private int owner_id;

    public Order() {

    }

    public Order(int id, double price, String receiver_name, String receiver_phone, String receiver_address, int pay_status, Timestamp ordertime, int owner_id) {
        this.id = id;
        this.price = price;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.receiver_address = receiver_address;
        this.pay_status = pay_status;
        this.ordertime = ordertime;
        this.owner_id = owner_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public Timestamp getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Timestamp ordertime) {
        this.ordertime = ordertime;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", receiver_name='" + receiver_name + '\'' +
                ", receiver_phone='" + receiver_phone + '\'' +
                ", receiver_address='" + receiver_address + '\'' +
                ", pay_status=" + pay_status +
                ", ordertime=" + ordertime +
                ", owner_id=" + owner_id +
                '}';
    }
}
