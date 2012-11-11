import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class BankaKuyrugu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		 int secim;
		 
		 Scanner in=new Scanner(System.in);
		 
		 
		 do{
			 secim=menu();
			 switch (secim){
			 	case 1:
			 	{
			 		
					System.out.println("Kuyruða eklenecek eleman sayýsýný giriniz:");
					int n=in.nextInt();
					System.out.println("\n\n");
			 		Kuyruk Banka=new Kuyruk(n);
			 		Banka.ekleme();
					Banka.yazdir();
					System.out.println();
					System.out.println();
					Banka.sirala();
					Banka.yazdir2();
					break;
			 	}
			 	case 2:
			 	{
			 	    gise_olusturma();
			 		break;
			 	}
			 }
		 }while(secim!=3);
		 
		 		 

	}
	
	public static int menu()
	{
		int secim;
		
		System.out.println("1) FIFO kuyruðu ve öncelik kuyruðu oluþturma");
		System.out.println("2) 3 adet FIFO ve öncelik kuyruðu oluþturup zaman kýyaslama");
		System.out.println("3) Çýkýþ");
		System.out.println();
		System.out.println("Seçiminizi giriniz:");
		Scanner in = new Scanner(System.in);
		secim=in.nextInt();
		
		return secim;
	}
	
	public static void gise_olusturma(){
		Scanner in=new Scanner(System.in);
		System.out.println("Kuyruða eklenecek eleman sayýsýný giriniz:");
		int n=in.nextInt();
		int x=0;
		
		//Random rand= new Random();
		Kuyruk kuyruk1=new Kuyruk(n,x);
 		Kuyruk kuyruk2=new Kuyruk(n,x);
 		Kuyruk kuyruk3=new Kuyruk(n,x);
 		
 		//ArrayList<Musteri> temp1=kuyruk1.banka_kuyruk;
 		//ArrayList<Musteri> temp2=kuyruk2.banka_kuyruk;
 		//ArrayList<Musteri> temp3=kuyruk3.banka_kuyruk;
 		for(int i=0;i<n;i++){
 		
 			if(kuyruk1.banka_kuyruk.size()<kuyruk2.banka_kuyruk.size() && kuyruk1.banka_kuyruk.size()<kuyruk3.banka_kuyruk.size())
 				kuyruk1.tekli_ekle(i+1);
 			else{
 				if(kuyruk2.banka_kuyruk.size()<kuyruk3.banka_kuyruk.size())
 					kuyruk2.tekli_ekle(i+1);
 				else{
 					kuyruk3.tekli_ekle(i+1);
 				     }
 			     }
 			
 		    
 		}
 		System.out.println("1. GÝÞE");
 		kuyruk1.yazdir();
 		System.out.println("\n\n");
 		System.out.println("2. GÝÞE");
 		kuyruk2.yazdir();
 		System.out.println("\n\n");
 		System.out.println("3. GÝÞE");
 		kuyruk3.yazdir();
 		System.out.println("\n\n");
	}
	

}
