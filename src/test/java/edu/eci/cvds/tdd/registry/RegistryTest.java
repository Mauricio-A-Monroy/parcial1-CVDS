package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

import static edu.eci.cvds.tdd.registry.Gender.*;

public class RegistryTest {
    private Registry registry = new Registry();
    @Test
    public void validateRegistryResult() {
        Person person = new Person("Felipe", 10, 28, MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }

    @Test
    public void invalidateRegistryResultDEAD() {
        Person person = new Person("Carlos", 27, 60, MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }

    @Test
    public void invalidateRegistryResultDUPLICATE() {
        Person person = new Person("Manuela", 85489614, 23, FEMALE, true);
        RegisterResult result1 = registry.registerVoter(person);
        RegisterResult result2 = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);
    }

    @Test
    public void invalidateRegistryResultUNDERAGE() {
        Person person = new Person("Martín", 102, 10, MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }

    @Test
    public void invalidateRegistryResultINVALIDAGE1() {
        Person person = new Person("natalia", 652, -10, FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }

    @Test
    public void invalidateRegistryResultINVALIDAGE2() {
        Person person = new Person("nelson", 856456, 500, MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }


    // TODO Complete with more test cases
}