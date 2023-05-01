package com.example.room.common.constants;

import java.util.function.Function;

public enum FeeTypeStatus {
    PACKAGE((fee) -> fee * 6),
    TIME((fee, time, morningAfternoon) -> (fee * time) * morningAfternoon);

    private Function<Integer, Integer> packageExpress;
    private TriFunction<Integer, Integer, Double, Double> timeExpress;

    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {

        R apply(T t, U u, V v);
    }

    FeeTypeStatus(TriFunction<Integer, Integer, Double, Double> expression) {
        this.timeExpress = expression;
    }

    FeeTypeStatus(Function<Integer, Integer> packageExpress) {
        this.packageExpress = packageExpress;
    }

    public double calculator(int a) {
        return packageExpress.apply(a);
    }

    public double calculator(int a, int b, double c) {
        return timeExpress.apply(a, b, c);
    }

    public static boolean isPackageFeeCode(FeeTypeStatus code) {
        return FeeTypeStatus.PACKAGE.name().equals(code.name());
    }
}
