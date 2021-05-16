import java.util.Random;

public class SicaklikAlgilayici implements ICevreBirimleri {
//Low level class

    double sicaklik;
    Random random = new Random();
    // AkilliCihaz akilliCihaz=new AkilliCihaz();


    public SicaklikAlgilayici() {

    }


    public void sicaklikOku() {
        setsicaklikOlc();
        sicaklikYaz();
    }

    public void setsicaklikOlc() {
        //-15 ve 25 arası rastgele derece
        //    akilliCihaz.setAkilliCihazDurum(akilliCihazDurum.Algilaniyor);

        this.sicaklik = random.nextInt(40) - 15;

    }

    public void setsicaklikOlc(int sicaklik) {
        this.sicaklik = sicaklik;
    }

    public void sicaklikYaz() {
        durumBildir("\nSıcaklık " + this.sicaklik + " derece ");
    }

    public double getsicaklikGonder() {
        return sicaklik;
    }

    @Override
    public void islemGerceklestir(int islem_turu) {
        //   akilliCihaz.setAkilliCihazDurum(akilliCihazDurum.Islem_Yapiliyor);


        int sure = random.nextInt(23);

        if (sure < 20) {
            if (islem_turu == 1) sicaklikOku();
            durumBildir(islemDurumu[2], sure);

        } else durumBildir(islemDurumu[1]);

    }


    @Override
    public void durumBildir(String islem_durumu, int geriDonmeSuresi) {
        System.out.println("\n" + islem_durumu + "        -   " + geriDonmeSuresi + "  sn \n");

    }

    public void durumBildir(String islem_durumu) {
        System.out.println(islem_durumu + "\n");

    }

}
