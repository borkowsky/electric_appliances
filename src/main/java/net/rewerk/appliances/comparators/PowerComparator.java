package net.rewerk.appliances.comparators;

import net.rewerk.appliances.items.Appliance;

import java.util.Comparator;

public class PowerComparator implements Comparator<Appliance> {
    @Override
    public int compare(Appliance o1, Appliance o2) {
        return Double.compare(o1.getPower(), o2.getPower());
    }
}
