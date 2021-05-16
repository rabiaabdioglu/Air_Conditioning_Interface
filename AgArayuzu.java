import java.util.Scanner;
import java.sql.SQLException;

public class AgArayuzu {
    Scanner scanner = new Scanner(System.in);
  //  AkilliCihaz akilliCihaz=new AkilliCihaz();

    MerkeziIslemBirimi islemGerceklestir = new MerkeziIslemBirimi();


    private IAkilliCihaz ekran;

    public AgArayuzu() {
        ekran = new AkilliCihaz();
    }

    public void basla() {


        ekran.durumMesajYolla("Lütfen Giriş Yapınız.....\n\n\n");

        int sifre = 0;
        String kullanici_adi = null;
        Araclar.bekle(300);
        //   akilliCihaz.setAkilliCihazDurum(akilliCihazDurum.Bekleme);

        ekran.durumMesajYolla("Kullanici Adi  :  ");
        kullanici_adi = scanner.next();
        ekran.durumMesajYolla("Şifre   :   ");
        sifre = scanner.nextInt();

        VeriTabani veriTabani = new VeriTabani();

        Kullanici kullaniciVerileri = null;

        kullaniciVerileri = veriTabani.kullaniciDogrula(kullanici_adi, sifre);

        if (kullaniciVerileri != null) {
            ekran.durumMesajYolla("\nKullanıcı doğrulama işlemi başarılı...:");
            ekran.durumMesajYolla("\nHoşgeldiniz    " + kullaniciVerileri.getAdi_soyadi());
            if (kullaniciVerileri.getYetki()) islemSecimi();
            else ekran.durumMesajYolla("İşlem yapmaya yetkiniz yok..");
        } else ekran.durumMesajYolla("Kullanici bilgileri hatali...\n");

    }

    private void islemSecimi() {

        AnlikSicaklik anlikSicaklik = new AnlikSicaklik();
        //Program başladığı anda başlaması gereken bazı fonksiyonlar
        anlikSicaklik.AnlikSicaklikOlc();
        anlikSicaklik.yetkiliBul();

        int secim;
        do {
            Araclar.temizle();

            secim = anaMenuyuGoster();

            switch (secim) {

                case 1, 2, 3:
                    islemGerceklestir.islemGerceklestir(secim);
                    break;

                case 4:
                    //builder kullanımı örneği amaçlı
                    Kullanici kullanici=new KullaniciBuilder().getKullanici();

                    ekran.durumMesajYolla("İyi günler  "+kullanici+"\n\nÇıkılıyor");

                    System.exit(0);
                    break;

                default:
                    ekran.durumMesajYolla("Yanlış seçim yaptınız..\nTekrar deneyiniz...\n\n");
                    break;
            }
            Araclar.bekle(1000);


        } while (secim != 4);
    }

    private int anaMenuyuGoster() {
                ekran.durumMesajYolla("\n\n\n**********************************************");
                ekran.durumMesajYolla("Ana Menu");
                ekran.durumMesajYolla("1-Sıcaklığı Ölç");
                ekran.durumMesajYolla("2-Soğutucuyu Aç");
                ekran.durumMesajYolla("3-Soğutucuyu Kapa");
                ekran.durumMesajYolla("4-Cikis");
                ekran.durumMesajYolla("Seciminiz:");
                ekran.durumMesajYolla("**********************************************\n\n");
                int anaMenuSecimi = scanner.nextInt();
                return anaMenuSecimi;


    }
}

