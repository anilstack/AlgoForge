package com.anilstack.ds.util;

public class Pair<F, S> {
    private final F key;
    private final S value;

    public Pair(F key, S value) {
        this.key = key;
        this.value = value;
    }

    public S getValue() {
        return value;
    }

    public F getKey() {
        return key;
    }
}

