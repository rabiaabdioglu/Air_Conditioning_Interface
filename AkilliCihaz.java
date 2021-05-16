public class AkilliCihaz implements IAkilliCihaz {
    // Low level class
    CihazDurum akilliCihazDurum;
    private String surum = "V.3.2";

    public AkilliCihaz() {

    }


    // AgArayuzu classında kullanıldı

    public void durumMesajYolla(String mesaj) {
        System.out.println(mesaj + "\n");
    }



    public void setAkilliCihazDurum(CihazDurum akilliCihazDurum) {
        this.akilliCihazDurum = akilliCihazDurum;
    }



}


