package Tirta_Maju_Abadi.DataModel;

import Tirta_Maju_Abadi.toll.database;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public class listMD_Pegawai {
    
    private database db;
    private ResultSet rs;
    private List<MD_Pegawai> listDB=new ArrayList<MD_Pegawai>();
    public listMD_Pegawai(database db){
        this.db=db;
        try {
            listDB.clear();
            rs=db.getRs("select * from pegawai tanggal_masuk ASC");
            while(rs.next()){
                listDB.add(
                        new MD_Pegawai(
                            rs.getInt("no_pegawai"),
                            rs.getInt("jabatan"),
                            rs.getDate("tanggal_lahir"), 
                            rs.getDate("tanggal_masuk"), 
                            rs.getString("nama"), 
                            rs.getString("alamat"), 
                            rs.getString("no_telepon"), 
                            rs.getString("username"), 
                            rs.getString("password"),rs.getString("email")
                        ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public listMD_Pegawai(ResultSet rs,database db){
        this.db=db;
        try {
            while(rs.next()){
                listDB.add(
                        new MD_Pegawai(
                            rs.getInt("no_pegawai"),
                            rs.getInt("jabatan"),
                            rs.getDate("tanggal_lahir"), 
                            rs.getDate("tanggal_masuk"), 
                            rs.getString("nama"), 
                            rs.getString("alamat"), 
                            rs.getString("no_telepon"), 
                            rs.getString("username"), 
                            rs.getString("password"),rs.getString("email")
                        ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public MD_Pegawai getMDByID(int id_pegawai){
        MD_Pegawai pilih=new MD_Pegawai();
        for(MD_Pegawai mdpr : listDB){
            if(mdpr.getNo_pegawai()==id_pegawai){
                pilih=mdpr;
                break;
            }
        }
        return pilih;
    }
    
    public List<MD_Pegawai> getList(){
        return listDB;
    }
    
    
}
