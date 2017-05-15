package com.fil.ap.bean;

public class ConditionLinuxListService implements ConditionListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}