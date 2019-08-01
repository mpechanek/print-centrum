package model;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TiskarnaServicies {
	private static final String separator = ";";
	private List<Tiskarna> tiskarny;
	
	public TiskarnaServicies() {
		tiskarny = new ArrayList<>();
		
	}
	
	public List<Tiskarna> getTiskarnyList(){
		return tiskarny;
	}
	
	public void setTiskarnyList(List<Tiskarna> t){
		this.tiskarny = t;
	}
	
	public Tiskarna getTiskarna(int ktera){
		return tiskarny.get(ktera);
	}
	
	public int getPocetTiskaren(){
		return tiskarny.size();
	}
	
	public void addTiskarna(Tiskarna t){
		tiskarny.add(t);
	}
	
	public void odeberTiskarnu(int ktera){
		tiskarny.remove(ktera);
	}

	
	public void export(String soubor, List<Tiskarna> listTiskaren) throws Exception {
		PrintWriter vystup = new PrintWriter(new FileWriter(soubor));
		for (Tiskarna t : listTiskaren) {
			vystup.println(t.getCenaTiskarny() + separator + t.getCisloMistnosti() + separator + t.getCisloTiskarny()
			+ separator + t.getNakladyNaStranku() + separator + t.getNazevTiskarny());
			
		}
		vystup.close();
	
	}
}
