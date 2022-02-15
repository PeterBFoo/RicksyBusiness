package edu.poniperro.ricksybusiness.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RickMenuDispatcher implements GuestDispatcher {
    private int stock = 100;
    private double itemCost = 10;
    private final Map<String, String> listaPedidos = new HashMap<String, String>();

    RickMenuDispatcher(){}

    @Override
    public void dispatch(CreditCard cliente) {
        if ((stock > 0) && cliente.pay(itemCost)) {
            stock -= 1;
            listaPedidos.put(cliente.number(), cliente.cardOwner());
        }

        else {
            if (cliente.credit() > 0) {
                System.out.println("Lo sentimos " + cliente.cardOwner() + ", los RickMenus se han agotado");
            }
        }
    }

    @Override
    public String toString() {
        ArrayList<String> lista = new ArrayList<String>();
        for (String pedido : listaPedidos.keySet()) {
            lista.add(listaPedidos.get(pedido));
        }
        return "Lista de pedidos de RickMenus" + "\n" +
                "============================" + "\n" +
                lista;
    }

    // Just for testing purposes

    int getStock() {
        return this.stock;
    }

    int getSizeOfPedidos() {
        return listaPedidos.size();
    }


}
