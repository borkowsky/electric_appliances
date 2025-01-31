package net.rewerk.appliances.services;

import net.rewerk.appliances.items.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ApplianceService {
    public static List<Appliance> generateAppliances() {
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new Bulb("Bulb in living room", 100.0));
        appliances.add(new EcoBulb("Eco bulb in bedroom", 20.0));
        appliances.add(new ElectricKettle("Electric Kettle", 2000.0));
        appliances.add(new Iron("Iron in living room", 2000.0));
        appliances.add(new ElectricStove("Electric Stove in kitchen", 3000.0));
        appliances.add(new MicrowaveOven("Microwave Oven in kitchen", 2000.0));
        return appliances;
    }

    public static List<Appliance> sortAppliances(List<Appliance> appliances, Comparator<? super Appliance> comparator) {
        return appliances.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public static Optional<Appliance> findApplianceByPower(List<Appliance> appliances, double powerMin, double powerMax) {
        return appliances.stream()
                .filter(i -> i.getPower() >= powerMin && i.getPower() <= powerMax)
                .findAny();
    }
}
