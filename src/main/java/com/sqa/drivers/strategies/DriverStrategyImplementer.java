package com.sqa.drivers.strategies;

public class DriverStrategyImplementer {

    public static com.sqa.drivers.strategies.DriverStrategy chooseStrategy(String strategy) {
        switch (strategy) {
            case "chrome":
                return new com.sqa.drivers.strategies.Chrome();
            case "firefox":
                return new Firefox();
            default:
                return null;
        }
    }
}