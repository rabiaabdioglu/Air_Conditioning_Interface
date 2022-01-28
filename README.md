Proje Pdf : [AkilliCihazProje.pdf](https://github.com/rabiaabdioglu/AkilliCihaz/files/7259387/AkilliCihazProje.pdf)




1. Kullanıcı girişi ve doğrulaması: 
    > Kullanıcı girişi için Postgresql kullanıldı.  
    Veritabanı sınıfındaki ‘KullanıcıDogrula’ fonksiyonunu kullanmak için nesne oluşturulur. 
    Yapılan sorgu sonucunda veritabanında eşleşen veri bulunursa kullanıcı girişi başarıyla tamamlanır. Girişi yapılan kullanıcının akıllı cihazı kullanma yetkisi yoksa çıkış yapılır. Yetki varsa işlem secimi yapılır. 

   - AgArayuzu sınıfı 


     ![Resim1](https://user-images.githubusercontent.com/75799790/151572754-718ea4f5-c6bc-486f-bb15-ea75a446de77.jpg)


    > Veritabanı sınıfında kullanıcı doğrulaması yapılan fonksiyon: 
    > Connection sınıfından bağlan nesnesi oluşturulur. Veritabanından sorgu yapılır ve gelen sonuç kadar dönen (bu örnekte en çok 1 satır ) while döngüsünde kullanıcı hesabı oluşturulur ve fonksiyon sonunda kullanici hesabı geri döndürülür. 

   - Veritabanı sınıfı 


 ![Resim2](https://user-images.githubusercontent.com/75799790/151573163-2e97bf3b-b754-4876-838b-8b1a5da88dae.jpg)

   - Ekran görüntüsü 
 
  
 ![Resim3](https://user-images.githubusercontent.com/75799790/151573178-42b1b38f-f880-4bd9-aec9-9cbed543a4bb.jpg)

 
2. Sıcaklığın görüntülenmesi ve soğutucunun açılıp kapatılması 
 
    > Seçilen işlemler için Merkezi işlem biriminden  nesne oluşturulur.
    > 
    > ‘ICevreBirimleri’ interface yoluyla ‘SicaklikAlgilayici’ ve ‘Eyleyici’ sınıfında istenilen fonksiyonlar  ‘islemGerceklestir’ olarak tek yolda birleşmiş olur.
    > 
    > ‘durumBildir’ fonksiyonu ile interface içindeki islem durumları dizisinden uygun mesaj  ve geri bildirim süresi yazdırılır. 

  
 ![Resim4](https://user-images.githubusercontent.com/75799790/151573238-4556a15b-d0ad-4534-a18a-39b15a9d9527.jpg)
 

 
   - SicaklikAlgilayici sınıfı: 

  > ‘islemGerceklestir’ fonksiyonuna 20 saniye içinde geri bildirim yapması için rastgele (0-23) bir sayı alınır.
  > 
  >  Alınan sayı 20 den düşükse işlem gerçekleştirilmesi için ‘sicaklikOku’ fonksiyonu çağrılır.
  >  
  >  Sırasıyla ‘setsicaklikOlc’ ve ‘sicaklikYaz’ fonksiyonları çağrılır. -15 ve 25 arası bir sıcaklık o sınıftaki sicaklik değişkenine atanır. 

  
 ![Resim5](https://user-images.githubusercontent.com/75799790/151573275-e17d5db3-a6e3-4964-a0c8-192226296050.jpg)
 
![Resim6](https://user-images.githubusercontent.com/75799790/151573283-13f4fa1e-36e6-4104-b0ec-b5b86f57184e.jpg)


  
 
 
   - Eyleyici sınıfı: 
 
  > Soğutucu Aç/Kapa fonksiyonu için önce soğutucunun durumunu tutan ‘eyleyiciDurum’ değişkenine göre işlemler yapılır ve durumBildir metodu ile  mesaj ekrana yansıtılır.            
                 
  ![Resim7](https://user-images.githubusercontent.com/75799790/151573340-f9b824a2-0d33-45df-ac6b-d165aa0db65d.jpg)
                                            

 
3. Veritabanı görüntüsü 
 
    > InternetKullanicisi tablosunda ‘yetki’ akıllı cihaz üzerinde yapma yetkisidir. 
 
  
 ![Resim9](https://user-images.githubusercontent.com/75799790/151573432-891f2fcf-f566-44c0-91b8-9c5a55adc831.jpg)

 
 
4. Dependency Inversion 
 
 
    > Bir sınıfın diğer sınıflara karşı bağımlılığını azaltmaktır. Alt sınıfta yapılan bir değişiklik üst sınıfı etkilememelidir.
    > 
    > Yüksek seviye sınıflarda bir davranış değiştiğinde, alt seviye davranışların bu değişime uyum sağlaması gerekir.
    > 
    > Ancak, düşük seviye sınıflarda bir davranış değiştiğinde, üst seviye sınıfların davranışında bir bozulma meydana gelmemesi için iki tip sınıfı da  soyut kavramlar üzerinden (interface) yönetilmelidir.
    >   

    > Akıllı cihaz da bu prensip şu şekilde uygulanmıştır: 
    > MerkeziIslemBirimi>>> ICevreBirimleri(interface)>>> Eyleyici/SicaklikAlgilayici 

    > Eyleyici ve SicaklikAlgilayici sınıfındaki bir fonksiyona erişebilmek için interface sınıfı implement edilmeli.
    > 
    >  Daha sonra Yüksek seviye sınıf içinde düşük sınıf fonksiyonu kullanmak için interface üzerinden nesne yaratılır.  

   - MerkeziİslemBirimi sınıfı: 
 
  
 ![Resim10](https://user-images.githubusercontent.com/75799790/151573442-c8fe29c5-ca2b-4b5e-9cb8-96e8f2add6b8.jpg)

 
 	 
5. Builder ve Observer 
 
    > Builder:
    >  
    > Kullanılacak olan nesnenin çok fazla özelliği varsa ve bu özellikler farklı farklı kombinasyonlar ile kullanılması gerekiyorsa, birden çok (overload) constructor yazılması gerekebilir. Bu durum bazı sistemlerde kullanışsız ve karmaşık olabilir.
    >  Bu tarz durumlarda  builder tasarım deseni kullanılabilir. 

![Resim11](https://user-images.githubusercontent.com/75799790/151573521-de6cd3b8-e4ee-45c6-9b52-c514c1c42bb1.jpg)


  > Builder deseni Kullanici sınıfı üzerinde kullanılmıştır. 
  > 
  > Kullanici üzerindeki özellikleri KullaniciBuilder sınıfında tekrar yazılır.  
  > 
  > Kulllanici sınıfı ile getKullanici fonksiyonu yaratılır ve Kullanici nesnesi geri döndürülür. AgArayuzu sınıfında kullanici yazdırılır. 
  > 

 
  ![Resim12](https://user-images.githubusercontent.com/75799790/151573542-a4e5155c-3dcd-44cb-8666-640b7cc7b572.jpg)

 
   - Observer: 

  > Tasarlanmış olan sistem içerisinde, değişimini izlemek istediğimiz bir değer için kullanılır.
  > 
  >  İzlenen değer veya durumda  olan değişikliğe göre izleyenlere işlem yapılır. 

  > Akıllı cihaz sistemine başarılı bir kullanıcı girişi yapıldıktan sonra AnlikSicaklik sınıfındaki 
  > 
  > AnlikSicaklikOlc fonksiyonu çalışır. Bu fonksiyonda her dakika random olarak sıcaklık değiştirir. 
  > 
  > SicaklikKontrol ile istenilen aralığın dışında bir sıcaklık varsa yetkili olan kullanıcılara mesaj iletilir. 

![Resim13](https://user-images.githubusercontent.com/75799790/151573564-15baf4b0-2dc8-4172-826a-c9bc43f015e6.jpg)
    
  > Haber verilmesi gereken  yetkililer (gözlemciler) veritabanından bulunur ve Observer listesine atılır.  
  > 
  > Haber verilmesi gerektiğinde Observer listesindeki kişilere mesaj yollanır. Observable sınıfındaki haberVer metodu çağrılır. 

![Resim20](https://user-images.githubusercontent.com/75799790/151575068-128c2874-ac37-4cef-96a7-6b7f7e8b7b80.png)


 - İnterface: 

 ![Resim15](https://user-images.githubusercontent.com/75799790/151573624-4355579c-d891-439d-8441-b0f66a544eba.jpg)
 
> Ekran Görüntüsü :


  ![Resim16](https://user-images.githubusercontent.com/75799790/151573630-b1836291-13e3-4849-9aed-7ad43f0fd3aa.jpg)


   

  
 
 
 
