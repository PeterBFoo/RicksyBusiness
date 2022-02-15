package edu.poniperro.ricksybusiness.domain;

import java.util.ArrayList;
import java.util.List;

public class Receptivo implements GuestDispatcher {
    private final List<GuestDispatcher> observers = new ArrayList<GuestDispatcher>();

    Receptivo() {}

    void registra(GuestDispatcher servicio) {
        observers.add(servicio);
    }

    @Override
    public void dispatch(CreditCard tarjeta_credito) {
        for (GuestDispatcher servicio : observers) {
            servicio.dispatch(tarjeta_credito);
        }
    }
}
