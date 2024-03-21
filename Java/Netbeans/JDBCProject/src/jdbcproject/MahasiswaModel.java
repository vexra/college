/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbcproject;

import db.DBHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class MahasiswaModel {
    private final Connection CONN;

    public MahasiswaModel() {
        this.CONN = DBHelper.getConnection();
    }
    
    public void addMahasiswa(Mahasiswa mhs) {
        String insert = "INSERT INTO `mhs` VALUES ('" + mhs.getNpm() + "','" + mhs.getNama() + "')";
        System.out.println(insert);
        
        try {
            if (CONN.createStatement().executeUpdate(insert) > 0) {
                System.out.println("Berhasil memasukkan data");
            } else {
                System.out.println("Gagal memasukkan data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal memasukkan data");
        }
    }
    
    public ArrayList<Mahasiswa> getMahasiswa() {
        String query = "SELECT * FROM `mhs`";
        ArrayList<Mahasiswa> mhs = new ArrayList();
        
        try {
            ResultSet rs = CONN.createStatement().executeQuery(query);
           
            while(rs.next()) {
                Mahasiswa temp = new Mahasiswa(rs.getString("npm"), rs.getString("nama"));
                mhs.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return mhs;
    }
    
    public void updateMahasiswa(String npm, Mahasiswa mhs) {
        String update = "UPDATE `mhs` SET `npm`='" + mhs.getNpm() + "',`nama`='" + mhs.getNama() + "' WHERE npm='" + npm + "'";
        System.out.println(update);
        
        try {
            if (CONN.createStatement().executeUpdate(update) > 0) {
                System.out.println("Berhasil mengubah data");
            } else {
                System.out.println("Gagal mengubah data");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal mengubah data");
        }
    }
    
    public void deleteMahasiswa(String npm) {
        String delete = "DELETE FROM `mhs` WHERE npm='" + npm + "'";
        System.out.println(delete);
        
        try {
            if (CONN.createStatement().executeUpdate(delete) > 0) {
                System.out.println("Berhasil menghapus mahasiswa");
            } else {
                System.out.println("Gagal menghapus mahasiswa");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MahasiswaModel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Gagal menghapus mahasiswa");
        }
    }
}
