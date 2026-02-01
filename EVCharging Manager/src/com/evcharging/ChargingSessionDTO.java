package com.evcharging;

public class ChargingSessionDTO {

    private int sessionId;
    private String vehicleNumber;
    private String stationName;
    private double unitsConsumed;
    private double totalCost;

    public ChargingSessionDTO() {
    }

    public ChargingSessionDTO(int sessionId, String vehicleNumber,
                               String stationName, double unitsConsumed,
                               double totalCost) {
        this.sessionId = sessionId;
        this.vehicleNumber = vehicleNumber;
        this.stationName = stationName;
        this.unitsConsumed = unitsConsumed;
        this.totalCost = totalCost;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public double getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(double unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
