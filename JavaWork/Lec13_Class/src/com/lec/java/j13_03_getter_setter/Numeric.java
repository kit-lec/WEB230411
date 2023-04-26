package com.lec.java.j13_03_getter_setter;

public class Numeric {
    private char ch;
    private byte operator;  // getOperator, setOperator
    private int oper1;
    private int operand2;

    // IntelliJ 의  generator 를 사용하면 손쉽게 자동 코드 생성
    // ALT + INSERT : 생성자, getter, setter 등..


    public Numeric() {
    }

    public Numeric(char ch, byte operator, int oper1, int operand2) {
        this.ch = ch;
        this.operator = operator;
        this.oper1 = oper1;
        this.operand2 = operand2;
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public byte getOperator() {
        return operator;
    }

    public void setOperator(byte operator) {
        this.operator = operator;
    }

    public int getOper1() {
        return oper1;
    }

    public void setOper1(int oper1) {
        this.oper1 = oper1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }
}














