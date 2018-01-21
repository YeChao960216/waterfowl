package cn.zhku.waterfowl.modules.epidemic.model;

/**
 * Created by gonefuture on 2018/1/19.
 *
 * 此实体用于显示免疫方法及其对用的数量
 *
 */
public class DiseaesMethodVo {

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
