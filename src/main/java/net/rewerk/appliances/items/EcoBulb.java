package net.rewerk.appliances.items;

public class EcoBulb extends Bulb {
    public EcoBulb(String name, double power) {
        super(name, power);
    }

    @Override
    public String toString() {
        return "EcoBulb{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                ", state=" + powerState +
                '}';
    }
}
