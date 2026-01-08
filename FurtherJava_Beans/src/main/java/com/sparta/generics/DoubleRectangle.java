package com.sparta.generics;

public class DoubleRectangle {

    public DoubleRectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    private Double height;
    private Double width;

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

}
