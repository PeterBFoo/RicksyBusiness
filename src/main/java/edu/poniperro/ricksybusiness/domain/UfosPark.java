package edu.poniperro.ricksybusiness.domain;

import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher {
    private double fee = 500;
    private final Map<String, String> flota = new HashMap<String, String>();

    UfosPark(){}

    void add(String ufo) {
        flota.putIfAbsent(ufo, null);
    }

    String getUfoOf(String owner) {
        for (String entry : flota.keySet()){
            if (flota.get(entry) == owner) {
                return entry;
            }
        }
        return "";
    }

    @Override
    public void dispatch(CreditCard cliente) {
        String sitio_libre = null;

        for (String key : flota.keySet()) {
            if (flota.get(key) == null) {
                sitio_libre = key;
                break;
            }
        }

        if (getUfoOf(cliente.number()) == "" && sitio_libre != null) {
            if (cliente.pay(fee)) {
                flota.replace(sitio_libre, cliente.number());
                System.out.println("El cliente " + cliente.cardOwner() + " ha sido añadido correctamente");
                }
            }

        else {
            if (getUfoOf(cliente.number()) != "") {
                System.out.println(cliente.cardOwner() + ", usted ya posee un UFO, no puede alquilar otro");
            }
            else {
                System.out.println("Lo sentimos " + cliente.cardOwner() + ", no queda ningún UFO disponible");
            }
        }
    }

    // Just for testing purposes
    Map<String, String> ufos() {
        return this.flota;
    }

    @Override
    public String toString() {
        return "Flota de UFOs -> " + flota;
    }

}
