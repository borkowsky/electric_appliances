package net.rewerk.appliances.services;

import net.rewerk.appliances.items.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ApplianceService {
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

    public static List<Appliance> findAppliances(List<Appliance> appliances, Predicate<Appliance> filter) {
        return appliances.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }
}
