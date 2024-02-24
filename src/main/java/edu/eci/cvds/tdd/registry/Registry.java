package edu.eci.cvds.tdd.registry;

import java.util.Set;
import java.util.HashSet;

public class Registry {
    private Set<Integer> id;

    public Registry(){
        id = new HashSet<>();
    }

    public RegisterResult registerVoter(Person p) {

        RegisterResult registry = RegisterResult.VALID;

        if (p.getAge() < 18){
            registry = RegisterResult.UNDERAGE;
        }

        if (!(p.isAlive())){
            registry = RegisterResult.DEAD;
        }
        
        if (p.getAge() <= 0 || p.getAge() > 135){
            registry = RegisterResult.INVALID_AGE;
        }

        if (id.contains(p.getId())){
            registry = RegisterResult.DUPLICATED;
        } else{
            id.add(p.getId());
        }

        // TODO Validate person and return real result.
        return registry;
    }
}