package com.example.mymsi.calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by My msi on 2017/10/16.
 */

public class Calculate {
    public Double calculateExpression(String expression) {
        // 预处理
        expression = expression.replaceAll(" ", "");// 去空格
        if (expression.charAt(0) == '-') {// 开头为负数，如-1，改为0-1
            expression = 0 + expression;
        }
        // 校验格式
        if (!Expression.checkFormat(expression)) {
            return null;
        }
        // 处理表达式，改为标准表达式
        expression = Expression.changeToStandardFormat(expression);
        // 拆分符号和数字
        String[] number = expression.split("[^.0-9]");
        List<Double> numberList = new ArrayList();
        for (int i = 0; i < number.length; i++) {
            if (!number[i].equals("")) {
                numberList.add(Double.parseDouble(number[i]));
            }
        }
        String symbolStr = expression.replaceAll("[.0-9]", "");
        return doCalculate(symbolStr, numberList);
    }

//进行计算
    public Double doCalculate(String symbolStr, List<Double> numberList) {
        LinkedList<Character> symbolStack = new LinkedList<>();// 符号栈
        LinkedList<Double> numberStack = new LinkedList<>();// 数字栈
        double result = 0;
        int i = 0;// numberList的标志位
        int j = 0;// symbolStr的标志位
        char symbol;// 操作符号
        double number1, number2;// 符号前后两个数
        while (symbolStack.isEmpty() || !(symbolStack.getLast() == '=' && symbolStr.charAt(j) == '=')) {
            if (symbolStack.isEmpty()) {
                symbolStack.add('=');
                numberStack.add(numberList.get(i++));
            }
            if (Expression.priorityMap.get(symbolStr.charAt(j)) > Expression.priorityMap.get(symbolStack.getLast())) {// 比较符号优先级，若当前符号优先级大于前一个则压栈
                if (symbolStr.charAt(j) == '(') {
                    symbolStack.add(symbolStr.charAt(j++));
                    continue;
                }
                numberStack.add(numberList.get(i++));
                symbolStack.add(symbolStr.charAt(j++));
            } else {// 当前符号优先级小于等于前一个 符号的优先级
                if (symbolStr.charAt(j) == ')' && symbolStack.getLast() == '(') {// 若（）之间没有符号，则“（”出栈
                    j++;
                    symbolStack.removeLast();
                    continue;
                }
                if (symbolStack.getLast() == '(') {// “（”直接压栈
                    numberStack.add(numberList.get(i++));
                    symbolStack.add(symbolStr.charAt(j++));
                    continue;
                }
                number2 = numberStack.removeLast();
                number1 = numberStack.removeLast();
                symbol = symbolStack.removeLast();
                switch (symbol) {
                    case '+':
                        numberStack.add(Expression.addition(number1, number2));
                        break;

                    case '-':
                        numberStack.add(Expression.subtraction(number1, number2));
                        break;

                    case '*':
                        numberStack.add(Expression.multiplication(number1, number2));
                        break;

                    case '/':
                        numberStack.add(Expression.division(number1, number2));
                        break;

                    default:
                        break;
                }
            }
        }
        return numberStack.removeLast();
    }
}

