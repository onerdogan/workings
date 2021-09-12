package kumOcagı;

import java.time.LocalDate;
import java.util.*;

public class Kamyon {
    static String arac;
    static LocalDate bugun = LocalDate.now();
   static String cikis;
    static List<String> plakaListesi=new ArrayList<String>();
   static List<Integer>darabaListesi=new ArrayList<Integer>();
    static List<Integer>netAgirlikListesi=new ArrayList<Integer>();
    static List<Integer>ucretListesi=new ArrayList<Integer>();
    static int toplamkum;
    static int toplamucret;

    static String plaka;
    public static void main(String[] args) {
        System.out.println("KUM OCAGI ARAC(PLAKA) GIRISI, DARABA GIRISI, TARTILAN AGIRLIK GIRISI\n" +
                "NET AGIRLIK VE UCRETI HESAPLAMASI,\nTOP KUM MIKTARI VE TOPLAM KAZANC HESAPLAMASI PROJESI ");
        System.out.println("=================================================================");

        HashMap<List<String>,List<Integer>> arac = new HashMap<>();

        aracgirisi();

        arac.put(plakaListesi,darabaListesi);
        System.out.println(arac);

        toplamAgirlik();//+ucret
        icmal();
    }

    private static void icmal() {

        for(int each : netAgirlikListesi) {
        toplamkum+=each;
        }System.out.println(bugun+" tarihinde ocaktan cikan toplam kum miktari :"+toplamkum+" TON");


        for(int each:ucretListesi) {
            toplamucret += each;
            }    System.out.println(bugun+" tarihinde ki toplam kazanc :"+toplamucret+" TL");


    }

    private static void toplamAgirlik() {
        String sorgu;
        do {
            Scanner scan = new Scanner(System.in);
        System.out.println("KANTARDA TARTILAN AGIRLIGI GIRINIZ :");
        int toplamagirlik = scan.nextInt();
        scan.nextLine();

           System.out.println(" LISTEDEN PLAKA SECINIZ "+plakaListesi);
            String secilenplaka=scan.nextLine();
            for(int i=0;i<plakaListesi.size();i++) {
                if(secilenplaka.equals(plakaListesi.get(i))) {
                    int netAgirlik=toplamagirlik-darabaListesi.get(i);
                    netAgirlikListesi.add(netAgirlik);
                    System.out.println("NET AGIRLIK="+netAgirlik+" TON");
                    int ucret=(toplamagirlik-darabaListesi.get(i))*100;
                    ucretListesi.add(ucret);
                    System.out.println("KUM TOPLAM UCRETI="+ucret+" TL");
                    System.out.println("PLAKA NO\tDARABA\tTOPLAM AGIRLIK\tUCRET\n"+plakaListesi.get(i)+"\t\t"+darabaListesi.get(i)+"\t\t\t"+toplamagirlik+"\t\t\t"+ucret);
                }

            }
            plakaListesi.remove(secilenplaka);
            scan.nextLine();
            if(plakaListesi.isEmpty()){
                System.out.println("!SIRADA BEKLEYEN ARAC KALMADI! ICMAL YAPIN");
            }
            System.out.println("================================\nYENI TARTMA VE ARACIN CIKIS ISLEMI(E) \t ICMAL ICIN (H)");
            cikis=scan.nextLine();
        }while (cikis.equalsIgnoreCase("e"));
    }

    private static void aracgirisi() {
        do{
            Scanner scan = new Scanner(System.in);
            System.out.println("YENI ARAC PLAKASI GIRINIZ :");
            String plaka = scan.nextLine();
            scan.nextLine();
            System.out.println("DARABA GIRINIZ :");
            int daraba = scan.nextInt();

            plakaListesi.add(plaka);
            darabaListesi.add(daraba);

            System.out.println(plakaListesi);
            System.out.println(darabaListesi);


            System.out.println("YENI ARAC GIRISI(E) ARACIN CIKIS ISLEMI(ENTER)");//hatali giriste tekrar giris yapma imkani veren blok
            scan.nextLine();
            cikis=scan.nextLine();

        }while(cikis.equalsIgnoreCase("E"));
    }
}




