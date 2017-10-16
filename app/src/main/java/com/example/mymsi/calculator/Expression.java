package com.example.mymsi.calculator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by My msi on 2017/10/16.
 */

public class Expression {
    public static final Map<Character, Integer>  priorityMap = new HashMap<Character, Integer>();// 符号优先级设置一个map
    static {
        priorityMap.put('=', 0);
        priorityMap.put('-', 1);
        priorityMap.put('+', 1);
        priorityMap.put('*', 2);
        priorityMap.put('/', 2);
        priorityMap.put('(', 3);
        priorityMap.put(')', 1);
    }

    //检查表达式格式是否正确
    public static boolean checkFormat(String string) {
        // 校验是否以“=”结尾
        if ('=' != string.charAt(string.length() - 1)) {
            return false;
        }
        // 校验开头是否为数字或者“(”
        if (!(isCharNumber(string.charAt(0)) || string.charAt(0) == '(')) {
            return false;
        }
        char c;
        // 校验
        for (int i = 1; i < string.length() - 1; i++) {
            c = string.charAt(i);
            if (!isCorrectChar(c)) {// 字符不合法
                return false;
            }
            if (!(isCharNumber(c))) {
                if (c == '-' || c == '+' || c == '*' || c == '/') {
                    if (c == '-' && string.charAt(i - 1) == '(') {// 1*(-2+3)的情况
                        continue;
                    }
                    if (!(isCharNumber(string.charAt(i - 1)) || string.charAt(i - 1) == ')')) {// 若符号前一个不是数字或者“）”时
                        return false;
                    }
                }
                if (c == '.') {
                    if (!isCharNumber(string.charAt(i - 1)) || !isCharNumber(string.charAt(i + 1))) {// 校验“.”的前后是否位数字
                        return false;
                    }
                }
            }
        }
        return isGenerateParentheses(string);// 校验括号是否配对
    }

    //将普通的表达式格式转换成标准格式，如2(-1+2)(3+4)改为2*(0-1+2)*(3+4)
    public static String changeToStandardFormat(String string) {
        StringBuilder sb = new StringBuilder();
        char c;
        for (int i = 0; i < string.length(); i++) {
            c = string.charAt(i);
            if (i != 0 && c == '(' && (isCharNumber(string.charAt(i - 1)) || string.charAt(i - 1) == ')')) {
                sb.append("*(");
                continue;
            }
            if (c == '-' && string.charAt(i - 1) == '(') {
                sb.append("0-");
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    // 检查括号是否配对
    public static boolean  isGenerateParentheses (String string) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : string.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.removeLast();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    //处理计算结果的显示
    public static String formatResult(String string) {
        String[] str = string.split("\\.");
        if (Integer.parseInt(str[1]) == 0) {
            return str[0];// 整数
        }
        String s1 = new StringBuilder(str[1]).reverse().toString();
        int start = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        return str[0] + "." + new StringBuilder(s1.substring(start, s1.length())).reverse();
    }

    //检查字符是否合法
    public static boolean isCorrectChar(Character c) {
        if (('0' <= c && c <= '9') || c == '-' || c == '+' || c == '*' || c == '/' || c == '(' || c == ')'
                || c == '.') {
            return true;
        }
        return false;
    }

    //判断是否为数字
    public static boolean isCharNumber(Character c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;

    }
    //计算结果

    //加法
    public static double addition(double number1, double number2) {
        return number1 + number2;
    }
    //减法
    public static double subtraction(double number1, double number2) {
        return number1 - number2;
    }
    //乘法
    public static double multiplication(double number1, double number2) {
        return number1 * number2;
    }
    //除法
    public static double division(double number1, double number2) {
        return number1 / number2;
    }
}
