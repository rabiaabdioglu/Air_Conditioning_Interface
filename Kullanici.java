
public class Kullanici implements Observer {
    private int hesap_no;
    private String adi_soyadi;
    private boolean yetki;

    public Kullanici(int hesap_no, String adi_soyadi, boolean yetki) {
        this.adi_soyadi = adi_soyadi;
        this.hesap_no = hesap_no;
        this.yetki = yetki;
    }


    public boolean getYetki() {
        return yetki;
    }


    public int getHesapNumarasi() {
        return hesap_no;
    }


    public String getAdi_soyadi() {
        return adi_soyadi;
    }


    @Override
    public String toString() {
        return "KullaniciHesabi{" + "Hesap No:" + getHesapNumarasi() + "Ad Soyad:" + getAdi_soyadi() + '}';
    }

    @Override
    public void update(Observerable observerable) {
        //observer dan gelen mesaj ekrana yazılıyor
        System.out.println(adi_soyadi + " -  sıcaklık kritik düzeylerde!!!\n");
    }

}
