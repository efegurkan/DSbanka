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

}
