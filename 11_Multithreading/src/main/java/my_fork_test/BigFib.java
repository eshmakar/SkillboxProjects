package my_fork_test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigFib {
    public static void main(String[] args) {
        BigDecimal decimal299 = new BigDecimal("137347080577163115432025771710279131845700275212767467264610201");
        BigDecimal decimal300 = new BigDecimal("222232244629420445529739893461909967206666939096499764990979600");
//        BigDecimal divide = decimal300.divide(decimal299, MathContext.UNLIMITED);
//        System.out.println(divide);
        System.out.println(decimal299.multiply(new BigDecimal("1.618033988")));


    }
}
/*
222232244526424577388985002319160524293476216955211693574816694
222232244629420445529739893461909967206666939096499764990979600
*/
