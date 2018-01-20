package cn.zhku.waterfowl.modules.ddl.model;

/**
 * Created by Willon on 2018/1/19.
 */
public class DeathMethodVo {

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "DeathMethodVo{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
