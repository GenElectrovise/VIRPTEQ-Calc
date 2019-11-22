package virpteq.updater.panels;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class JSearching extends JFrame {

	public JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JSearching() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextPane txtpnSearchingForUpdates = new JTextPane();
		txtpnSearchingForUpdates.setText(
				"SEARCHING FOR UPDATES\r\nWe are accessing our GitHub repository at:\r\nwww.github.com/GenElectrovise/VIRPTEQ-Calc\r\nIf an update is available, it will be downloaded.");
		txtpnSearchingForUpdates.setBounds(10, 11, 414, 71);
		contentPane.add(txtpnSearchingForUpdates);
		txtpnSearchingForUpdates.setEditable(false);
	}
}
