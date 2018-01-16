package cn.zhku.waterfowl.modules.aquaculture.model;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2018/1/15 17:25.
 * 说明：
 */
public class FeedWeight {
    private String name;

    private float feedWeight;

    private float weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFeedWeight() {
        return feedWeight;
    }

    public void setFeedWeight(float feedWeight) {
        this.feedWeight = feedWeight;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "FeedWeight{" +
                "name='" + name + '\'' +
                ", feedWeight=" + feedWeight +
                ", weight=" + weight +
                '}';
    }
}
