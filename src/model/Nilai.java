package model;


public class Nilai {
    String noNilai;
    String noDaftar;
    String namaSiswa;
    String nilai;
    String jurusan;

    public Nilai() {
    }

    public Nilai(String noNilai, String noDaftar, String namaSiswa, String nilai, String jurusan) {
        this.noNilai = noNilai;
        this.noDaftar = noDaftar;
        this.namaSiswa = namaSiswa;
        this.nilai = nilai;
        this.jurusan = jurusan;
    }

    public String getNoNilai() {
        return noNilai;
    }

    public void setNoNilai(String noNilai) {
        this.noNilai = noNilai;
    }

    public String getNoDaftar() {
        return noDaftar;
    }

    public void setNoDaftar(String noDaftar) {
        this.noDaftar = noDaftar;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

     
}
