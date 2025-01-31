package net.rewerk.appliances.items;

public class Iron extends Appliance {
    public Iron(String name, double power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Iron{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", state=" + powerState +
                '}';
    }
}
