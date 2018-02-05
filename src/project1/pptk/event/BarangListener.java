/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.event;

import project1.pptk.entity.Barang;
import project1.pptk.model.BarangModel;

/**
 *
 * @author LENOVO
 */
public interface BarangListener {
    
    public void onChange(BarangModel model);
    public void onInsert(Barang barang);
    public void onUpdate(Barang barang);
    public void onDelete();
    
}
