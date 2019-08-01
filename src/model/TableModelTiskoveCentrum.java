package model;

import javax.swing.table.AbstractTableModel;



@SuppressWarnings("serial")
public class TableModelTiskoveCentrum extends AbstractTableModel {
	
	private final String[] sloupce = {"Tiskárna","Název tiskárny","Místnost tiskárny","Poèet vytištìnách stran","Kdo tiskl","Datum"};
	//private TiskarnaServicies tiskaranServ;
	private TiskServicies tiskServ;
	
	
	public TableModelTiskoveCentrum(/*TiskarnaServicies tis,*/ TiskServicies ts) {
		//this.tiskaranServ = tis;
		this.tiskServ = ts;
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return sloupce.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return tiskServ.getPocetTisku();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Tisk t = tiskServ.getTiskList().get(rowIndex);
		
		switch (columnIndex) {

		case 0 : return t.getTiskarna().getCisloTiskarny();
		case 1: return t.getTiskarna().getNazevTiskarny();
		case 2: return t.getTiskarna().getCisloMistnosti();
		case 3: return t.getPocetStran();
		case 4: return t.getJmenoOsoby();
		case 5: return t.getDatum();
		default:
			return null;
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return sloupce[column];
	}
	
	
	
	
	
}
