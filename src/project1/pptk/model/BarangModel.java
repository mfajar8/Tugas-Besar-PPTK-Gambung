/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.model;

import java.sql.SQLException;
import project1.pptk.database.pptkDatabase;
import project1.pptk.entity.Barang;
import project1.pptk.error.BarangException;
import project1.pptk.event.BarangListener;
import project1.pptk.service.BarangDao;

/**
 *
 * @author LENOVO
 */
public class BarangModel {

    private int no;
    private String nama;
    private int qty;
    private String satuan;
    private int harga_satuan;

    private BarangListener listener;

    public BarangListener getListener() {
        return listener;
    }

    public void setListener(BarangListener listener) {
        this.listener = listener;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
        fireOnChange();
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
        fireOnChange();
    }
    
    public int getHarga_satuan() {
        return harga_satuan;
    }

    public void setHarga_satuan(int harga_satuan) {
        this.harga_satuan = harga_satuan;
        fireOnChange();
    }
    
    protected void fireOnChange() {
        if (listener != null) {
            listener.onChange(this);
        }
    }

    protected void fireOnInsert(Barang barang) {
        if (listener != null) {
            listener.onInsert(barang);
        }
    }

    protected void fireOnUpdate(Barang barang) {
        if (listener != null) {
            listener.onUpdate(barang);
        }
    }

    protected void fireOnDelete() {
        if (listener != null) {
            listener.onDelete();
        }
    }

    public void insertBarang() throws SQLException, BarangException {

        BarangDao dao = pptkDatabase.getBarangDao();
        Barang barang = new Barang();
        barang.setNama(nama);
        barang.setQty(qty);
        barang.setSatuan(satuan);
        barang.setHarga_satuan(harga_satuan);

        dao.insertBarang(barang);
        fireOnInsert(barang);
    }

    public void updateBarang() throws SQLException, BarangException {

        BarangDao dao = pptkDatabase.getBarangDao();
        Barang barang = new Barang();
        barang.setNama(nama);
        barang.setQty(qty);
        barang.setSatuan(satuan);
        barang.setHarga_satuan(harga_satuan);
        barang.setNo(no);

        dao.updateBarang(barang);
        fireOnUpdate(barang);
    }

    public void deleteBarang() throws SQLException, BarangException {
        BarangDao dao = pptkDatabase.getBarangDao();
        dao.deleteBarang(no);
        fireOnDelete();
    }
    
    public void resetBarang(){
        setNo(0);
        setNama("");
        setQty(0);
        setSatuan("");
        setHarga_satuan(0);
        
    }

}
