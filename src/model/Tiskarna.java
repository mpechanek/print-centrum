package model;

public class Tiskarna {
	private int cisloTiskarny;
	private String nazevTiskarny;
	private int cenaTiskarny;
	private int cisloMistnosti;
	private int nakladyNaStranku;
	
	
	public Tiskarna(int cisloTiskarny, String nazevTiskarny, int cenaTiskarny, int cisloMistnosti, int nakladyNaStranku) {
		this.setCenaTiskarny(cenaTiskarny);
		this.setCisloTiskarny(cisloTiskarny);
		this.setNazevTiskarny(nazevTiskarny);
		this.setCisloMistnosti(cisloMistnosti);
		this.setNakladyNaStranku(nakladyNaStranku);
		}


	public int getCisloTiskarny() {
		return cisloTiskarny;
	}


	public void setCisloTiskarny(int cisloTiskarny) {
		this.cisloTiskarny = cisloTiskarny;
	}


	public String getNazevTiskarny() {
		return nazevTiskarny;
	}


	public void setNazevTiskarny(String nazevTiskarny) {
		this.nazevTiskarny = nazevTiskarny;
	}


	public int getCisloMistnosti() {
		return cisloMistnosti;
	}


	public void setCisloMistnosti(int cisloMistnosti) {
		this.cisloMistnosti = cisloMistnosti;
	}


	public int getCenaTiskarny() {
		return cenaTiskarny;
	}


	public void setCenaTiskarny(int cenaTiskarny) {
		this.cenaTiskarny = cenaTiskarny;
	}


	public int getNakladyNaStranku() {
		return nakladyNaStranku;
	}


	public void setNakladyNaStranku(int nakladyNaStranku) {
		this.nakladyNaStranku = nakladyNaStranku;
	}
}
