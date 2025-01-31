package net.rewerk.appliances.socket;

import net.rewerk.appliances.items.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SocketTest {
    private final List<Appliance> mockAppliancesList = new ArrayList<>();
    private Socket socket;

    @Before
    public void setUp() {
        mockAppliancesList.add(new Bulb("Bulb in living room", 100.0));
        mockAppliancesList.add(new EcoBulb("Eco bulb in bedroom", 20.0));
        mockAppliancesList.add(new ElectricKettle("Electric Kettle", 2000.0));
        mockAppliancesList.add(new Iron("Iron in living room", 2000.0));
        mockAppliancesList.add(new ElectricStove("Electric Stove in kitchen", 3000.0));
        mockAppliancesList.add(new MicrowaveOven("Microwave Oven in kitchen", 2000.0));
        socket = new Socket(mockAppliancesList);
    }

    @After
    public void tearDown() {
        mockAppliancesList.clear();
        socket = null;
    }

    @Test
    public void givenCorrectId_whenSwitchOn_thenReturnTrue() {
        UUID id = mockAppliancesList.getFirst().getId();
        boolean given = socket.switchOn(id);

        Assert.assertTrue(given);
    }

    @Test
    public void givenIncorrectId_whenSwitchOn_thenReturnNull() {
        UUID id = UUID.randomUUID();
        boolean given = socket.switchOn(id);

        Assert.assertFalse(given);
    }

    @Test
    public void givenCorrectPowerConsumption_whenGetPowerConsumption_thenEquals() {
        UUID id = mockAppliancesList.getFirst().getId();
        socket.switchOn(id);
        double given = socket.getPowerConsumption();

        Assert.assertEquals(100.0, given, 0.001);
    }

    @Test
    public void givenIncorrectPowerConsumption_whenGetPowerConsumption_thenNotEquals() {
        double given = socket.getPowerConsumption();

        Assert.assertNotEquals(100.0, given, 0.001);
    }
}
