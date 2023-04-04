package br.com.julio.math;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtract(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiply(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double mean(Double numberOne, Double numberTwo) {

        return (numberOne / numberTwo) / 2;
    }

    public Double sqrt(Double number) {
        return Math.sqrt(number);
    }

}
