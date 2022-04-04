package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaDAO {

	public boolean esisteParola(String parola) {

		final String sql = "Select * "
				+ "from parola "
				+ "where nome= ?";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1,parola);
			
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				conn.close();
				return true;
			}
			
			conn.close();
			return false;

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore DB", e);
		}
	}
	
	
}
