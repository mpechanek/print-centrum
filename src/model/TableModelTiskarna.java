package model;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class TableModelTiskarna extends AbstractTableModel{
	
	

		
		private final String[] sloupce = {"Cena tiskárny","èíslo místnosti","èíslo tiskárny","náklady na stránku","název tiskárny"};
		private TiskarnaServicies tiskarnaServ;
		
		
		
		public TableModelTiskarna(TiskarnaServicies tis) {
			this.tiskarnaServ = tis;
		}
		
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return sloupce.length;
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return tiskarnaServ.getPocetTiskaren();
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Tiskarna t = tiskarnaServ.getTiskarna(rowIndex);
			
			switch (columnIndex) {

			case 0 : return t.getCenaTiskarny();
			case 1: return t.getCisloMistnosti();
			case 2: return t.getCisloTiskarny();
			case 3: return t.getNakladyNaStranku();
			case 4: return t.getNazevTiskarny();
			default:
				return null;
			}
		}
		
		@Override
		public String getColumnName(int column) {
			return sloupce[column];
		}
		
		
		
		
		


}
