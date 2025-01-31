package net.rewerk.appliances.items;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplianceTest {
    private Appliance appliance;

    @Before
    public void setUp() throws Exception {
        appliance = new Bulb("Test bulb", 10.0);
    }
    @After
    public void tearDown() throws Exception {
        appliance = null;
    }

    @Test
    public void whenTurnOn_thenStateIsTurnedOn() {
        appliance.turnOn();
        Assert.assertTrue(appliance.isOn());
    }

    @Test
    public void whenTurnOff_thenStateIsTurnedOff() {
        appliance.turnOff();
        Assert.assertFalse(appliance.isOn());
    }
}
