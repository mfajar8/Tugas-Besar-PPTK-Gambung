/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.service;

import java.util.List;
import project1.pptk.entity.Barang;
import project1.pptk.error.BarangException;

/**
 *
 * @author LENOVO
 */
public interface BarangDao {
    
    public void insertBarang(Barang barang) throws BarangException;
    public void updateBarang(Barang barang) throws BarangException;
    public void deleteBarang(Integer no) throws BarangException;
    
    public Barang getBarang (Integer no) throws BarangException;
    public Barang getBarang (String nama) throws BarangException;
    
    public List<Barang> selectAllBarang() throws BarangException;
    public List<Barang> cariCepat(String nama) throws BarangException;
    
}
