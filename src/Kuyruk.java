import java.util.*;

public class Kuyruk {
	
	public int boyut;
	public ArrayList<Musteri> banka_kuyruk;
	public ArrayList<Musteri> gise_kuyruk;
	public int[] bekleme_suresi;
	public int[] bekleme_suresi_oncelik;
	public double ort_sure;
	public double onc_ort_sure;
	public float gise_onc_ort;
	
	public Kuyruk(int sayi,ArrayList<Musteri> liste){
		banka_kuyruk=new ArrayList<Musteri>();
		gise_kuyruk=new ArrayList<Musteri>();
		banka_kuyruk=(ArrayList<Musteri>)liste.clone();
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
		Musteri birMusteri=banka_kuyruk.get(k);
		gise_kuyruk.add(birMusteri);
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
		onc_ort_sure=oncelik_ort;
	}
	
	public float gise_sure(){
		int beklenen_sure=0;
		int[] beks=new int[boyut];
		Musteri temp;
		
		for(int i=0;i<gise_kuyruk.size();i++){
			temp=gise_kuyruk.get(i);
			beklenen_sure+=temp.islem_suresi;
			beks[i]=beklenen_sure;
			}
		int sure=0;
		for(int i=0;i<beks.length;i++){
			
			sure+=beks[i];
		}
		
		float sure2=(float)sure/boyut;
		return sure2;
	}
	
public void gise_sirala(){
		
		
		Musteri temp1;
		Musteri temp2;
		
		
		
		for (int i = 1; i < boyut; i++) {
		     for (int j = 0; j < boyut - i; j++)
		    {
		    	 temp1=gise_kuyruk.get(j);
		    	  temp2=gise_kuyruk.get(j+1);
		         if(temp1.islem_suresi>temp2.islem_suresi)
		        {
		             Collections.swap(gise_kuyruk, j, j+1);
		         }
		     }
		     
		}
	}
	
	public void yazdir3(){
		int sure=0;
		int toplam_sure=0;
		
		for(int i=0;i<boyut;i++){
			Musteri temp=gise_kuyruk.get(i);
			sure+=temp.islem_suresi;
			bekleme_suresi_oncelik[temp.sira-1]=sure;
			if(bekleme_suresi_oncelik[temp.sira-1]<bekleme_suresi[temp.sira-1]){
				System.out.println("FIFO kuyruguna göre daha az bekleyen müþteri");
				System.out.println(temp.sira+". müþteri ve beklediði süre "+bekleme_suresi_oncelik[temp.sira-1]);
			}
			
			toplam_sure+=sure;
			
		}
		System.out.println("Öncelikli bekleme süresi:"+(float)toplam_sure/boyut);
		gise_onc_ort=(float)toplam_sure/boyut;
	}

	public float onc_ort(){
		
		return gise_onc_ort;
		}
   public void ortalamalarý_yaz(){
	   System.out.println("Tek fifo kuyruðu için ortalama süre:"+ort_sure);
	   System.out.println("Tek öncelik kuyruðu için ortalama süre:"+onc_ort_sure);
	   
   }


}