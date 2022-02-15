package edu.poniperro.ricksybusiness.domain;

public class CrystalExpender implements GuestDispatcher {
    private int stock;
    private double itemCost;

    CrystalExpender(int cantidad, double precio) {
        this.stock = cantidad;
        this.itemCost = precio;
    }

    public int stock() {
        return this.stock;
    }

    @Override
    public void dispatch(CreditCard cliente) {
        if (stock() > 0 && cliente.pay(itemCost)) {
            this.stock -= 1;
        }
        else {
            if (stock() <= 0) {
                System.out.println("Lo sentimos " + cliente.cardOwner() + ", el Crystal se ha agotado");
            }
        }
    }

    @Override
    public String toString() {
        return "Stock -> " + stock +
                ", Precio -> " + itemCost;
    }
}
