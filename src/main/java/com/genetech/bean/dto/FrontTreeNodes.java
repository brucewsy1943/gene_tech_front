package com.genetech.bean.dto;

import java.util.Arrays;
import java.util.List;

/**前台的树用
 * Created by Administrator on 2020/3/2.
 */
public class FrontTreeNodes {
    private String text;
    private String href;
    private List<FrontTreeNodes> nodes;
    private String[] tags;

    public FrontTreeNodes() {
    }

    public FrontTreeNodes(String text, String href, List<FrontTreeNodes> nodes, String[] tags) {
        this.text = text;
        this.href = href;
        this.nodes = nodes;
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public List<FrontTreeNodes> getNodes() {
        return nodes;
    }

    public void setNodes(List<FrontTreeNodes> nodes) {
        this.nodes = nodes;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "FrontTreeNodes{" +
                "text='" + text + '\'' +
                ", href='" + href + '\'' +
                ", nodes=" + nodes +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
