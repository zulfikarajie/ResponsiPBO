/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 * 
 * Author: apang
 */

import java.util.List;
import PerpustakaanDAO.DAOPerpustakaan;
import DAOImplements.PerpusDAOImpl;
import javax.swing.JOptionPane;
import ModelPackage.ModelData;
import ViewPackage.View;

public class ControllerPerpustakaan {

    private View frame;
    private PerpusDAOImpl implperpus;
    private List<ModelData> md;

    private boolean inputgagal = false;

    private boolean CekInput() {
        return !frame.getInjudul().getText().isEmpty()
                && !frame.getInpenulis().getText().isEmpty()
                && !frame.getInrating().getText().isEmpty()
                && !frame.getInharga().getText().isEmpty();
    }

    public ControllerPerpustakaan(View frame) {
        this.frame = frame;
        implperpus = new DAOPerpustakaan();
        md = implperpus.getALL();
    }

    public void showTabel() {
        md = implperpus.getALL();
        ModelData a = new ModelData (md);
        frame.getTabelData().setModel(a);
    }

    public void insert() {
        if (CekInput()) {
            try {
                ModelData md = new ModelData();
                md.setJudul(frame.getInjudul().getText());
                md.setPenulis(frame.getInpenulis().getText());
                md.setRating(Float.parseFloat(frame.getInrating().getText()));
                md.setHarga(Integer.parseInt(frame.getInharga().getText()));

                implperpus.insert(md);
                inputgagal = false;
                JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ulangi pengisian data", "Error", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
                inputgagal = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ulangi pengisian data", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void update() {
        if (CekInput()) {
            try {
                ModelData md = new ModelData();
                md.setJudul(frame.getInjudul().getText());
                md.setPenulis(frame.getInpenulis().getText());
                md.setRating(Float.parseFloat(frame.getInrating().getText()));
                md.setHarga(Integer.parseInt(frame.getInharga().getText()));

                implperpus.update(md);
                inputgagal = false;
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ulangi pengisian data", "Error", JOptionPane.WARNING_MESSAGE);
                ex.printStackTrace();
                inputgagal = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ulangi pengisian data", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void delete() {
        try {
            String id; 
            id = (frame.getInjudul());
            implperpus.deleteString(id);
            JOptionPane.showMessageDialog(null, "Data berhasil terhapus", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID tidak valid", "Error", JOptionPane.WARNING_MESSAGE);
            ex.printStackTrace();
        }
    }
}
