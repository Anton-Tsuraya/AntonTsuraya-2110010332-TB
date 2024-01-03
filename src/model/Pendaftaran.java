package model;


public class Pendaftaran {
    String noDaftar;
    String nisn;
    String nik;
    String namaSiswa;
    String jengkel;
    String agama;
    String ttl;
    String alamat;
    String asalSekolah;

    public Pendaftaran() {
    }

    public Pendaftaran(String noDaftar, String nisn, String nik, String namaSiswa, String jengkel, String agama, String ttl, String alamat, String asalSekolah) {
        this.noDaftar = noDaftar;
        this.nisn = nisn;
        this.nik = nik;
        this.namaSiswa = namaSiswa;
        this.jengkel = jengkel;
        this.agama = agama;
        this.ttl = ttl;
        this.alamat = alamat;
        this.asalSekolah = asalSekolah;
    }

    public String getNoDaftar() {
        return noDaftar;
    }

    public void setNoDaftar(String noDaftar) {
        this.noDaftar = noDaftar;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getJengkel() {
        return jengkel;
    }

    public void setJengkel(String jengkel) {
        this.jengkel = jengkel;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAsalSekolah() {
        return asalSekolah;
    }

    public void setAsalSekolah(String asalSekolah) {
        this.asalSekolah = asalSekolah;
    }

    
}
