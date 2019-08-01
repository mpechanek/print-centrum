package model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;



public class TiskServicies {
	private static final String separator = ";";
	private List<Tisk> tiskList;
	
	
	public TiskServicies() {
		tiskList = new ArrayList<>();
	}
	
	public Tisk getTisk(int i){
		return tiskList.get(i);
	}
	
	public List<Tisk> getTiskList(){
		return tiskList;
	}

	public void setTiskList(List<Tisk> t){
		this.tiskList = t;
	}
	
	public void smazTisk(int ktery){
		tiskList.remove(ktery);
	}
	
	public int getCenuTisku(int ktery, int cenaStranky){
		return (tiskList.get(ktery).getPocetStran()*cenaStranky);
	}
	
	public int getPocetTisku(){
		return tiskList.size();
	}
	
	public void addTisk(Tisk e){
		tiskList.add(e);
	}
	
	public void odeberTisk(int ktera){
		tiskList.remove(ktera);
	}
	public void export(String soubor, List<Tisk> listTisku) throws Exception {
		PrintWriter vystup = new PrintWriter(new FileWriter(soubor));
		for (Tisk t : listTisku) {
			vystup.println(t.getJmenoOsoby() + separator + t.getDatum() + separator + t.getPocetStran());
			
		}
		vystup.close();
	
	}
	

}
