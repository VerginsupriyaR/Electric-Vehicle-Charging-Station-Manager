package com.evcharging;

import java.util.List;

public interface ChargingSessionDAO {

    void addSession(ChargingSessionDTO session);

    ChargingSessionDTO getSessionById(int id);

    List<ChargingSessionDTO> getAllSessions();

    void updateSession(ChargingSessionDTO session);

    void deleteSession(int id);
}
