/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.controller;

import javax.swing.JOptionPane;
import project1.pptk.model.BarangModel;
import project1.pptk.view.PPTKMainView;

/**
 *
 * @author LENOVO
 */
public class BarangController {

    private BarangModel model;

    public void setModel(BarangModel model) {
        this.model = model;
    }

    public void resetBarang(PPTKMainView view) {
        model.resetBarang();
    }

    public void insertBarang(PPTKMainView view) {
        String nama = view.getTxtBarang().getText();
        Integer qty = Integer.parseInt(view.getTxtQty().getText());
        String satuan = view.getTxtSatuan().getText();
        Integer harga = Integer.parseInt(view.getTxtHarga().getText());

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama tidak boleh kosong !");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama barang terlalu panjang !");
        } else if (satuan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama satuan tidak boleh kosong !");
        } else if (satuan.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama satuan terlalu panjang !");
        } else {
            model.setNama(nama);
            model.setQty(qty);
            model.setSatuan(satuan);
            model.setHarga_satuan(harga);

            try {
                model.insertBarang();
                JOptionPane.showMessageDialog(view, "Barang berhasil ditambahkan");
                model.resetBarang();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database dengan pesan ", throwable.getMessage()});
            }
        }
    }

    public void updateBarang(PPTKMainView view) {

        if (view.getTabelBarang().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan diubah");
            return;
        }

        Integer no = Integer.parseInt(view.getTxtNo2().getText());
        String nama = view.getTxtBarang2().getText();
        Integer qty = Integer.parseInt(view.getTxtQty2().getText());
        String satuan = view.getTxtSatuan2().getText();
        Integer harga = Integer.parseInt(view.getTxtHarga2().getText());

        if (nama.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Nama Barang tidak boleh kosong !");
        } else if (nama.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama Barang terlalu panjang !");
        } else if (satuan.trim().equals("")) {
            JOptionPane.showMessageDialog(view, "Satuan Barang tidak boleh kosong !");
        } else if (satuan.length() > 255) {
            JOptionPane.showMessageDialog(view, "Nama satuan terlalu panjang !");
        } else {
            model.setNo(no);
            model.setNama(nama);
            model.setQty(qty);
            model.setSatuan(satuan);
            model.setHarga_satuan(harga);

            try {
                model.updateBarang();
                JOptionPane.showMessageDialog(view, "Barang berhasil diubah");
                model.resetBarang();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database dengan pesan ", throwable.getMessage()});
            }
        }

    }

    public void deleteBarang(PPTKMainView view) {

        if (view.getTabelBarang().getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(view, "Pilih data yang akan dihapus !");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "Anda yakin menghapus data ini?") == JOptionPane.OK_OPTION) {
            Integer no = Integer.parseInt(view.getTxtNo2().getText());
            model.setNo(no);

            try {
                model.deleteBarang();
                JOptionPane.showMessageDialog(view, "Barang berhasil dihapus");
                model.resetBarang();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"Terjadi Error di Database dengan pesan ", throwable.getMessage()});
            }
        }
    }
}
