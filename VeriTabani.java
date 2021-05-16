import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class VeriTabani {


    Connection baglan = null;

    public Kullanici kullaniciDogrula(String kullanici_adi, int sifre) {

        Kullanici kullaniciHesabi = null;

        System.out.println("Akıllı cihaz veritabanı kullanıcıyı doğruluyor...");
        Araclar.bekle(3000);


        try {

            baglan = DriverManager.getConnection("jdbc:postgresql://localhost:5432/akillicihaz", "postgres", "3578");
            if (baglan != null) {
                System.out.println("Veritabanına bağlandı!\n");
                Araclar.bekle(3000);

                String sql = "SELECT *  FROM \"InternetKullanicisi\" WHERE kullanici_adi ='" + kullanici_adi + "' AND sifre='" + sifre + "'";

                Statement stmt = baglan.createStatement();
                ResultSet resulset = stmt.executeQuery(sql);

                //***** Bağlantı sonlandırma *****
                baglan.close();

                int hesap_no;
                String ad_soyad;
                boolean yetki;


                while (resulset.next()) {
                    ad_soyad = resulset.getString("ad_soyad");
                    hesap_no = resulset.getInt("id");
                    yetki = resulset.getBoolean("yetki");

                    kullaniciHesabi = new Kullanici(hesap_no, ad_soyad, yetki);
                }


                resulset.close();
                stmt.close();
            } else {
                System.out.println("Bağlantı başarısız!\n");
            }
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Bağlantı girişimi başarısız!\n");

        }

        return kullaniciHesabi;
    }


}
