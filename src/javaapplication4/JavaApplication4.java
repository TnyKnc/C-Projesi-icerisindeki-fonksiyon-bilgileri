/**
 *
 * @author Berkin Yılmaz berkin.yilmaz1@ogr.sakarya.edu.tr
 * @since 03.03.2019
 * <p>
 * Bu projede c kodu içerisinde yer alan; toplam operatör sayısı, toplam
 * fonksiyon sayısı ve toplam parametre sayısı bulunmaktadır.
 * </p>
 */
package javaapplication4;

import java.io.*; //.io kütüphanesini ekledik.

public class JavaApplication4 {

    public static void main(String[] args) {
        char[] TanimliOperator = new char[10]; //tanımlı operatör adlı dizi oluşturup istenilen operatörleri ekledim.
        TanimliOperator[0] = '+';
        TanimliOperator[1] = '-';
        TanimliOperator[2] = '/';
        TanimliOperator[3] = '*';
        TanimliOperator[4] = '&';
        TanimliOperator[5] = '=';
        TanimliOperator[6] = '<';
        TanimliOperator[7] = '>';
        TanimliOperator[8] = '!';
        TanimliOperator[9] = '|';

        char[] Satirlar = new char[99];
        int satir = 1;
        
        int ToplamSatirSayisi=0;
                        int kalanyer=0, k2=0, bosluk=0, isaret=0;
                        char[] diziKalanYer = new char[499];
        int sayac = 0, sayac2 = 0, sayac3 = 0; //toplam, operatör, fonksiyon ve parametre sayısını içerinide tutacak sayaç değişkenlerini tanımladım.

        File file = new File("src\\javaapplication4\\Program.c"); //.c uzantılı dosyanın okunmasını için klasör yolunu belirttim.

        String fileName = file.getAbsolutePath();    //doğru dosya yolunu almak için

        String line = null;
        try {                                      //hata denetimini sağlamak için kodumu try-catch bloğuna aldım.
            FileReader fileReader = new FileReader(fileName); //dosya okuma işlemlerini başlattım.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.print("Fonksiyon Adları: ");
            while ((line = bufferedReader.readLine()) != null) {  //dosyadan satır satır okumaya başladım.
                String temp = line.trim();                      //boşlukları temizledim.
                
                ToplamSatirSayisi++;
                for (int i = 0; i <= temp.length() - 1; i++) { //dosyayı sıfırıncı satırdan dosyanın sonuna kadar okutma döngüsünü kurdum.
                    for (int j = 0; j < 10; j++) { //operatörlerin dosya elemanına eşitliğini kontrol etmek için ilgili döngüyü kurdum.
                        if (TanimliOperator[j] == temp.charAt(i)) //operatörlerin dosya elemanına eşitliğini kontrol etmek için ilgili if yapısını kurdum.
                        {
                            sayac++; //if sorgusunun sağlandığı durumda sayacı 1 arttırdım.
                        }
                    }

                    if (temp.charAt(i) == '{') { //dosya içerisinde '{' işaretini görene okumayı sağladım.
                        sayac2++; //fonksiyon durumu sağlandığında 2. sayacı 1 arttırdım.
                        satir=i;
                        for (int k = i; k <= i; k--) { //'{' işaretini gördükten sonra geriye doğru tarama yaptırdım.
                            Satirlar[k]=temp.charAt(k);

                            //System.out.print(satir);
                            if ((temp.charAt(k) >= 65 && temp.charAt(k) <= 90) || (temp.charAt(k) >= 97 && temp.charAt(k) <= 122) || temp.charAt(k) == 44 || temp.charAt(k) == 123 || temp.charAt(k) == 41) {
                                //büyük küçük harfleri, ',', '{', ')' işaretlerini sağladığı sürece ilgili kod yapısına girdim.
                                if (temp.charAt(k) == '{') { //'{' işaretini görene kadar taradım.
                                    if (temp.charAt(k - 1) == ')') { //')' işaretini görene kadar taradım.
                                        if ((temp.charAt(k - 2) >= 65 && temp.charAt(k - 2) <= 90) || (temp.charAt(k - 2) >= 97 && temp.charAt(k - 2) <= 122) || temp.charAt(k) == 44) {
                                            //harf kontrolünü sağladım.
                                            sayac3++; //şartlar sağlandığı sürece sayacı 1 arttırarak parametre sayısını kayıt altında tuttum.

                                        }
                                    }
                                }
                            }
                            if (temp.charAt(k) == 44) {
                                sayac3++; //virgül olduğu zaman başka parametre bulunacağından dolayı sayacı 1 arttırdım.
                            }
                            if (k == 0) {
                                break; //satır başına geldiğinde break; komutunu kullanarak döngüyü sonlandırdım..
                            }
                        }
                            System.out.print(" -");
                        for (int j = 0; j <= i; j++) {
                            //System.out.print(satir);
                            //System.out.print(Satirlar[j]);
                            if (temp.charAt(j) == 40) {
                                isaret=j;
                                //System.out.println("Fonksiyon Adı:"+Satirlar[j]);
                            }
                            if (temp.charAt(j) == 32) {
                                bosluk=j;
                            }
                            for (int abc=bosluk; abc < isaret; abc++) {
                            diziKalanYer[kalanyer]=temp.charAt(abc);
                            System.out.print(diziKalanYer[kalanyer]);
                            kalanyer++;
                            //System.out.println(abc);
                        }

                            isaret=0;
                        }
                        //System.out.println(isaret);
                        //System.out.println(bosluk);
                        //System.out.print("Fonksiyon Adı: ");

                    }
                }
            }
            bufferedReader.close();                        //Dosyayı kapattım.
            
            //ekran çıktılarını yazdım.
            System.out.println("");
            System.out.println("Toplam Satır Sayısı: " + ToplamSatirSayisi);
            System.out.println("Toplam Operatör Sayısı: " + sayac);
            System.out.println("Toplam Fonksiyon Sayısı: " + sayac2);
            System.out.println("Toplam Parametre Sayısı: " + sayac3);

        } //dosya açılma hatalarına karşın catch bloğunu yazdım.
        catch (FileNotFoundException ex) {
            System.out.println(
                    "Dosya acılamadı '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Dosyayı Okuma hatası '"
                    + fileName + "'");
        }
    }
}
