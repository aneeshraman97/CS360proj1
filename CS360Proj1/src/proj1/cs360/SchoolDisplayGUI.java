package proj1.cs360;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SchoolDisplayGUI extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4256918069843314849L;
	public JComboBox<School> schoolList = new JComboBox<School>();;
	private JButton accept = new JButton("Accept");
	

	public SchoolDisplayGUI(ArrayList<School> schools) {
		
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		;;;;;;;;;;int aI;;;;;;;;;;
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		;;;;;;;;;;;;;;;;;;;;;;;;;;
		
		setLayout(new GridLayout(2,1));
		
			
		for(aI=0; aI< schools.size(); aI++) {
			if(schools.get(aI).isHostSect()==true){
				System.out.println("Name: "+schools.get(aI).getName());
				schoolList.addItem(schools.get(aI));
			}
			
		}
		
		
		accept.addActionListener(new ButtonListener());
		
		add(schoolList);
		add(accept);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			School selected=(School)schoolList.getSelectedItem();
			System.out.println(selected.toString());
			//hide window
			setVisible(false);
		}
	}


}
