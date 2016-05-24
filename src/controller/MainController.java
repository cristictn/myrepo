package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Magazin;
import model.Produs;

public class MainController {
	public static void incarcaProduseDinDB() throws SQLException{
		final String URL = "jdbc:mysql://127.0.0.1/bazadedate";
		final String USERNAME = "root";
		final String PASSWORD= "";
		
		
	
			 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			 	Connection con=null;
			 	PreparedStatement stmt=null;
				Produs p = null;
				ResultSet rs = null;
				try{
				 con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				 
				 String sql="select * from produse ";
				 
				 stmt = con.prepareStatement(sql);
				rs= stmt.executeQuery();
				Magazin.getInstance().getProduse().clear();
		            while (rs.next()){
		              String denumire = rs.getString(2);
		              double pret = rs.getInt(3);
		              p = new Produs(denumire,pret);
		              Magazin.getInstance().adaugaProdus(p);
		            }
				}
				
				catch(SQLException sqle){
					System.out.println("Eroare db"+sqle);
					
				}finally{
					 rs.close();
					 stmt.close();
					 con.close();
				}
		
	}
	
	
	public static void modificaUnProdus(String denumire,double pretNou) throws SQLException{
		final String URL = "jdbc:mysql://127.0.0.1/bazadedate";
		final String USERNAME = "root";
		final String PASSWORD= "";
		
			 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			 	Connection con=null;
			 	PreparedStatement stmt=null;
				try{
				 con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
				 
				 String sql="update produse set pret = ? where denumire = ?";
				 
				 stmt = con.prepareStatement(sql);
				 
				 stmt.setDouble(1, pretNou);
				 stmt.setString(2, denumire);
 
                 stmt.executeUpdate();

				}
				
				catch(SQLException sqle){
					System.out.println("Eroare db"+sqle);
					
				}finally{
					 stmt.close();
					 con.close();
				}
		
	}
}
