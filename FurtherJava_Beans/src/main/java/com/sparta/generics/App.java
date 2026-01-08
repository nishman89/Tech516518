package com.sparta.generics;

public class App {
    public static void main(String[] args) {
        IntegerRectangle iRect = new IntegerRectangle(2,4);
        DoubleRectangle dRect = new DoubleRectangle(2.0,4.0);

        ObjectRectangle oRect = new ObjectRectangle(2,4);
        System.out.println(iRect.getWidth() * iRect.getHeight());
        System.out.println(dRect.getWidth() * dRect.getHeight());
        System.out.println((Integer) oRect.getWidth() * (Integer)oRect.getHeight());

        GenericRectangle<Integer> gIRect = new GenericRectangle<>(2,4);
        GenericRectangle<Double> gDRect = new GenericRectangle<>(2.0,4.0);
        // GenericRectangle<String> gSRect = new GenericRectangle<>("Hello", "World");
        System.out.println(gIRect.getHeight() * gIRect.getWidth());
        System.out.println(gDRect.getHeight() * gDRect.getWidth());

        GenericRectangle.outPutToConsole("fdsfds");
        GenericRectangle.outPutToConsole(1);
        GenericRectangle.outPutToConsole(1.0);
    }
}
