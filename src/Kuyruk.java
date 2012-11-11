import java.util.*;

public class Kuyruk {
	
	public int boyut;
	public ArrayList<Musteri> banka_kuyruk;
	
	public int[] bekleme_suresi;
	public int[] bekleme_suresi_oncelik;
	public double ort_sure;
	
	public Kuyruk(int sayi,int l){
		banka_kuyruk=new ArrayList<Musteri>();
        boyut=0;
	    bekleme_suresi=new int[sayi];
		bekleme_suresi_oncelik=new int[sayi];
	}
	
	public Kuyruk(int kisi_say){
		
		
		banka_kuyruk=new ArrayList<Musteri>();
		boyut=kisi_say;
		
		bekleme_suresi=new int[boyut];
		bekleme_suresi_oncelik=new int[boyut];
		
	}
	
	public void ekleme(){
		int sure=0;
		for(int i=0;i<boyut;i++){
		
			Musteri birMusteri=new Musteri(i+1);
			sure+=birMusteri.islem_suresi;
			bekleme_suresi[i]=sure;
			
			
			banka_kuyruk.add(birMusteri);
		
		}
	}
	
	public void tekli_ekle(int k){
		Musteri birMusteri=new Musteri(k);
		banka_kuyruk.add(birMusteri);
		boyut++;
	}
	
	public void yazdir(){
		int toplam_sure=0;
		for(int i=0;i<boyut;i++){
			Musteri temp=banka_kuyruk.get(i);
			
			System.out.println(temp.sira+". müþterinin kuyrukta bekleme süresi");
			System.out.println(bekleme_suresi[i]);
			toplam_sure+=bekleme_suresi[i];
		}
		double ort=(double)toplam_sure/boyut;
		System.out.println("Ortalama iþlem süresi:"+ort);
		ort_sure=ort;
	}
	
	public void sirala(){
		
		
		Musteri temp1;
		Musteri temp2;
		
		
		
		for (int i = 1; i < boyut; i++) {
		     for (int j = 0; j < boyut - i; j++)
		    {
		    	 temp1=banka_kuyruk.get(j);
		    	  temp2=banka_kuyruk.get(j+1);
		         if(temp1.islem_suresi>temp2.islem_suresi)
		        {
		             Collections.swap(banka_kuyruk, j, j+1);
		         }
		     }
		     
		}
	}
	
	public void yazdir2(){
		int sure=0;
		int toplam_sure=0;
		
		for(int i=0;i<boyut;i++){
			Musteri temp=banka_kuyruk.get(i);
			sure+=temp.islem_suresi;
			bekleme_suresi_oncelik[temp.sira-1]=sure;
			if(bekleme_suresi_oncelik[temp.sira-1]<bekleme_suresi[temp.sira-1]){
				System.out.println("FIFO kuyruguna göre daha az bekleyen müþteri");
				System.out.println(temp.sira+". müþteri ve beklediði süre "+bekleme_suresi_oncelik[temp.sira-1]);
			}
			System.out.println(temp.sira+". müþterinin iþlem süresi");
			System.out.println(temp.islem_suresi+"\n");
			toplam_sure+=sure;
			
		}
		double oncelik_ort=(double)toplam_sure/boyut;
		System.out.println("ortalama iþlem süresindeki fark:"+(ort_sure-oncelik_ort));
		System.out.println("Kazanç yüzdesi:%"+(double)(ort_sure-oncelik_ort)/ort_sure*100);
	}
}



