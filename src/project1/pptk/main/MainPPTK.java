/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import project1.pptk.database.pptkDatabase;
import project1.pptk.entity.Barang;
import project1.pptk.error.BarangException;
import project1.pptk.service.BarangDao;
import project1.pptk.view.PPTKMainView;

/**
 *
 * @author LENOVO
 */
public class MainPPTK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, BarangException {
        // TODO code application logic here
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    PPTKMainView barang = new PPTKMainView();
                    barang.loadDatabase();
                    barang.setVisible(true);
                    
                } catch (SQLException e) {
                } catch (BarangException ex) {
                    Logger.getLogger(MainPPTK.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 

        }
    }