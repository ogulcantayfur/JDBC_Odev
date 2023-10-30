package model;

public class Ders_Ogrenci
{
    private long ID;
    private long DERS_ID;
    private long OGR_ID;
    private int DEVAMSIZLIK;
    private int NOTE;

    @Override
    public String toString()
    {
        return "Ders_Ogrenci{" +
                "ID=" + ID +
                ", DERS_ID=" + DERS_ID +
                ", OGR_ID=" + OGR_ID +
                ", DEVAMSIZLIK=" + DEVAMSIZLIK +
                ", NOTE=" + NOTE +
                '}';
    }

    public Ders_Ogrenci(long DERS_ID, long OGR_ID, int DEVAMSIZLIK, int NOTE)
    {
        this.DERS_ID = DERS_ID;
        this.OGR_ID = OGR_ID;
        this.DEVAMSIZLIK = DEVAMSIZLIK;
        this.NOTE = NOTE;
    }

    public Ders_Ogrenci(long ID, long DERS_ID, long OGR_ID, int DEVAMSIZLIK, int NOTE)
    {
        this.ID = ID;
        this.DERS_ID = DERS_ID;
        this.OGR_ID = OGR_ID;
        this.DEVAMSIZLIK = DEVAMSIZLIK;
        this.NOTE = NOTE;
    }


    public long getID()
    {
        return ID;
    }

    public void setID(long ID)
    {
        this.ID = ID;
    }

    public long getDERS_ID()
    {
        return DERS_ID;
    }

    public void setDERS_ID(long DERS_ID)
    {
        this.DERS_ID = DERS_ID;
    }

    public long getOGR_ID()
    {
        return OGR_ID;
    }

    public void setOGR_ID(long OGR_ID)
    {
        this.OGR_ID = OGR_ID;
    }

    public int getDEVAMSIZLIK()
    {
        return DEVAMSIZLIK;
    }

    public void setDEVAMSIZLIK(int DEVAMSIZLIK)
    {
        this.DEVAMSIZLIK = DEVAMSIZLIK;
    }

    public int getNOTE()
    {
        return NOTE;
    }

    public void setNOTE(int NOTE)
    {
        this.NOTE = NOTE;
    }


}
