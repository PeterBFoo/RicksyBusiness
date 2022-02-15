package edu.poniperro.ricksybusiness.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestRickMenuDispatcher {
    private RickMenuDispatcher listaPedidos = null;
    private CreditCard card = new CreditCard("Peter", "1");

    @Before
    public void menuConstructor() {
        this.listaPedidos = new RickMenuDispatcher();
        assertNotNull("Lista de pedidos creada", listaPedidos);
    }

    @Test
    public void dispatchOK() {
        listaPedidos.dispatch(card);
        assertEquals(99, listaPedidos.getStock());
        assertEquals(1, listaPedidos.getSizeOfPedidos());
    }

    @Test
    public void dispatchNotOK() {
        card.pay(3000);
        listaPedidos.dispatch(card);
        assertEquals(100, listaPedidos.getStock());
        assertEquals(0, listaPedidos.getSizeOfPedidos());
    }
}
