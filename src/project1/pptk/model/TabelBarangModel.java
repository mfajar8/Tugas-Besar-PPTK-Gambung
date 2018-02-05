/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import project1.pptk.entity.Barang;

/**
 *
 * @author LENOVO
 */
public class TabelBarangModel extends AbstractTableModel {

    private List<Barang> list = new ArrayList<Barang>();

    public void setList(List<Barang> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public boolean add(Barang e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
        }
    }

    public Barang get(int index) {
        return list.get(index);
    }

    public Barang set(int index, Barang element) {
        try {
           return list.set(index, element); 
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Barang remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }
    
    

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NO";
            case 1:
                return "NAMA";
            case 2:
                return "QTY";
            case 3:
                return "SATUAN";
            case 4:
                return "HARGA_SATUAN";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNo();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getQty();
            case 3:
                return list.get(rowIndex).getSatuan();
            case 4:
                return list.get(rowIndex).getHarga_satuan();
            default:
                return null;
        }
    }

}
