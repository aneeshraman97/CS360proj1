package proj1.cs360;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class SetupGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int WINDOW_WIDTH = 240;
	private final int WINDOW_HEIGHT = 400;
	private JPanel tilePane, optPane;
	private JButton[] optBtns = new JButton[3];
	private JTextField[] numMeets = new JTextField[4];
	private ArrayList<School> sch;
	private int n;
	private Classify classify;
	public SetupGUI(ArrayList<School> sch, int n,Classify obj) throws ParseException {
		this.sch=sch;
		this.n=n;
		this.classify=obj;
		setTitle("Tournament Parameters");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setSize(WINDOW_WIDTH + 1, WINDOW_HEIGHT + 1);

		// Make new Jpanels with gridlayouts
		tilePane = new JPanel(new GridLayout(5, 1));

		optPane = new JPanel(new GridLayout(1, 3));

		// add tilePane to window
		add(tilePane);

		// create input boxes
		numMeets[0] = new JTextField();
		numMeets[1] = new JTextField();
		numMeets[2] = new JTextField();
		numMeets[3] = new JTextField();

		// add borders to input boxes
		numMeets[0].setBorder(BorderFactory.createTitledBorder("Max Enrollment for this Class"));
		numMeets[1].setBorder(BorderFactory.createTitledBorder("Number of Sectionals"));
		numMeets[2].setBorder(BorderFactory.createTitledBorder("Number of Regionals"));
		numMeets[3].setBorder(BorderFactory.createTitledBorder("Number of Semi States"));

		// add input boxes to tilePane
		for (int i = 0; i < 4; i++) {
			tilePane.add(numMeets[i]);
		}

		// create buttons add to optnPane then tilePane
		optBtns[0] = new JButton("Accept");
		optBtns[1] = new JButton("View");
		optBtns[1].setEnabled(false);
		optBtns[2] = new JButton("Cancel");

		// add listeners to buttons
		optBtns[0].addActionListener(new AcceptButtonListener());
		optBtns[1].addActionListener(new LoadButtonListener());
		optBtns[2].addActionListener(new ExitButtonListener());

		for (int i = 0; i < 3; i++) {
			optPane.add(optBtns[i]);
		}

		tilePane.add(optPane);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	// exits program
	private class ExitButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}

	}
	
	// Loads binary file containing a previous sessions settings, etc.
	private class LoadButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			
			
			//SAMPLE CODE TO GET US GOING ON THIS PART FROM MY PROJ# of CS161 @Benjamin Treesh
/*			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			
			FileNameExtensionFilter ff = new FileNameExtensionFilter("Tile file", "til");
			chooser.addChoosableFileFilter((javax.swing.filechooser.FileFilter) ff);
			int retrieval = chooser.showOpenDialog(null);
			if (retrieval == JFileChooser.APPROVE_OPTION) {
				try 
				{
					FileInputStream fileIn = new FileInputStream(chooser.getSelectedFile());
					ObjectInputStream in = new ObjectInputStream(fileIn);
					remove(tilePane);
					TilePanel tilePaneLoad = (TilePanel) in.readObject();
					tilePane = new TilePanel((EastGUI) ePanel, tilePaneLoad.getTileArray());
					add(tilePane, BorderLayout.CENTER);
					repaint();
					setSize(WINDOW_WIDTH + 1, WINDOW_HEIGHT + 1);
					setSize(WINDOW_WIDTH, WINDOW_HEIGHT);					
					in.close();
					repaint();
				}catch(IOException l)
				{
					setTitle("Pattern did not load correctly.");
					return;
				}catch(ClassNotFoundException l)
				{
					setTitle("Incorrect file type.");
					return;
				}finally{
					repaint();
				}*/
				
			new ViewGUI(classify);
			setVisible(false);
				
			}
		}
		
		

	// Opens main program when accept is hit with proper parameters
	private class AcceptButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			
			/*
			 * 
			 * PULL INFO From TEXTFIELDS INTO TOURNAMENT CLASS
			 * 
			 * THEN HAVE ViewGUI PULLING ITS INFO FROM TOURNAMENT INSTANCE
			 * 
			 */
			
			//Check if any fields are 0, if so, DONT ALLOW CLASSIFY INSTANTIATION
			
			boolean allow = true;
			
			for(int i = 0; i<4; i++) {
				if(Integer.parseInt(numMeets[i].getText()) <= 0)
					allow = false;
			}
			
			//if all input is correct, allow creation of the Classify object
			if(allow) {
			//
				int enroll=Integer.parseInt(numMeets[0].getText());
				int sect=Integer.parseInt(numMeets[1].getText());
				int reg=Integer.parseInt(numMeets[2].getText());
				int semi=Integer.parseInt(numMeets[3].getText());
				Classify obj=new Classify((char)(n+65),sch,enroll,sect,reg,semi);
				classify=obj;
				//view = new ViewGUI();
				optBtns[0].setEnabled(false);
				optBtns[1].setEnabled(true);
			}
			else {
				JOptionPane.showMessageDialog(null, "Field can not be less than or equal to zero",
						"Invalid Input", JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
	}
}
