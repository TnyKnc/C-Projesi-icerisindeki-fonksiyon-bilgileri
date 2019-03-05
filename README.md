# C-Projesi-icerisindeki-fonksiyon-bilgileri
C Projesi içerisinde bulunan bazı parametreleri veren proje

Örnek Program.c kaynak dosya içeriği

- #include "stdio.h"
- #include "stdlib.h"
- void DiziYazdir(int *p,int uzunluk){
- int i=0;
- for(;i<uzunluk;i++) printf("%d ",p[i]);
- }
- int DiziTopla(int *p,int uzunluk){
- int i=0;
- int toplam=0;
- for(;i<uzunluk;i++) toplam += p[i];
- return toplam;
- }
- int main(){
- int x,y;
- printf("x:");
- scanf("%d",&x);
- printf("y:");
- scanf("%d",&y);
- int sonuc = x+y;
- printf("Sonuc:%d\n\n",sonuc);
- int *dizi = malloc(3*sizeof(int));
- dizi[0]=x;
- dizi[1]=y;
- dizi[2]=sonuc;
- DiziYazdir(dizi,3);
- printf("\n\nToplam Deger:%d",DiziTopla(dizi,3));
- free(dizi);
- return 0;
- }

Ekran çıktısı altta belirtilen formatta olmaktadır. Önce toplam operatör ve toplam fonksiyon sayısı
yazdırılmaktadır. Sayılacak operatörler +, -, /, *, &, ++, --, +=, -=, /=, *=, =, ==, <, >, <=, >=, !=. &&, ||
bunun yanında += gibi bileşik operatörler 2 olarak sayılmaktadır. 

Ekran Çıktısı:
- Fonksiyon adı: DiziYazdir - DiziTopla - Main
- Toplam Operatör Sayısı: 21
- Toplam Fonksiyon Sayısı: 3
- Toplam Parametre Sayısı: 4
