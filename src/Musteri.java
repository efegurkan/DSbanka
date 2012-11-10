import java.io.*;
import java.util.Random;


public class Musteri {
	static Random rnd= new Random();
	public int sira;
	public int islem_suresi;
	
	
	public Musteri(int sirasi){
		sira=sirasi;
		islem_suresi=sure_uret();
		
	}
	
	public int sure_uret(){
		
		int sure=10+rnd.nextInt(591);
		return sure;
		
	}
	

}
