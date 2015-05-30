package com.usefullc.platform.common.cache;

public enum DateUnitEnum {
    SECOND(13), MINUTE(12), HOUR(11), DATE(6);

    private int num;

    DateUnitEnum(int num){
        this.num = num;
    }

    public int getNum() {
        return this.num;
    }
}
