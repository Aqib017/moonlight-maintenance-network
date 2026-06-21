package com.moonlight.mnt.dto;

public class CollectionSummaryDto {

    private Double totalCollection;

    public CollectionSummaryDto(Double totalCollection) {
        this.totalCollection = totalCollection;
    }

    public Double getTotalCollection() {
        return totalCollection;
    }

    public void setTotalCollection(Double totalCollection) {
        this.totalCollection = totalCollection;
    }
}