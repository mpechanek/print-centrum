package model;



public class Tisk {
		private int pocetStran;
		private String jmenoOsoby;
		private String datum;
		private Tiskarna tiskarna;
		
		public Tisk(int pocetStran, String jmenoOsoby, String datum, Tiskarna tiskarna) {
			this.setPocetStran(pocetStran);
			this.setJmenoOsoby(jmenoOsoby);
			this.setDatum(datum);
			this.setTiskarna(tiskarna);
		}

		public int getPocetStran() {
			return pocetStran;
		}

		public void setPocetStran(int pocetStran) {
			this.pocetStran = pocetStran;
		}

		public String getJmenoOsoby() {
			return jmenoOsoby;
		}

		public void setJmenoOsoby(String jmenoOsoby) {
			this.jmenoOsoby = jmenoOsoby;
		}

		public String getDatum() {
			return datum;
		}

		public void setDatum(String datum) {
			this.datum = datum;
		}

		public Tiskarna getTiskarna() {
			return tiskarna;
		}

		public void setTiskarna(Tiskarna tiskarna) {
			this.tiskarna = tiskarna;
		}
		
		

}
