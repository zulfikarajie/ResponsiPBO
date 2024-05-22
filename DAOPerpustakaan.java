/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PerpustakaanDAO;

/**
 *
 * @author apang
 */

import java.sql.*;
import java.util.*;
import ModelPackage.*;
import Connection.Connector;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAOImplements.PerpusDAOImpl;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAOPerpustakaan implements PerpusDAOImpl {

    Connection connection;
    final String select = "select *from buku";
    final String insert = "INSERT INTO buku (judul, penulis, rating, harga) VALUES (?, ?, ?, ?);";
    final String update = "update buku set judul=?, penulis=?,harga=? where id=?";
    final String delete = "delete from data where id=?;";

    public DAOPerpustakaan() {
        connection = Connector.connection();
    }

    @Override
    public void insert(ModelData m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setString(2, m.getPenulis());
            statement.setFloat(3, m.getRating());

            int biayaPerawatan = 500;
            int tambahanBiaya = 1000;
            int total;

            total= (int) (m.getHarga()+biayaPerawatan+(m.getRating()*100));
            
            statement.setInt(4, total);

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil ditambahkan", "sukses", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Buku sudah ditambahkan", "error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(ModelData m) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, m.getJudul());
            statement.setString(2, m.getPenulis());
            statement.setFloat(3, m.getRating());

            int biayaPerawatan = 500;
            int tambahanBiaya = 1000;
            int total;

            total= (int) (m.getHarga()+biayaPerawatan+(m.getRating()*100));
            
            statement.setInt(4, total);

            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil ditambahkan", "sukses", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Buku sudah ditambahkan", "error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        try {
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<ModelData> getALL() {
        List<ModelData> md = null;

        try {
            md = new ArrayList<ModelData>();
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(select);

            while (result.next()) {

                ModelData buku = new ModelData();
                buku.setJudul(result.getString("judul"));
                buku.setPenulis(result.getString("penulis"));
                buku.setRating(result.getFloat("rating"));
                buku.setHarga(result.getInt("harga"));

                md.add(buku);
            }
            result.close();
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOPerpustakaan.class.getName()).log(Level.SEVERE, null, ex);

        }
        return md;
    }

}

