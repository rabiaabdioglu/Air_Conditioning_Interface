import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class AnlikSicaklik extends Observerable {
    //SUBJECT


    // program başladığından itibaren her 1 dakikada bir sıcaklığı ölçecek
    SicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici();
    Timer timer = new Timer();
    Random random = new Random();

    int enYuksekSicaklik = 35;
    int enDusukSicaklik = -15;


    public void AnlikSicaklikOlc() {


        TimerTask olc = new TimerTask() {
            @Override
            public void run() {
                //daha yüksek veya düşük sıcaklık ölçülebilmesi için sicaklik aralığını genişlettim
                sicaklikAlgilayici.setsicaklikOlc(random.nextInt(60) - 25);
                SicaklikKontrol(); } };
        timer.scheduleAtFixedRate(olc, 10, 10000);
    }
    public void SicaklikKontrol() {

        double sicaklik = sicaklikAlgilayici.getsicaklikGonder();
        if (sicaklik < enDusukSicaklik || sicaklik > enYuksekSicaklik) {
            //Sıcaklık kritik düzeylerdeyse
            System.out.println("Sıcaklık  " + sicaklik + "  derece !!!");
            haberVer();
        }


    }


}
