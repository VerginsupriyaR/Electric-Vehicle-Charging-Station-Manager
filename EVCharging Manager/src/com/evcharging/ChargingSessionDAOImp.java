package com.evcharging;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ChargingSessionDAOImpl implements ChargingSessionDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/ev_charging";
	private static final String USER = "root";
	private static final String PASS = "root1"; // change if your password is different


	@Override
	public void addSession(ChargingSessionDTO session) {
		try {
	        Connection con = DriverManager.getConnection(URL, USER, PASS);

	        String sql = "INSERT INTO charging_session " +
	                     "(vehicle_number, station_name, units_consumed, total_cost) " +
	                     "VALUES (?, ?, ?, ?)";

	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, session.getVehicleNumber());
	        pst.setString(2, session.getStationName());
	        pst.setDouble(3, session.getUnitsConsumed());
	        pst.setDouble(4, session.getTotalCost());

	        pst.executeUpdate();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public ChargingSessionDTO getSessionById(int id) {
		 ChargingSessionDTO session = null;

		    try {
		        Connection con = DriverManager.getConnection(URL, USER, PASS);

		        String sql = "SELECT * FROM charging_session WHERE session_id=?";
		        PreparedStatement pst = con.prepareStatement(sql);
		        pst.setInt(1, id);

		        ResultSet rs = pst.executeQuery();

		        if (rs.next()) {
		            session = new ChargingSessionDTO(
		                    rs.getInt("session_id"),
		                    rs.getString("vehicle_number"),
		                    rs.getString("station_name"),
		                    rs.getDouble("units_consumed"),
		                    rs.getDouble("total_cost")
		            );
		        }

		        con.close();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return session;
	}

	@Override
	public List<ChargingSessionDTO> getAllSessions() {
		List<ChargingSessionDTO> list = new ArrayList<>();

	    try {
	        Connection con = DriverManager.getConnection(URL, USER, PASS);

	        String sql = "SELECT * FROM charging_session";
	        PreparedStatement pst = con.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            list.add(new ChargingSessionDTO(
	                    rs.getInt("session_id"),
	                    rs.getString("vehicle_number"),
	                    rs.getString("station_name"),
	                    rs.getDouble("units_consumed"),
	                    rs.getDouble("total_cost")
	            ));
	        }

	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	@Override
	public void updateSession(ChargingSessionDTO session) {
		try {
	        Connection con = DriverManager.getConnection(URL, USER, PASS);

	        String sql = "UPDATE charging_session SET vehicle_number=?, " +
	                     "station_name=?, units_consumed=?, total_cost=? " +
	                     "WHERE session_id=?";

	        PreparedStatement pst = con.prepareStatement(sql);
	        pst.setString(1, session.getVehicleNumber());
	        pst.setString(2, session.getStationName());
	        pst.setDouble(3, session.getUnitsConsumed());
	        pst.setDouble(4, session.getTotalCost());
	        pst.setInt(5, session.getSessionId());

	        pst.executeUpdate();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void deleteSession(int id) {
		 try {
		        Connection con = DriverManager.getConnection(URL, USER, PASS);

		        String sql = "DELETE FROM charging_session WHERE session_id=?";
		        PreparedStatement pst = con.prepareStatement(sql);
		        pst.setInt(1, id);

		        pst.executeUpdate();
		        con.close();

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}

}
