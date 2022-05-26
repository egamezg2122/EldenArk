/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eldenark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author cep
 */
public class Database {


	private Connection conn;
	
	 public Database() throws SQLException   {
        String url = "jdbc:mysql://localhost/eldenark";
        String usuari = "root";
        String contrasenya = "mysql";
        conn = DriverManager.getConnection(url, usuari, contrasenya);
    }

    public void close() throws SQLException {
        conn.close();
    }
	
	public void insert(String nickname, int level, String path) throws SQLException {
		String query = "insert into gamedata values(?, ?, ?);";
        PreparedStatement st = conn.prepareStatement(query);
        st.setString(1, nickname);
        st.setInt(2, level);
        st.setString(3, path);


        int nRows = st.executeUpdate();
   
    }
	
	public ArrayList<String> getNicknameData() throws SQLException{
		ArrayList<String> nicknames = new ArrayList<>();
		String query = "SELECT username FROM gamedata order by userlevel DESC";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
		
        while (rs.next()) {
            nicknames.add(rs.getString(1));
            
        }
		return nicknames;
	}
	
	public ArrayList<Integer> getLevelData() throws SQLException{
		ArrayList<Integer> levels = new ArrayList<>();
		String query = "SELECT userlevel FROM gamedata order by userlevel DESC";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
		
        while (rs.next()) {
            levels.add(rs.getInt(1));
            
        }
		return levels;
	}
	
	public ArrayList<String> getPathData() throws SQLException{
		ArrayList<String> path = new ArrayList<>();
		String query = "SELECT image FROM gamedata order by userlevel DESC";
        PreparedStatement st = conn.prepareStatement(query);
        ResultSet rs = st.executeQuery();
		
        while (rs.next()) {
            path.add(rs.getString(1));
            
        }
		return path;
	}
	
}
