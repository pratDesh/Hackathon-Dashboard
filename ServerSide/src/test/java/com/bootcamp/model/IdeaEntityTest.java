package com.bootcamp.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IdeaEntityTest {
    @Test
    public void testHashCode() {
        Idea underTest = new Idea();
        int hashCode = underTest.hashCode();
        Assert.assertNotNull(hashCode);
    }
}
