/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import project1.pptk.impl.BarangDaoImpl;
import project1.pptk.service.BarangDao;

/**
 *
 * @author LENOVO
 */
public class pptkDatabase {
    
    private static Connection connection;
    private static BarangDao barangDao;
    
    public static Connection getConnection() throws SQLException{
        if (connection==null) {
            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/ppatk");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        
        return connection;
    }
    
    public static BarangDao getBarangDao() throws SQLException{
        
        if (barangDao==null) {
            barangDao = new BarangDaoImpl(getConnection());
            
        }
        return barangDao;
    }
}
