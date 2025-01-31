package net.rewerk.appliances.socket;

import net.rewerk.appliances.items.Appliance;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Socket {
    private final List<Appliance> appliances;

    public Socket(List<Appliance> appliances) {
        this.appliances = appliances;
    }

    public boolean switchOn(UUID id) {
        Optional<Appliance> appliance = appliances.stream()
                .filter(i -> i.getId().equals(id))
                .findAny();
        if (appliance.isPresent()) {
            appliance.get().turnOn();
            return true;
        } else {
            return false;
        }
    }

    public double getPowerConsumption() {
        return appliances.stream()
                .filter(Appliance::isOn)
                .mapToDouble(Appliance::getPower)
                .reduce(0.0, Double::sum);
    }
}
