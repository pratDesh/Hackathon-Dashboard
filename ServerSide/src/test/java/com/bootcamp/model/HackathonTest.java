package com.bootcamp.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HackathonTest {

    @Test
    public void testHashCode() {
        Hackathon underTest = new Hackathon();
        int hashCode = underTest.hashCode();
        Assert.assertEquals(28629151, hashCode);
    }
}
