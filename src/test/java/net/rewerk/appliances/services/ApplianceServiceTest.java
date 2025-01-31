package net.rewerk.appliances.services;

import net.rewerk.appliances.comparators.PowerComparator;
import net.rewerk.appliances.items.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ApplianceServiceTest {
    List<Appliance> mockAppliancesList = new ArrayList<>();

    @Before
    public void setUp() {
        mockAppliancesList = generateAppliances();
    }

    @After
    public void tearDown() throws Exception {
        mockAppliancesList.clear();
    }

    @Test
    public void givenCorrectSortedApplianceList_whenSortAppliances_thenReturnIsEquals() {
        List<Appliance> expected = mockAppliancesList.stream()
                .sorted(new PowerComparator())
                .toList();

        List<Appliance> given = ApplianceService.sortAppliances(mockAppliancesList, new PowerComparator());

        Assert.assertEquals(expected.getFirst().getName(), given.getFirst().getName());
        Assert.assertEquals(expected.get(1).getName(), given.get(1).getName());
        Assert.assertEquals(expected.get(2).getName(), given.get(2).getName());
        Assert.assertEquals(expected.get(3).getName(), given.get(3).getName());
        Assert.assertEquals(expected.get(4).getName(), given.get(4).getName());
        Assert.assertEquals(expected.getLast().getName(), given.getLast().getName());
    }

    @Test
    public void givenIncorrectSortedApplianceList_whenSortAppliances_thenReturnIsEquals() {
        List<Appliance> expected = mockAppliancesList.stream()
                .sorted(new PowerComparator())
                .collect(Collectors.toList());

        List<Appliance> given = ApplianceService.sortAppliances(mockAppliancesList, new PowerComparator());
        Collections.swap(expected, 0, 1); // swap elements for break order

        Assert.assertNotEquals(expected.getFirst().getName(), given.getFirst().getName());
        Assert.assertNotEquals(expected.get(1).getName(), given.get(1).getName());
        Assert.assertEquals(expected.get(2).getName(), given.get(2).getName());
        Assert.assertEquals(expected.get(3).getName(), given.get(3).getName());
        Assert.assertEquals(expected.get(4).getName(), given.get(4).getName());
        Assert.assertEquals(expected.getLast().getName(), given.getLast().getName());
    }

    @Test
    public void givenCorrectPower_whenFindAppliances_thenReturnPresentedOptionalAppliance() {
        Appliance expected = mockAppliancesList.getFirst();
        Optional<Appliance> given = ApplianceService.findApplianceByPower(mockAppliancesList, 90.0, 100.0);

        Assert.assertTrue(given.isPresent());
        Assert.assertEquals(expected, given.get());
    }

    @Test
    public void givenIncorrectPower_whenFindAppliances_thenReturnNotPresentedOptional() {
        Optional<Appliance> given = ApplianceService.findApplianceByPower(mockAppliancesList, 0.0, 10.0);

        Assert.assertFalse(given.isPresent());
    }

    private static List<Appliance> generateAppliances() {
        List<Appliance> appliances = new ArrayList<>();
        appliances.add(new Bulb("Bulb in living room", 100.0));
        appliances.add(new EcoBulb("Eco bulb in bedroom", 20.0));
        appliances.add(new ElectricKettle("Electric Kettle", 2000.0));
        appliances.add(new Iron("Iron in living room", 2000.0));
        appliances.add(new ElectricStove("Electric Stove in kitchen", 3000.0));
        appliances.add(new MicrowaveOven("Microwave Oven in kitchen", 2000.0));
        return appliances;
    }
}
