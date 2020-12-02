package com.ranthas.day02.part01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {

    private Policy policy;
    private String password;

    public Password(Policy policy, String password) {
        this.policy = policy;
        this.password = password;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {

        Pattern pattern = Pattern.compile(policy.getCharacter());
        Matcher matcher = pattern.matcher(password);
        long count = matcher.results().count();

        return policy.isInRange(count);
    }
}
