package com.coolkids.coolKidsApp.services;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class AdminValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {

        return true;
    }
}
