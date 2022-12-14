package com.assignment.loadmanagement.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "load")
public class Load {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String shipmentId;
    public String loadingPoint;
    public String unloadingPoint;
    public String productType;
    public String weight;
    public String truckType;
    public String noOfTrucks;
    public String comment;
    public String date;

    public Load() {
    }

    public Load(long id, String shipmentId, String loadingPoint, String unloadingPoint, String productType, String weight, String truckType, String noOfTrucks, String comment, String date) {
        this.id = id;
        this.shipmentId = shipmentId;
        this.loadingPoint = loadingPoint;
        this.unloadingPoint = unloadingPoint;
        this.productType = productType;
        this.weight = weight;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.comment = comment;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Load{" +
                "id=" + id +
                ", shipmentId='" + shipmentId + '\'' +
                ", loadingPoint='" + loadingPoint + '\'' +
                ", unloadingPoint='" + unloadingPoint + '\'' +
                ", productType='" + productType + '\'' +
                ", weight='" + weight + '\'' +
                ", truckType='" + truckType + '\'' +
                ", noOfTrucks='" + noOfTrucks + '\'' +
                ", comment='" + comment + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(String shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getLoadingPoint() {
        return loadingPoint;
    }

    public void setLoadingPoint(String loadingPoint) {
        this.loadingPoint = loadingPoint;
    }

    public String getUnloadingPoint() {
        return unloadingPoint;
    }

    public void setUnloadingPoint(String unloadingPoint) {
        this.unloadingPoint = unloadingPoint;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public String getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(String noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}