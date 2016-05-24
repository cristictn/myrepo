package testare;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.MainController;
import junit.framework.Assert;

public class TestMainController {
	 Connection connection=null;

	 @Test
	    public void testConexiune() throws SQLException {
	        Assert.assertNotNull(connection = MainController.getConnection());
	    }
	 
}
