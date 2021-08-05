package com.sum.simpleadapter;

/**
 * @author liujiang
 * created at: 2021/8/5 14:28
 * Desc:
 */
public class ItemBean {
    private String titie;
    private int type;

    public ItemBean(String titie, int type) {
        this.titie = titie;
        this.type = type;
    }

    public String getTitie() {
        return titie;
    }

    public void setTitie(String titie) {
        this.titie = titie;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
