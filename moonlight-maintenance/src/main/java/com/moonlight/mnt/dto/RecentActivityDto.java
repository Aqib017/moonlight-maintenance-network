package com.moonlight.mnt.dto;

public class RecentActivityDto {

    private String activity;

    public RecentActivityDto() {
    }

    public RecentActivityDto(String activity) {
        this.activity = activity;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}