package model;


public class Pembayaran {
    String noPembayaran;
    String noDaftar;
    String idOrtu;
    String bayar;
    String namaSiswa;

    public Pembayaran() {
    }

    public Pembayaran(String noPembayaran, String noDaftar, String idOrtu, String bayar, String namaSiswa) {
        this.noPembayaran = noPembayaran;
        this.noDaftar = noDaftar;
        this.idOrtu = idOrtu;
        this.bayar = bayar;
        this.namaSiswa = namaSiswa;
    }

    public String getNoPembayaran() {
        return noPembayaran;
    }

    public void setNoPembayaran(String noPembayaran) {
        this.noPembayaran = noPembayaran;
    }

    public String getNoDaftar() {
        return noDaftar;
    }

    public void setNoDaftar(String noDaftar) {
        this.noDaftar = noDaftar;
    }

    public String getIdOrtu() {
        return idOrtu;
    }

    public void setIdOrtu(String idOrtu) {
        this.idOrtu = idOrtu;
    }

    public String getBayar() {
        return bayar;
    }

    public void setBayar(String bayar) {
        this.bayar = bayar;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }
    
    
}