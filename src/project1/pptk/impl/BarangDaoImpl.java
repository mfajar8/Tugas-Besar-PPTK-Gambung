/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1.pptk.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import project1.pptk.entity.Barang;
import project1.pptk.error.BarangException;
import project1.pptk.service.BarangDao;

/**
 *
 * @author LENOVO
 */
public class BarangDaoImpl implements BarangDao {

    private Connection connection;

    private final String insertBarang = "INSERT INTO BARANG (NAMA,QTY,SATUAN,HARGA_SATUAN) VALUES (?,?,?,?)";
    private final String updateBarang = "UPDATE BARANG SET NAMA=?, QTY=?, SATUAN=?, HARGA_SATUAN=? WHERE NO=?";
    private final String deleteBarang = "DELETE FROM BARANG WHERE NO=?";
    private final String getByNo = "SELECT * FROM BARANG WHERE NO=?";
    private final String getByNama = "SELECT * FROM BARANG WHERE NAMA=?";
    private final String selectAll = "SELECT * FROM BARANG";

    public BarangDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertBarang(Barang barang) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertBarang, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, barang.getNama());
            statement.setInt(2, barang.getQty());
            statement.setString(3, barang.getSatuan());
            statement.setInt(4, barang.getHarga_satuan());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                barang.setNo(result.getInt(1));
            }

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }

    }

    @Override
    public void updateBarang(Barang barang) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(updateBarang);
            statement.setString(1, barang.getNama());
            statement.setInt(2, barang.getQty());
            statement.setString(3, barang.getSatuan());
            statement.setInt(4, barang.getHarga_satuan());
            statement.setInt(5, barang.getNo());
            statement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public void deleteBarang(Integer no) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(deleteBarang);
            statement.setInt(1, no);
            statement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }

    }

    @Override
    public Barang getBarang(Integer no) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(getByNo);
            statement.setInt(1, no);

            ResultSet result = statement.executeQuery();
            Barang barang = null;

            if (result.next()) {
                barang = new Barang();
                barang.setNo(result.getInt("NO"));
                barang.setNama(result.getString("NAMA"));
                barang.setQty(result.getInt("QTY"));
                barang.setSatuan(result.getString("SATUAN"));
                barang.setHarga_satuan(result.getInt("HARGA_SATUAN"));
            } else {
                throw new BarangException("Barang dengan NO " + no + " tidak ditemukan !");
            }
            connection.commit();
            return barang;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public Barang getBarang(String nama) throws BarangException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(getByNama);
            statement.setString(1, nama);

            ResultSet result = statement.executeQuery();
            Barang barang = null;

            if (result.next()) {
                barang = new Barang();
                barang.setNo(result.getInt("NO"));
                barang.setNama(result.getString("NAMA"));
                barang.setQty(result.getInt("QTY"));
                barang.setSatuan(result.getString("SATUAN"));
                barang.setHarga_satuan(result.getInt("HARGA_SATUAN"));
            } else {
                throw new BarangException("Barang dengan Nama " + nama + " tidak ditemukan !");
            }
            connection.commit();
            return barang;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }
    }

    @Override
    public List<Barang> selectAllBarang() throws BarangException {
        Statement statement = null;
        List<Barang> list = new ArrayList<Barang>();
        try {
            connection.setAutoCommit(false);

            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);

            Barang barang = null;

            while (result.next()) {
                barang = new Barang();
                barang.setNo(result.getInt("NO"));
                barang.setNama(result.getString("NAMA"));
                barang.setQty(result.getInt("QTY"));
                barang.setSatuan(result.getString("SATUAN"));
                barang.setHarga_satuan(result.getInt("HARGA_SATUAN"));
                list.add(barang);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }

    }

    @Override
    public List<Barang> cariCepat(String nama) throws BarangException {
        Statement statement = null;
        List<Barang> list = new ArrayList<Barang>();
        try {

            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM BARANG WHERE NAMA LIKE '%"+nama+"%'");

            Barang barang = null;

            while (result.next()) {
                barang = new Barang();
                barang.setNo(result.getInt("NO"));
                barang.setNama(result.getString("NAMA"));
                barang.setQty(result.getInt("QTY"));
                barang.setSatuan(result.getString("SATUAN"));
                barang.setHarga_satuan(result.getInt("HARGA_SATUAN"));
                list.add(barang);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new BarangException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }

        }

    }
}
