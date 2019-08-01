package app;

import javax.swing.SwingUtilities;

import gui.Okno;

public class TiskoveCentrum {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new Okno();
				
			}
		});

	}

}
