package repository;

import Database.Constants;
import model.Ders_Ogrenci;
import model.Ogrenci;

import java.sql.*;
import java.util.ArrayList;

public class Ders_OgrenciRepository
{
    public ArrayList<Ders_Ogrenci> getAll() throws SQLException
    {
        ArrayList<Ders_Ogrenci> list = new ArrayList<>();
        Connection con = Constants.getConnection();
        Statement stmnt = con.createStatement();
        ResultSet result = stmnt.executeQuery("select * from \"public\".\"DERS_OGRENCI\" order by \"ID\" asc");
        while (result.next())
        {
            long id = result.getLong("ID");
            long ders_id = result.getLong("DERS_ID");
            long ogr_id = result.getLong("OGR_ID");
            int devamsizlik = result.getInt("DEVAMSIZLIK");
            int note = result.getInt("NOTE");

            list.add(new Ders_Ogrenci(id, ders_id, ogr_id, devamsizlik,note));
        }
        result.close();
        stmnt.close();
        con.close();
        return list;
    }

    public Ders_Ogrenci getByID(long id) throws SQLException
    {
        Ders_Ogrenci ogr = null;
        Connection con = Constants.getConnection();
        String sql = "select * from \"public\".\"DERS_OGRENCI\" where \"ID\" = ?";
        PreparedStatement stmnt = con.prepareStatement(sql);
        stmnt.setLong(1, id);
        ResultSet result = stmnt.executeQuery();
        while (result.next())
        {
            ogr = new Ders_Ogrenci(result.getLong("ID"), result.getLong("DERS_ID"), result.getLong("OGR_ID"), result.getInt("DEVAMSIZLIK"),result.getInt("NOTE"));
        }
        result.close();
        stmnt.close();
        con.close();
        return ogr;
    }

    public boolean save(Ders_Ogrenci dogr) throws SQLException
    {
        boolean result = false;
        Connection con = Constants.getConnection();
        String sql = "INSERT INTO \"public\".\"DERS_OGRENCI\"(\"DERS_ID\", \"OGR_ID\",\"DEVAMSIZLIK\",\"NOTE\") VALUES (?, ?, ?,?)";
        PreparedStatement stmnt = con.prepareStatement(sql);
        stmnt.setLong(1, dogr.getDERS_ID());
        stmnt.setLong(2, dogr.getOGR_ID());
        stmnt.setInt(3, dogr.getDEVAMSIZLIK());
        stmnt.setInt(4, dogr.getNOTE());
        result = stmnt.executeUpdate() == 1;
        stmnt.close();
        con.close();
        return result;
    }

    public boolean deleteByID(long id) throws SQLException
    {
        Connection con = Constants.getConnection();
        String sql = "delete from \"public\".\"DERS_OGRENCI\" where \"ID\" = ?";
        PreparedStatement stmnt = con.prepareStatement(sql);
        stmnt.setLong(1, id);
        boolean result = stmnt.executeUpdate() == 1;
        stmnt.close();
        con.close();
        return result;
    }



}
