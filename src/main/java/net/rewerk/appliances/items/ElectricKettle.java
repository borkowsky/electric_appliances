package net.rewerk.appliances.items;

public class ElectricKettle extends Appliance {
    public ElectricKettle(String name, double power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String toString() {
        return "ElectricKettle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", state=" + powerState +
                '}';
    }
}
