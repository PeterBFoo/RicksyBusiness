package edu.poniperro.ricksybusiness.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestUfosPark {
    private UfosPark ufosPark = null;
    private CreditCard cliente = new CreditCard("Peter", "1");

    @Before
    public void testConstructorFlota() {
        ufosPark = new UfosPark();
        assertNotNull("Flota creada", ufosPark);
    }

    @Test
    public void añadirUfo() {
        ufosPark.add("Flynaitor 300");
        assertEquals(1, ufosPark.ufos().size());
    }

    @Test
    public void getUfoOfCliente() {
        ufosPark.add("Flynaitor 300");
        ufosPark.dispatch(cliente);
        assertEquals("Flynaitor 300", ufosPark.getUfoOf("1"));
    }

    @Test
    public void dispatchOK() {
        ufosPark.add("Flynaitor 400");
        ufosPark.dispatch(cliente);
        assertEquals("Flynaitor 400", ufosPark.getUfoOf(cliente.number()));
    }

    @Test
    public void cobroDispatchOK() {
        ufosPark.add("Flynaitor 500");
        ufosPark.dispatch(cliente);
        assertEquals(2500, cliente.credit(), 0);
    }

    @Test
    public void cobroDispatchNotOK() {
        cliente.pay(3000);
        ufosPark.add("Flynaitor 500");
        ufosPark.dispatch(cliente);
        assertEquals("", ufosPark.getUfoOf(cliente.number()));
    }

    @Test
    public void ufoNoDisponible() {
        CreditCard cliente_cobro = new CreditCard("Abraham", "2");
        ufosPark.add("Flynaitor 500");
        ufosPark.dispatch(cliente);
        ufosPark.dispatch(cliente_cobro);
        assertEquals(3000, cliente_cobro.credit(), 0);
        assertEquals("", ufosPark.getUfoOf(cliente_cobro.number()));
    }



}
