package com.javaer.proxy;

public class HouseProxy implements House{
    House house;
    public HouseProxy(House house){
        this.house = house;
    }
    public void buy() {
        System.out.println("------买房前申请房产审批");
        this.house.buy();
        System.out.println("------买房后拿到房本");
    }
    public static void main(String[] args) {
        House1 house1 = new House1();
        House house = new HouseProxy(house1);
        house.buy();

    }
}
