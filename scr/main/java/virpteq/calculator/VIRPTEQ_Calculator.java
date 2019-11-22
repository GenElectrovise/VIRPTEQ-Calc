package virpteq.calculator;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import virpteq.calculator.VIRPTEQ_Equations;

import javax.swing.JLabel;

public class VIRPTEQ_Calculator {

	protected static JFrame frame;
	protected static JTextField textFieldV;
	protected static JTextField textFieldI;
	protected static JTextField textFieldR;
	protected static JTextField textFieldP;
	protected static final ButtonGroup buttonGroupV = new ButtonGroup();
	protected static final ButtonGroup buttonGroupI = new ButtonGroup();
	static JRadioButton rdbtnViR = new JRadioButton("V=I * R");
	static JRadioButton rdbtnVpI = new JRadioButton("V=P / I");
	static JRadioButton rdbtnIvR = new JRadioButton("I=V / R");
	static JRadioButton rdbtnIpV = new JRadioButton("I=P / V");
	static JRadioButton rdbtnIQ = new JRadioButton("I= Q / T");
	static JRadioButton rdbtnPiR = new JRadioButton("P=I^2 * R");
	static JRadioButton rdbtnPiV = new JRadioButton("P=I * V");
	static JRadioButton rdbtnEP = new JRadioButton("E= P * T");
	static JRadioButton rdbtnEQ = new JRadioButton("E= Q * V");
	static JRadioButton rdbtnTeP = new JRadioButton("T=E / P");
	static JRadioButton rdbtnPE = new JRadioButton("P= E / T");
	static JRadioButton rdbtnQI = new JRadioButton("Q= I * T");
	static JRadioButton rdbtnRV = new JRadioButton("R= V / I");

	protected static JTextField textFieldQ;
	protected static JTextField textFieldT;
	protected static final ButtonGroup buttonGroupP = new ButtonGroup();
	protected static JTextField textFieldE;
	protected static final ButtonGroup buttonGroupE = new ButtonGroup();
	protected static final ButtonGroup buttonGroupT = new ButtonGroup();
	protected static final ButtonGroup buttonGroupC = new ButtonGroup();
	protected static final ButtonGroup buttonGroupR = new ButtonGroup();
	protected static final JRadioButton rdbtnVE = new JRadioButton("V= E / Q");
	
	private VIRPTEQ_Equations virpteq_equations = new VIRPTEQ_Equations();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIRPTEQ_Calculator window = new VIRPTEQ_Calculator();
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
	public VIRPTEQ_Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	protected void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setTitle("VIRP Calculator by GenElectrovise");

		textFieldR = new JTextField();
		textFieldI = new JTextField();
		textFieldV = new JTextField();

		JPanel bgPanel = new JPanel();
		bgPanel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"VIRPTEQ Calculator by GenElectrovise", TitledBorder.CENTER, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		bgPanel.setBounds(10, 11, 591, 269);
		frame.getContentPane().add(bgPanel);
		bgPanel.setLayout(null);

		textFieldV.setBounds(10, 45, 96, 20);
		bgPanel.add(textFieldV);
		textFieldV.setColumns(10);

		textFieldI.setBounds(10, 76, 96, 20);
		bgPanel.add(textFieldI);
		textFieldI.setColumns(10);

		textFieldR.setBounds(10, 107, 96, 20);
		bgPanel.add(textFieldR);
		textFieldR.setColumns(10);

		JButton btnCurrent = new JButton("Current");
		btnCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action");

				virpteq_equations.calcCur();
			}
		});
		btnCurrent.setBounds(116, 75, 117, 23);
		bgPanel.add(btnCurrent);

		JButton btnVoltage = new JButton("Voltage");
		btnVoltage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action");

				virpteq_equations.calcVolt();
			}
		});
		btnVoltage.setBounds(116, 44, 117, 23);
		bgPanel.add(btnVoltage);

		JButton btnResistance = new JButton("Resistance");
		btnResistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action");

				virpteq_equations.calcRes();
			}
		});
		btnResistance.setBounds(116, 106, 117, 23);
		bgPanel.add(btnResistance);

		textFieldP = new JTextField();
		textFieldP.setBounds(10, 138, 96, 20);
		bgPanel.add(textFieldP);
		textFieldP.setColumns(10);

		JButton btnPower = new JButton("Power");
		btnPower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action");

				virpteq_equations.calcPow();
			}
		});
		btnPower.setBounds(116, 137, 117, 23);
		bgPanel.add(btnPower);

		buttonGroupV.add(rdbtnViR);
		rdbtnViR.setBounds(239, 44, 109, 23);
		rdbtnViR.setSelected(true);
		bgPanel.add(rdbtnViR);

		buttonGroupV.add(rdbtnVpI);
		rdbtnVpI.setBounds(350, 44, 109, 23);
		bgPanel.add(rdbtnVpI);

		buttonGroupI.add(rdbtnIvR);
		rdbtnIvR.setBounds(239, 75, 109, 23);
		rdbtnIvR.setSelected(true);
		bgPanel.add(rdbtnIvR);

		buttonGroupI.add(rdbtnIpV);
		rdbtnIpV.setBounds(350, 75, 109, 23);
		bgPanel.add(rdbtnIpV);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldI.setText("");
				textFieldR.setText("");
				textFieldV.setText("");
				textFieldP.setText("");
				textFieldQ.setText("");
				textFieldE.setText("");
				textFieldT.setText("");
			}
		});
		btnClear.setBounds(10, 11, 96, 23);
		bgPanel.add(btnClear);

		JLabel lblLeftValuesIn = new JLabel("Left: Values in and out. Buttons to calculate. Right: Select equation");
		lblLeftValuesIn.setBounds(116, 19, 393, 14);
		bgPanel.add(lblLeftValuesIn);

		textFieldQ = new JTextField();
		textFieldQ.setBounds(10, 169, 96, 20);
		bgPanel.add(textFieldQ);
		textFieldQ.setColumns(10);

		textFieldT = new JTextField();
		textFieldT.setBounds(10, 200, 96, 20);
		bgPanel.add(textFieldT);
		textFieldT.setColumns(10);

		JButton btnCharge = new JButton("Charge");
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				virpteq_equations.calcCharge();
			}
		});
		btnCharge.setBounds(116, 168, 117, 23);
		bgPanel.add(btnCharge);

		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				virpteq_equations.calcTime();
			}
		});
		btnTime.setBounds(116, 199, 117, 23);
		bgPanel.add(btnTime);

		JButton btnEnergy = new JButton("Energy");
		btnEnergy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				virpteq_equations.calcEnergy();
			}
		});
		btnEnergy.setBounds(116, 230, 117, 23);
		bgPanel.add(btnEnergy);

		buttonGroupI.add(rdbtnIQ);
		rdbtnIQ.setBounds(461, 75, 109, 23);
		bgPanel.add(rdbtnIQ);

		buttonGroupP.add(rdbtnPiV);
		rdbtnPiV.setBounds(239, 137, 109, 23);
		rdbtnPiV.setSelected(true);
		bgPanel.add(rdbtnPiV);

		buttonGroupP.add(rdbtnPiR);
		rdbtnPiR.setBounds(350, 137, 109, 23);
		bgPanel.add(rdbtnPiR);

		textFieldE = new JTextField();
		textFieldE.setBounds(10, 231, 96, 20);
		bgPanel.add(textFieldE);
		textFieldE.setColumns(10);

		buttonGroupE.add(rdbtnEP);
		rdbtnEP.setBounds(239, 230, 109, 23);
		rdbtnEP.setSelected(true);
		bgPanel.add(rdbtnEP);

		buttonGroupE.add(rdbtnEQ);
		rdbtnEQ.setBounds(350, 230, 109, 23);
		bgPanel.add(rdbtnEQ);

		buttonGroupT.add(rdbtnTeP);
		rdbtnTeP.setBounds(239, 199, 109, 23);
		rdbtnTeP.setSelected(true);
		bgPanel.add(rdbtnTeP);

		buttonGroupP.add(rdbtnPE);
		rdbtnPE.setBounds(461, 137, 109, 23);
		bgPanel.add(rdbtnPE);

		buttonGroupC.add(rdbtnQI);
		rdbtnQI.setBounds(239, 168, 109, 23);
		rdbtnQI.setSelected(true);
		bgPanel.add(rdbtnQI);

		buttonGroupR.add(rdbtnRV);
		rdbtnRV.setBounds(239, 106, 109, 23);
		rdbtnRV.setSelected(true);
		bgPanel.add(rdbtnRV);
		buttonGroupV.add(rdbtnVE);
		rdbtnVE.setBounds(461, 44, 109, 23);

		bgPanel.add(rdbtnVE);
	}
}
