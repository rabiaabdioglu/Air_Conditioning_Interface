import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class Observerable {
    // Gözlemlenebilir olan sıcaklık

    Connection baglan = null;
    private List<Observer> yetkililer;

    //kritik sıcaklık haber verilecek olan yetkili kişiler
    public Observerable() {
        yetkililer = new ArrayList<>();}

    //yetkili kişiler veritabanından bulunup Arrayliste atılıyor
    public void yetkiliBul() {
        try {
            //yetkili olan kişiler bulunur .
            baglan = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akillicihaz", "postgres", "3578");
            if (baglan != null) {
                Statement stmt = baglan.createStatement();
                ResultSet resulset = stmt.executeQuery("SELECT *  FROM \"InternetKullanicisi\" WHERE yetki ='true'");
                baglan.close();

                while (resulset.next()) {
                    YetkiliEkle(new Kullanici(resulset.getInt("id"), resulset.getString("ad_soyad"), true));

                }
                resulset.close();
                stmt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Gözlemci ekle
    public void YetkiliEkle(Observer observer) {
        yetkililer.add(observer);
    }

    //Gözlemci çıkar
    public void YetkiliCikar(Observer observer) {
        yetkililer.remove(observer);
    }

    //Yetkili kişilere observer interface i ile mesaj iletiliyor
    public void haberVer() {
        for (Observer observer : yetkililer) {
            observer.update(this);
        }
    }


}
