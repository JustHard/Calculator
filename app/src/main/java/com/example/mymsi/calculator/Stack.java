package com.example.mymsi.calculator;

/**
 * Created by My msi on 2017/9/17.
 */

public interface Stack<T> {
    public abstract boolean isEmpty();
    public abstract void push(T x);
    public abstract T peek();
    public abstract T pop();
}