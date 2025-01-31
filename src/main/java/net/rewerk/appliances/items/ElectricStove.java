package net.rewerk.appliances.items;

public class ElectricStove extends Appliance {
    public ElectricStove(String name, double power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String toString() {
        return "ElectricStove{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", state=" + powerState +
                '}';
    }
}
