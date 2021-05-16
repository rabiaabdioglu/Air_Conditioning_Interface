 class KullaniciBuilder {

     private int hesap_no;
     private String adi_soyadi;
     private boolean yetki;

     public KullaniciBuilder setHesap_no(int hesap_no) {
         this.hesap_no = hesap_no;
         return this;
     }

     public KullaniciBuilder setAdi_soyadi(String adi_soyadi) {
         this.adi_soyadi = adi_soyadi;
         return this;

     }

     public KullaniciBuilder setYetki(boolean yetki) {
         this.yetki = yetki;
         return this;
     }
     public Kullanici getKullanici(){
         return new Kullanici(hesap_no,adi_soyadi,yetki);
     }
 }
