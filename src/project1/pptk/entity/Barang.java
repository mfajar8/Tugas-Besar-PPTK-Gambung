/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.entity;

import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Barang {
    
    private Integer no;
    private String nama;
    private Integer qty;
    private String satuan;
    private Integer harga_satuan;
    
    public Barang(){
        
    }

    public Barang(String nama, Integer qty, String satuan, Integer harga_satuan) {
        this.nama = nama;
        this.qty = qty;
        this.satuan = satuan;
        this.harga_satuan = harga_satuan;
    }
    
    

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Integer getHarga_satuan() {
        return harga_satuan;
    }

    public void setHarga_satuan(Integer harga_satuan) {
        this.harga_satuan = harga_satuan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.no);
        hash = 19 * hash + Objects.hashCode(this.nama);
        hash = 19 * hash + Objects.hashCode(this.qty);
        hash = 19 * hash + Objects.hashCode(this.satuan);
        hash = 19 * hash + Objects.hashCode(this.harga_satuan);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Barang other = (Barang) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        if (!Objects.equals(this.satuan, other.satuan)) {
            return false;
        }
        if (!Objects.equals(this.no, other.no)) {
            return false;
        }
        if (!Objects.equals(this.qty, other.qty)) {
            return false;
        }
        if (!Objects.equals(this.harga_satuan, other.harga_satuan)) {
            return false;
        }
        return true;
    }
    
    
    
}
