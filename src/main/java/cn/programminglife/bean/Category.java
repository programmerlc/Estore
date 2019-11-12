package cn.programminglife.bean;

/**
 * @author programmerlc
 * @create 2019-10-11-19:02
 */
public class Category {
    //编号
    private int id;
    //名称
    private String name;
    //父级分类编号
    private int father_id;

    public Category(int id, String name, int father_id) {
        this.id = id;
        this.name = name;
        this.father_id = father_id;
    }

    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFather_id() {
        return father_id;
    }

    public void setFather_id(int father_id) {
        this.father_id = father_id;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", father_id=" + father_id +
                '}';
    }
}
