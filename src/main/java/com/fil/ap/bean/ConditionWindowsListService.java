package com.fil.ap.bean;

public class ConditionWindowsListService implements ConditionListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
