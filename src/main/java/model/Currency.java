/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author saul
 */
public class Currency {
    
    private String name;
    private String symbol;
    private double amount;
    private String code;
    
    public Currency(String shortName, String name, String symbol, double amount) {
        this.name = name;
        this.symbol = symbol;
        this.amount = amount;
        this.code = shortName;
    }
    
    public void setValue(double value){this.amount = value;}
    
    public void changeCurrency(String nName, String nSymbol, String code){
        this.name = nName; this.symbol = nSymbol; this.code = code;
    }

    public double getAmount() {return amount;}
    public String getName() {return name;}
    public String getSymbol() {return symbol;}
    public String getCode(){return this.code.toLowerCase();}

    @Override
    public String toString() {
        return amount + " "+ symbol;
    }
    
}
