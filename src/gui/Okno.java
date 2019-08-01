package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import model.TableModelTiskarna;
import model.TableModelTiskoveCentrum;
import model.Tisk;
import model.TiskServicies;
import model.Tiskarna;
import model.TiskarnaServicies;

@SuppressWarnings("serial")
public class Okno extends JFrame {

	public static final String SOUBOR = "tiskoveCentrum.txt";
	public static final String SOUBOR_TISKARNA = "tiskoveCentrum_tiskarny.txt";
	
	public static final String CENA_CELKEM = "Celkov� n�klady za tisk: ";
	public static final String CENA_CELKEM_ZA_TISKARNU = "Celkov� n�klady za tisk�rnu: ";
	
	private TableModelTiskoveCentrum tblModel;
	private JTable tblTisk;
	private JTable tblTiskarny;
	private TableModelTiskarna tblModelTiskarna;
	
	private TiskarnaServicies tiskarnaServ;
	private TiskServicies tiskServ;
	
	//textFieldy pro tiskarnu
	private JTextField tfnazevTiskarny;
	private JTextField tfcenaTiskarny;
	private JTextField tfmistnostTiskarny;
	private JTextField tfnakladyNaStranku;
	
	//textFieldy pro tisk
	private JTextField tfpocetStranTisku;
	private JTextField tfkdoTiskl;
	private JTextField tfdatumTisku;
	
	private JButton btnulozitTiskarnu;
	private JButton btnulozitTisk;
	private JButton btnodebratTiskarnu;
	private JButton btnodebratTisk;
	private JButton btnexportovat;
	
	private JLabel lblcelkovaCena;
	private JLabel lblcenaZaTiskarnu;
	
	public Okno() {
		super("Tiskov� centrum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tiskarnaServ = new TiskarnaServicies();
		tiskServ = new TiskServicies();
		tblModel = new TableModelTiskoveCentrum(tiskServ);
		setVisible(true);
		tblModelTiskarna = new TableModelTiskarna(tiskarnaServ);
		
		init();
	}

	private void init() {
		
		
		tfnazevTiskarny = new JTextField("N�zev tisk�rny",2);
		tfcenaTiskarny = new JTextField("Cena tisk�rny", 2);
		tfmistnostTiskarny = new JTextField("M�stnost tisk�rny",2);
		tfnakladyNaStranku = new JTextField("N�klady na str�nku tisku",2);
		
		lblcelkovaCena = new JLabel(CENA_CELKEM + "0K�");
		lblcenaZaTiskarnu = new JLabel(CENA_CELKEM_ZA_TISKARNU + "0K�");
		
		tfpocetStranTisku = new JTextField("Po�et stran tisku",2);
		tfdatumTisku = new JTextField("Datum tisku",2);
		tfkdoTiskl = new JTextField("Kdo tiskl",2);
		
		
		btnulozitTiskarnu = new JButton("Ulo�it tisk�rnu");
		btnulozitTiskarnu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 ulozTiskarnu();
				
			}
		});
		
		btnulozitTisk = new JButton("Ulo�it tisk");
		btnulozitTisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 ulozTisk();
				
			}
		});
		
		
		btnodebratTiskarnu = new JButton("Odebrat vybranou tisk�rnu");
		btnodebratTiskarnu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 odeberTiskarnu();
				
			}
		});
		
		btnodebratTisk = new JButton("Odebrat vybran� tisk");
		btnodebratTisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 odeberTisk();
				
			}
		});
		
		btnexportovat = new JButton("Exportovat do txt");
		btnexportovat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 try {
					exportuj();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		tblTisk = new JTable(tblModel);
		tblTisk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTisk.setPreferredScrollableViewportSize(new Dimension(400, 200));
		tblTisk.setToolTipText("Tiskov� zak�zky");
		tblTisk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tblTisk.getSelectedRow() > -1 && tblTisk.getSelectedColumn() == 0) {
					//priv�tn� prom�nn� ve kter� bude ulo�en� index vybran� v tabulce a ten se bude pak mazat
					//aktivovat tla��tko
					
					//aktualizujKosik(tabPolozky.getSelectedRow());
					//aktualizujCelkovouCenu();
				}
			}
		});
		
		tblTiskarny = new JTable(tblModelTiskarna);
		tblTiskarny.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTiskarny.setPreferredScrollableViewportSize(new Dimension(400, 200));
		tblTiskarny.setToolTipText("Tisk�rny");
		tblTiskarny.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tblTiskarny.getSelectedRow() > -1 && tblTiskarny.getSelectedColumn() == 0) {
					//priv�tn� prom�nn� ve kter� bude ulo�en� index vybran� v tabulce a ten se bude pak mazat
					//aktivovat tla��tko
					
					//aktualizujKosik(tabPolozky.getSelectedRow());
					//aktualizujCelkovouCenu();
				}
			}
		});
		
		
		
		
		
		
		JPanel pnlTisk = new JPanel();
		pnlTisk.setLayout(new GridLayout(2, 3));
		pnlTisk.add(tfpocetStranTisku);
		pnlTisk.add(tfdatumTisku);
		pnlTisk.add(tfkdoTiskl);
		pnlTisk.add(btnulozitTisk);
		pnlTisk.add(btnodebratTisk);
		
		JPanel pnlTiskarna = new JPanel();
		pnlTiskarna.setLayout(new GridLayout(4, 4));
		pnlTiskarna.add(tfcenaTiskarny);
		pnlTiskarna.add(tfmistnostTiskarny);
		pnlTiskarna.add(tfnakladyNaStranku);
		pnlTiskarna.add(tfnazevTiskarny);
		pnlTiskarna.add(btnulozitTiskarnu);
		pnlTiskarna.add(btnodebratTiskarnu);
		
		JPanel pnlspodni = new JPanel();
		pnlspodni.setLayout(new BorderLayout());
		pnlspodni.add(lblcenaZaTiskarnu, BorderLayout.EAST);
		pnlspodni.add(lblcelkovaCena, BorderLayout.WEST);
		pnlspodni.add(btnexportovat,BorderLayout.SOUTH);
		
		JPanel pnltlacitka = new JPanel();
		pnltlacitka.setLayout(new BorderLayout());
		pnltlacitka.add(pnlTisk, BorderLayout.EAST);
		pnltlacitka.add(pnlTiskarna, BorderLayout.WEST);
		
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(pnltlacitka, BorderLayout.NORTH);
		getContentPane().add(new JScrollPane(tblTisk), BorderLayout.EAST);
		getContentPane().add(new JScrollPane(tblTiskarny), BorderLayout.WEST);
		getContentPane().add(pnlspodni, BorderLayout.SOUTH);
		pack();
		setSize(900, 500);
	}

	protected void aktualizujCelkovouCenu() {
		if(tiskarnaServ.getPocetTiskaren() > 0 && tiskServ.getPocetTisku() >0){
			int cena = 0;
			int i =1;
			for(Tisk t : tiskServ.getTiskList()){
				cena = cena +(tiskServ.getPocetTisku() * tiskServ.getCenuTisku(i, tiskServ.getTisk(i).getTiskarna().getNakladyNaStranku()));
						i++;
			}
			lblcelkovaCena.setText(CENA_CELKEM + cena);
		}
		
	}

	protected void exportuj() throws Exception {
		tiskServ.export(SOUBOR, tiskServ.getTiskList());
		tiskarnaServ.export(SOUBOR_TISKARNA, tiskarnaServ.getTiskarnyList());
	}

	protected void odeberTisk() {
		if(tblTisk.getSelectedRowCount() > 0){
			
			tiskServ.odeberTisk(tblTisk.getSelectedRowCount());
			tblModel.fireTableDataChanged();
			//aktualizujCelkovouCenu();
		}		
	}

	protected void odeberTiskarnu() {
		if(tblTiskarny.getSelectedRowCount() > 0){
			
			tiskarnaServ.odeberTiskarnu(tblTiskarny.getSelectedRowCount());
			tblModelTiskarna.fireTableDataChanged();
			
		}

		
	}

	protected void ulozTisk() {
		
		String kdo = tfkdoTiskl.getText();
		if (! "".equals(kdo)) {
			try {
				int strany = Integer.parseInt(tfpocetStranTisku.getText());
				String datum = tfdatumTisku.getText();
				Tisk t = new Tisk(strany, kdo, datum, tiskarnaServ.getTiskarna(tblTiskarny.getSelectedRow()));
				
				tiskServ.addTisk(t);
				tblModel.fireTableDataChanged();
				//aktualizujCelkovouCenu();
			} catch (NumberFormatException e) {
				
			}

		}

		
	}

	protected void ulozTiskarnu() {
		//if((tfcenaTiskarny.getText() != null) || )
		
		String nazev = tfnazevTiskarny.getText();
		if (! "".equals(nazev)) {
			try {
				int cena = Integer.parseInt(tfcenaTiskarny.getText());
				int mistnost = Integer.parseInt(tfmistnostTiskarny.getText());
				int naklady = Integer.parseInt(tfnakladyNaStranku.getText());
				Tiskarna t = new Tiskarna(tiskarnaServ.getPocetTiskaren() +1 , nazev, 
						cena,
						mistnost,
						naklady);
				tiskarnaServ.addTiskarna(t);
				tblModelTiskarna.fireTableDataChanged();
				
			} catch (NumberFormatException e) {
				
			}

		}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
