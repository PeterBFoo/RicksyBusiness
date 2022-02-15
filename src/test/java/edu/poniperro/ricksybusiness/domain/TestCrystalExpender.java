package edu.poniperro.ricksybusiness.domain;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestCrystalExpender {
    private CrystalExpender expender = null;

    @Test
    public void testConstructor() {
        expender = new CrystalExpender(10, 20);
        assertNotNull(expender);
    }

    @Test
    public void testCrystalDispatch() {
        testConstructor();
        CreditCard card = new CreditCard("Peter", "1");
        expender.dispatch(card);
        assertEquals(9, expender.stock());
        assertEquals(2980, card.credit(), 0);
    }

    @Test
    public void testCrystalDispatchNotOK() {
        testConstructor();
        CreditCard card = new CreditCard("Peter", "1");
        card.pay(3000);
        expender.dispatch(card);
        assertEquals(10, expender.stock());
        assertEquals(0, card.credit(), 0);
    }

    @Test
    public void noStock() {
        expender = new CrystalExpender(0, 20);
        CreditCard card = new CreditCard("Peter", "1");
        expender.dispatch(card);
        assertEquals(0, expender.stock());
        assertEquals(3000, card.credit(), 0);
    }

}
