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
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class VIRPTEQ_Updater_GUI {

	private JFrame frame;
	JTextPane txtpnInstructions = new JTextPane();
	JButton btnUpdate = new JButton("Update");
	JPanel bgpanel = new JPanel();
	static JTextArea txtpnLog = new JTextArea();
	boolean updating;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testForSaveLocation();
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
		frame.setBounds(100, 100, 660, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		bgpanel.setBorder(new TitledBorder(null, "VIRPTEQ Calculator Updater", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bgpanel.setBounds(10, 11, 624, 239);
		frame.getContentPane().add(bgpanel);
		bgpanel.setLayout(null);
		txtpnLog.setWrapStyleWord(true);
		
		txtpnLog.setToolTipText("Log of actions");
		txtpnLog.setFont(new Font("Tahoma", Font.BOLD, 7));
		txtpnLog.setEditable(false);
		txtpnLog.setBounds(10, 23, 604, 127);
		txtpnLog.setWrapStyleWord(true);
		txtpnLog.setColumns(20);
		bgpanel.add(txtpnLog);
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUpdate.setEnabled(false);
				appendLog("Starting update", false);
				appendLog("Searching for updates...");
				VIRPTEQ_Updater.initUpdate();
			}
		});
		btnUpdate.setBounds(525, 161, 89, 23);
		btnUpdate.setEnabled(true);
		bgpanel.add(btnUpdate);
		
		txtpnInstructions.setEditable(false);
		txtpnInstructions.setFont(new Font("Tahoma", Font.BOLD, 9));
		txtpnInstructions.setText("This is the VIRPTEQ Calculator Updater!\r\nTo test for and apply updates, click the update button below.\r\nIt will download the latest version \r\nof VIRPTEQ Calculator from our Git repository on: \"github.com/GenElectrovise/VIRPTEQ-Calc\"");
		txtpnInstructions.setBounds(10, 161, 604, 67);
		bgpanel.add(txtpnInstructions);

	}
	
	protected static void appendLog(String toAppend) {
		appendLog(toAppend, true);
	}
	
	protected static void appendLog(String toAppend, boolean newLine) {
		if(newLine) txtpnLog.setText(txtpnLog.getText() + "\n" + toAppend);
		else txtpnLog.setText(txtpnLog.getText() + toAppend);
		System.out.println(toAppend);
	}
	
	private static void testForSaveLocation() {
		
	}
}
