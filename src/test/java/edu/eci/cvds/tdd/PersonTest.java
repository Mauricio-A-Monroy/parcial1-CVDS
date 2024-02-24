package edu.eci.cvds.tdd;

import edu.eci.cvds.tdd.registry.AgeExceptions;
import edu.eci.cvds.tdd.registry.Person;
import edu.eci.cvds.tdd.registry.RegisterResult;
import edu.eci.cvds.tdd.registry.Registry;
import org.junit.Assert;
import org.junit.Test;

import static edu.eci.cvds.tdd.registry.Gender.MALE;

public class PersonTest {
    private Person person = new Person("Felipe", 10, 28, MALE, true);
    @Test
    public void personUnderage() throws AgeExceptions{
        person.setAge(10);
        boolean result = person.isUnderage();
        Assert.assertTrue(result);
    }

    @Test
    public void personHeiguerAgeLimit() throws AgeExceptions{
        person.setAge(18);
        boolean result = person.isUnderage();
        Assert.assertFalse(result);
    }

    @Test
    public void personUnderageLimit() throws AgeExceptions{
        person.setAge(0);
        boolean result = person.isUnderage();
        Assert.assertTrue(result);
    }

    @Test
    public void personHeiguerAge() throws AgeExceptions{
        person.setAge(60);
        boolean result = person.isUnderage();
        Assert.assertFalse(result);
    }

    @Test
    public void personHeiguerAgeUpperLimit() throws AgeExceptions{
        person.setAge(120);
        boolean result = person.isUnderage();
        Assert.assertFalse(result);
    }

    @Test
    public void invalidateNegativeAgeLimit() throws AgeExceptions {
        person.setAge(-1);
        try {
            boolean result = person.isUnderage();
        } catch (AgeExceptions e) {
            Assert.assertEquals(AgeExceptions.ageInvalid, e.getMessage());
        }
    }

    @Test
    public void invalidateNegativeAge() throws AgeExceptions{
        person.setAge(-10);
        try {
            boolean result = person.isUnderage();
        } catch (AgeExceptions e) {
            Assert.assertEquals(AgeExceptions.ageInvalid, e.getMessage());
        }
    }

    @Test
    public void invalidatePositiveAgeLimit() throws AgeExceptions{
        person.setAge(121);
        try {
            boolean result = person.isUnderage();
        } catch (AgeExceptions e) {
            Assert.assertEquals(AgeExceptions.ageInvalid, e.getMessage());
        }
    }
}
