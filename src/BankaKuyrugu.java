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
		 System.out.println("Kuyru�a eklenecek eleman say�s�n� giriniz:");
		 int n=in.nextInt();
		 System.out.println("\n\n");
	 	 Kuyruk Banka=new Kuyruk(n);
	 	 Banka.ekleme();
	 	 ArrayList<Musteri> gise=(ArrayList<Musteri>)Banka.banka_kuyruk.clone();
		 
		 do{
			 secim=menu();
			 switch (secim){
			 	case 1:
			 	{
			 		
					
					
					Banka.yazdir();
					System.out.println();
					System.out.println();
					Banka.sirala();
					Banka.yazdir2();
					break;
			 	}
			 	case 2:
			 	{
			 	    gise_olusturma(n,gise);
			 	    Banka.ortalamalar�_yaz();
			 		break;
			 	}
			 }
		 }while(secim!=3);
		 
		 		 

	}
	
	public static int menu()
	{
		int secim;
		
		System.out.println("1) FIFO kuyru�u ve �ncelik kuyru�u olu�turma");
		System.out.println("2) 3 adet FIFO ve �ncelik kuyru�u olu�turup zaman k�yaslama");
		System.out.println("3) ��k��");
		System.out.println();
		System.out.println("Se�iminizi giriniz:");
		Scanner in = new Scanner(System.in);
		secim=in.nextInt();
		
		return secim;
	}
	
	public static void gise_olusturma(int n,ArrayList<Musteri> kuyruk){
		
		Kuyruk kuyruk1=new Kuyruk(n,kuyruk);
 		Kuyruk kuyruk2=new Kuyruk(n,kuyruk);
 		Kuyruk kuyruk3=new Kuyruk(n,kuyruk);
 		
 		
 		for(int i=0;i<n;i++){
 		
 			if(kuyruk1.boyut<=kuyruk2.boyut && kuyruk1.boyut<=kuyruk3.boyut)
 				kuyruk1.tekli_ekle(i);
 			else{
 				if(kuyruk2.boyut<=kuyruk3.boyut)
 					kuyruk2.tekli_ekle(i);
 				else{
 					kuyruk3.tekli_ekle(i);
 				     }
 			     }
 			
 		    
 		}
 		System.out.println("1. Gi�enin bekleme s�resi");
 		float sure1=kuyruk1.gise_sure();
 		System.out.println(sure1+"\n\n");
 		System.out.println("2. Gi�enin bekleme s�resi");
 		float sure2=kuyruk2.gise_sure();
 		System.out.println(sure2+"\n\n");
 		System.out.println("3. Gi�enin bekleme s�resi");
 		float sure3=kuyruk3.gise_sure();
 		System.out.println(sure3+"\n\n");
 		float genel_fifo_ort=sure1+sure2+sure3;
 		
 		
 		System.out.println("1. Gi�enin �ncelikli ortalama bekleme s�resi");
 		
 		kuyruk1.gise_sirala();
 		kuyruk1.yazdir3();
 		
 		System.out.println("\n\n");
 		System.out.println("2. Gi�enin �ncelikli ortalama bekleme s�resi");
 		
 		kuyruk2.gise_sirala();
 		kuyruk2.yazdir3();
 		
 		System.out.println("\n\n");
 		System.out.println("3.Gi�enin �ncelikli ortalama bekleme s�resi");
 		
 		kuyruk3.gise_sirala();
 		kuyruk3.yazdir3();
 		System.out.println("\n\n");
 		
 		float gise_ort=kuyruk1.onc_ort()+kuyruk2.onc_ort()+kuyruk3.onc_ort();
 		
 		System.out.println("Tek gi�e ve �� gi�e aras�ndaki zaman farklar�");
 		System.out.println("FIFO toplamlar�:"+genel_fifo_ort);
 		System.out.println("�ncelik toplamlar�:"+gise_ort);
 		
	}
	

}
