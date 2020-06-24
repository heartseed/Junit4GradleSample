package com.akadatsky.design;

public class Exchange {
    String source;
    String target;

    // 1 source = value * target;
    float value;

    public Exchange(String source, String target, Float value) {
        this.source = source;
        this.target = target;
        this.value = value;
    }
}
