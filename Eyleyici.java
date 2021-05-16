import java.util.Random;

public class Eyleyici implements ICevreBirimleri {
//Low level class

    Random random = new Random();
    CihazDurum eyleyiciDurum;

    public void sogutucuAc() {
        if (eyleyiciDurum==CihazDurum.Acik) durumBildir("Soğutucu zaten açık...");
        else {
            eyleyiciDurum=CihazDurum.Acik;
            durumBildir("Soğutucu açıldı\n");
        } }

    public void sogutucuKapa() {
        if (eyleyiciDurum!=CihazDurum.Kapali) {
            eyleyiciDurum=CihazDurum.Kapali;
            durumBildir("Soğutucu kapatıldı\n");
        }
        else   durumBildir("Soğutucu zaten kapalı...");   }


    @Override
    public void islemGerceklestir(int islem_turu) {


        int sure = random.nextInt(30);

        if (sure < 20) {
            if (islem_turu == 2) sogutucuAc();
            else if (islem_turu == 3) sogutucuKapa();

            durumBildir(islemDurumu[2], sure);

        } else durumBildir(islemDurumu[1]);

    }

    @Override
    public void durumBildir(String islem_durumu, int geriDonmeSuresi) {
        System.out.println(islem_durumu + "        -   " + geriDonmeSuresi + "  sn \n");

    }

    public void durumBildir(String islem_durumu) {
        System.out.println(islem_durumu + "\n");

    }


}
