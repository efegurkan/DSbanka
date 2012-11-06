import java.util.*;

public class Kuyruk {
	
	public int boyut;
	public ArrayList<Musteri> banka_kuyruk;
	public int elemansay;
	public int[] islem_suresi;
	public Kuyruk(int kisi_say){
		
		banka_kuyruk=new ArrayList<Musteri>();
		boyut=kisi_say;
		elemansay=0;
		islem_suresi=new int[boyut];
		
	}
	
	public void ekleme(){
		int sure=0;
		for(int i=0;i<boyut;i++){
		
			Musteri birMusteri=new Musteri(i+1);
			sure+=birMusteri.bekleme_suresi;
			islem_suresi[i]=sure;
			
			/*if(i==0){
				islem_suresi[0]=birMusteri.bekleme_suresi;
			}
			else
				islem_suresi[i+1]=islem_suresi[i]+birMusteri.bekleme_suresi;*/
			banka_kuyruk.add(birMusteri);
		
		}
	}
	
	public void yazdir(){
		int toplam_sure=0;
		for(int i=0;i<boyut;i++){
			
			System.out.println((i+1)+". müşterinin kuyrukta bekleme süresi");
			System.out.println(islem_suresi[i]);
			toplam_sure+=islem_suresi[i];
		}
		double ort=(double)toplam_sure/boyut;
		System.out.println("Ortalama işlem süresi:"+ort);
	}

}
	


