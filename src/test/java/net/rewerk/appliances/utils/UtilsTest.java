package net.rewerk.appliances.utils;

import net.rewerk.appliances.exceptions.InvalidInputException;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UtilsTest {
    @Test
    public void whenScanDouble_thenCorrect() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        System.setIn(in);
        double given = Utils.scanDouble(false);
        System.setIn(sysInBackup);

        Assert.assertEquals(0.0, given, 0.01);
    }

    @Test(expected = InvalidInputException.class)
    public void whenScanDouble_thenThrowsInvalidInputException() {
        InputStream sysInBackup = System.in;
        ByteArrayInputStream in = new ByteArrayInputStream("test string".getBytes());
        System.setIn(in);

        Utils.scanDouble(false);
        System.setIn(sysInBackup);
    }
}
