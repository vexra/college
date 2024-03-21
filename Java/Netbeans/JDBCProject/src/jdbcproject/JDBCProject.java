/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jdbcproject;

import db.DBHelper;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class JDBCProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // DBHelper.getConnection();
        
        MahasiswaModel mhs = new MahasiswaModel();
        
        mhs.deleteMahasiswa("7777777");
        
        
    }

}
