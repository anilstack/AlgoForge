package com.anilstack.ds.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class TreeNodeV1 {
    private int val;
    private List<TreeNodeV1> children;

    public TreeNodeV1(int val) {
        this.val = val;
        this.children = new ArrayList<>();
    }

    // Getter and setter for val
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    // Getter and setter for children
    public List<TreeNodeV1> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNodeV1> children) {
        this.children = children;
    }
}
