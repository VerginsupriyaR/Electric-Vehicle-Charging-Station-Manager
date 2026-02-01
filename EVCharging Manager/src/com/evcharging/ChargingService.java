package com.evcharging;

import java.util.List;

public class ChargingService {

    private ChargingSessionDAO dao = new ChargingSessionDAOImpl();

    // Business rule: cost per unit
    private static final double COST_PER_UNIT = 15.0;

    public void startCharging(String vehicleNumber,
                              String stationName,
                              double unitsConsumed) {

        double totalCost = calculateCost(unitsConsumed);

        ChargingSessionDTO session = new ChargingSessionDTO(
                0,
                vehicleNumber,
                stationName,
                unitsConsumed,
                totalCost
        );

        dao.addSession(session);
    }

    public ChargingSessionDTO getSession(int id) {
        return dao.getSessionById(id);
    }

    public List<ChargingSessionDTO> getAllSessions() {
        return dao.getAllSessions();
    }

    public void updateSession(int id,
                              String vehicleNumber,
                              String stationName,
                              double unitsConsumed) {

        double totalCost = calculateCost(unitsConsumed);

        ChargingSessionDTO session = new ChargingSessionDTO(
                id,
                vehicleNumber,
                stationName,
                unitsConsumed,
                totalCost
        );

        dao.updateSession(session);
    }

    public void deleteSession(int id) {
        dao.deleteSession(id);
    }

    // Business logic method
    private double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}
