package repository;

import Database.Constants;
import model.*;

import java.sql.*;
import java.util.ArrayList;

public class KonuRepository
{
    public ArrayList<Konu> getAll() throws SQLException
    {
        ArrayList<Konu> list = new ArrayList<>();
        Connection con = Constants.getConnection();
        Statement stmnt = con.createStatement();
        ResultSet result = stmnt.executeQuery("select * from \"public\".\"KONU\" order by \"ID\" asc");
        while (result.next())
        {
            long id = result.getLong("ID");
            String name = result.getString("NAME");
            list.add(new Konu(id, name));
        }
        result.close();
        stmnt.close();
        con.close();
        return list;
    }


    public Konu getByID(long id) throws SQLException
    {
        Konu konu = null;
        Connection con = Constants.getConnection();
        String sql = "select * from \"public\".\"KONU\" where \"ID\" = ?";
        PreparedStatement stmnt = con.prepareStatement(sql);
        stmnt.setLong(1, id);
        ResultSet result = stmnt.executeQuery();
        while (result.next())
        {
            konu = new Konu(result.getLong("ID"), result.getString("NAME"));
        }
        result.close();
        stmnt.close();
        con.close();
        return konu;
    }

    public boolean save(Ogrenci ogr) throws SQLException
    {
        boolean result = false;
        Connection con = Constants.getConnection();
        String sql = "INSERT INTO \"public\".\"KONU\"(\"NAME\") VALUES (?)";
        PreparedStatement stmnt = con.prepareStatement(sql);
        stmnt.setString(1, ogr.getNAME());
        result = stmnt.executeUpdate() == 1;
        stmnt.close();
        con.close();
        return result;
    }
    public boolean deleteByID(long id) throws SQLException
    {
        Connection con = Constants.getConnection();
        String sql = "delete from \"public\".\"KONU\" where \"ID\" = ?";
        PreparedStatement stmnt = con.prepareStatement(sql);
        stmnt.setLong(1, id);
        boolean result = stmnt.executeUpdate() == 1;
        stmnt.close();
        con.close();
        return result;
    }


}
