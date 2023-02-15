package com.self.fruits.modal;

/**
 * @program: fruits
 * @description:
 * @author: twl
 * @create: 2023-02-15 10:04
 **/
public class Activity {
    private Boolean isSub;
    private Double subHighest;
    private Double subNum;

    public Activity(Boolean isSub, Double subHighest, Double subNum) {
        this.isSub = isSub;
        this.subHighest = subHighest;
        this.subNum = subNum;
    }

    public Double getSubHighest() {
        return subHighest;
    }

    public void setSubHighest(Double subHighest) {
        this.subHighest = subHighest;
    }

    public Double getSubNum() {
        return subNum;
    }

    public void setSubNum(Double subNum) {
        this.subNum = subNum;
    }

    public Boolean getSub() {
        return isSub;
    }

    public void setSub(Boolean sub) {
        isSub = sub;
    }
}
