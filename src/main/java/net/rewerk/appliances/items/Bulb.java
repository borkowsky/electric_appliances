package net.rewerk.appliances.items;

public class Bulb extends Appliance {
    public Bulb(String name, double power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Bulb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", state=" + powerState +
                '}';
    }
}
