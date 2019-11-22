package virpteq.updater;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import virpteq.updater.panels.JDone;
import virpteq.updater.panels.JSearchFailed;
import virpteq.updater.panels.JSearching;
import virpteq.updater.panels.JUpdating;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VIRPTEQ_Updater_GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIRPTEQ_Updater_GUI window = new VIRPTEQ_Updater_GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VIRPTEQ_Updater_GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel bgpanel = new JPanel();
		bgpanel.setBorder(new TitledBorder(null, "VIRPTEQ Calculator Updater", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bgpanel.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(bgpanel);
		bgpanel.setLayout(null);
		
		JTextPane txtpnSearchingForUpdates = new JTextPane();
		txtpnSearchingForUpdates.setToolTipText("Log of actions");
		txtpnSearchingForUpdates.setFont(new Font("Tahoma", Font.BOLD, 9));
		txtpnSearchingForUpdates.setEditable(false);
		txtpnSearchingForUpdates.setBounds(10, 23, 210, 205);
		bgpanel.add(txtpnSearchingForUpdates);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnUpdate.setBounds(270, 187, 89, 23);
		bgpanel.add(btnUpdate);

	}
}
