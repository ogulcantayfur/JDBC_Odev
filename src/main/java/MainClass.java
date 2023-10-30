import model.*;
import repository.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainClass
{
    public static void main(String[] args) throws SQLException
    {
        Ders_OgrenciRepository repo = new Ders_OgrenciRepository();
//        ArrayList<Ders_Ogrenci> arrayList;
//        arrayList=repo.getAll();
        Ders_Ogrenci do1 =repo.getByID(1);
        System.out.println(do1);
    }



}
