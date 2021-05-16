public class MerkeziIslemBirimi {

    private ICevreBirimleri  eyleyici = new Eyleyici();;
    private ICevreBirimleri  sicalikAlgilayici = new SicaklikAlgilayici();
    ///High level class


    public void islemGerceklestir(int islem_turu) {
    //    akilliCihaz.setAkilliCihazDurum(akilliCihazDurum.Islem_Yapiliyor);

        try {

            if (islem_turu == 2 || islem_turu == 3) eyleyici.islemGerceklestir(islem_turu);


             else sicalikAlgilayici.islemGerceklestir(islem_turu);

        } catch (Exception e) {

      //      akilliCihaz.setAkilliCihazDurum(akilliCihazDurum.Servis_Disi);

            System.out.println("İşlem gerçekleştirilemiyor.");
        }

    }


}
