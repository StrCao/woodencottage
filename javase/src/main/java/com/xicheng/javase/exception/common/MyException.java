package com.xicheng.javase.exception.common;

/**
 * @author xichengxml
 * @date 2018/12/27
 * @description
 */
public class MyException extends Exception {

    private String input;

    public MyException() {
    }

    public MyException(String message, String input) {
        super(message);
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
