package com.anilstack.ds.util;

/**
 * @author 𝓐𝓷𝓲𝓵𝓡𝓪𝓳𝓾
 */
public class TrieNode {

    private TrieNode[] children = null;
    private boolean isWordEnd;

    public TrieNode() {
        children = new TrieNode[26];
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isWordEnd() {
        return isWordEnd;
    }

    public void setWordEnd(boolean wordEnd) {
        isWordEnd = wordEnd;
    }
}
