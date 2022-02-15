package edu.poniperro.ricksybusiness.domain;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit = 3000;
    private final String SYMBOL = "EZY";

    CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    boolean pay(double payment) {
        boolean CREDITO_INSUFICIENTE = false;
        boolean CREDITO_ACEPTADO = true;

        if ((this.credit - payment) < 0) {
            System.out.println("El crédito que posee " + cardOwner() + " es insuficiente");
            return CREDITO_INSUFICIENTE;
        }

        else {
            this.credit -= payment;
            return CREDITO_ACEPTADO;
        }
    }

    String number() {
        return this.number;
    }

    String cardOwner() {
        return this.owner;
    }

    double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        return
                "Owner -> " + owner + '\n' +
                "Number -> " + number + '\n' +
                "Credit -> " + credit + SYMBOL + '\n';
    }



}
