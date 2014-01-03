/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.moz.kuriovizor.domain;

/**
 *
 * @author moz
 */
public class UnitToProduce {
    private Unit2 unit;
    private int count;

    public UnitToProduce() {
    }
    
    public UnitToProduce(Unit2 unit, int count) {
        this.unit = unit;
        this.count = count;
    }

    public Unit2 getUnit() {
        return unit;
    }

    public void setUnit(Unit2 unit) {
        this.unit = unit;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
