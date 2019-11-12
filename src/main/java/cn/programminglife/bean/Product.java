package cn.programminglife.bean;

/**
 * @author programmerlc
 * @create 2019-10-11-19:06
 */
public class Product {
    private int id;
    private String title;
    private double price;
    private int pnum;
    private String img_url;
    private String description;
    private String color;
    private int category_id;

    public Product(int id, String title, double price, int pnum, String img_url, String description, String color, int category_id) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.pnum = pnum;
        this.img_url = img_url;
        this.description = description;
        this.color = color;
        this.category_id = category_id;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", pnum=" + pnum +
                ", img_url='" + img_url + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
