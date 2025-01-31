package net.rewerk.appliances.items;

public class MicrowaveOven extends Appliance {
    public MicrowaveOven(String name, double power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String toString() {
        return "MicrowaveOven{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", state=" + powerState +
                '}';
    }
}
