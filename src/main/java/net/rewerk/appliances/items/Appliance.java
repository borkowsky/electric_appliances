package net.rewerk.appliances.items;

import net.rewerk.appliances.enums.PowerStates;
import net.rewerk.appliances.interfaces.Switchable;

import java.util.UUID;

public abstract class Appliance implements Switchable {
    protected UUID id = UUID.randomUUID();
    protected String name;
    protected double power;
    protected PowerStates powerState = PowerStates.TURNED_OFF;

    @Override
    public void turnOn() {
        powerState = PowerStates.TURNED_ON;
        System.out.printf("[Appliance] %s is turned on (%.2f power)%n",
                this.getClass().getSimpleName(),
                power);
    }

    @Override
    public void turnOff() {
        powerState = PowerStates.TURNED_OFF;
        System.out.printf("[Appliance] %s is turned off (%.2f power)%n",
                this.getClass().getSimpleName(),
                power);
    }

    public UUID getId() {
        return id;
    }

    public double getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    public boolean isOn() {
        return powerState == PowerStates.TURNED_ON;
    }
}
