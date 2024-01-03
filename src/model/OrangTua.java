package model;


public class OrangTua {
    int idOrtu;
    String namaSiswa;
    String namaAyah;
    String pekerjaanAyah;
    String penghasilanAyah;
    String namaIbu;
    String pekerjaanIbu;
    String penghasilanIbu;

    public OrangTua() {
    }

    public OrangTua(int idOrtu, String namaSiswa, String namaAyah, String pekerjaanAyah, String penghasilanAyah, String namaIbu, String pekerjaanIbu, String penghasilanIbu) {
        this.idOrtu = idOrtu;
        this.namaSiswa = namaSiswa;
        this.namaAyah = namaAyah;
        this.pekerjaanAyah = pekerjaanAyah;
        this.penghasilanAyah = penghasilanAyah;
        this.namaIbu = namaIbu;
        this.pekerjaanIbu = pekerjaanIbu;
        this.penghasilanIbu = penghasilanIbu;
    }

    public int getIdOrtu() {
        return idOrtu;
    }

    public void setIdOrtu(int idOrtu) {
        this.idOrtu = idOrtu;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getNamaAyah() {
        return namaAyah;
    }

    public void setNamaAyah(String namaAyah) {
        this.namaAyah = namaAyah;
    }

    public String getPekerjaanAyah() {
        return pekerjaanAyah;
    }

    public void setPekerjaanAyah(String pekerjaanAyah) {
        this.pekerjaanAyah = pekerjaanAyah;
    }

    public String getPenghasilanAyah() {
        return penghasilanAyah;
    }

    public void setPenghasilanAyah(String penghasilanAyah) {
        this.penghasilanAyah = penghasilanAyah;
    }

    public String getNamaIbu() {
        return namaIbu;
    }

    public void setNamaIbu(String namaIbu) {
        this.namaIbu = namaIbu;
    }

    public String getPekerjaanIbu() {
        return pekerjaanIbu;
    }

    public void setPekerjaanIbu(String pekerjaanIbu) {
        this.pekerjaanIbu = pekerjaanIbu;
    }

    public String getPenghasilanIbu() {
        return penghasilanIbu;
    }

    public void setPenghasilanIbu(String penghasilanIbu) {
        this.penghasilanIbu = penghasilanIbu;
    }

       
}
