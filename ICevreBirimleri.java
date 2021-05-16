public interface ICevreBirimleri {


    public String[] islemDurumu = {"İnternet bağlantisi yok.", "İstek zaman aşımına uğradı.", "İşlem tamamlandı.."};

    public void islemGerceklestir(int islem_turu);

    public void durumBildir(String islem_durumu, int geriDonmeSuresi);

    public void durumBildir(String islem_durumu);


}
