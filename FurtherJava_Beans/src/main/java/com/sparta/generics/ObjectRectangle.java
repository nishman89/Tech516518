package com.sparta.generics;

public class ObjectRectangle {
    public ObjectRectangle(Object width, Object height) {
        this.width = width;
        this.height = height;
    }

    private Object width;

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public Object getWidth() {
        return width;
    }

    public void setWidth(Object width) {
        this.width = width;
    }

    private Object height;
}
