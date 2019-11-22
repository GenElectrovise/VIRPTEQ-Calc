package main.java;

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
import javax.swing.JLabel;

public class VIRPEQT_Calculator {

	private JFrame frame;
	private JTextField textFieldV;
	private JTextField textFieldI;
	private JTextField textFieldR;
	private JTextField textFieldP;
	private final ButtonGroup buttonGroupV = new ButtonGroup();
	private final ButtonGroup buttonGroupI = new ButtonGroup();
	JRadioButton rdbtnViR = new JRadioButton("V=I * R");
	JRadioButton rdbtnVpI = new JRadioButton("V=P / I");
	JRadioButton rdbtnIvR = new JRadioButton("I=V / R");
	JRadioButton rdbtnIpV = new JRadioButton("I=P / V");
	JRadioButton rdbtnIQ = new JRadioButton("I= Q / T");
	JRadioButton rdbtnPiR = new JRadioButton("P=I^2 * R");
	JRadioButton rdbtnPiV = new JRadioButton("P=I * V");
	JRadioButton rdbtnEP = new JRadioButton("E= P * T");
	JRadioButton rdbtnEQ = new JRadioButton("E= Q * V");
	JRadioButton rdbtnTeP = new JRadioButton("T=E / P");
	JRadioButton rdbtnPE = new JRadioButton("P= E / T");
	JRadioButton rdbtnQI = new JRadioButton("Q= I * T");
	JRadioButton rdbtnRV = new JRadioButton("R= V / I");

	private JTextField textFieldQ;
	private JTextField textFieldT;
	private final ButtonGroup buttonGroupP = new ButtonGroup();
	private JTextField textFieldE;
	private final ButtonGroup buttonGroupE = new ButtonGroup();
	private final ButtonGroup buttonGroupT = new ButtonGroup();
	private final ButtonGroup buttonGroupC = new ButtonGroup();
	private final ButtonGroup buttonGroupR = new ButtonGroup();
	private final JRadioButton rdbtnVE = new JRadioButton("V= E / Q");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIRPEQT_Calculator window = new VIRPEQT_Calculator();
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
	public VIRPEQT_Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 627, 327);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		frame.setTitle("VIRP Calculator by GenElectrovise");

		textFieldR = new JTextField();
		textFieldI = new JTextField();
		textFieldV = new JTextField();

		JPanel bgPanel = new JPanel();
		bgPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "VIRPEQT Calculator by GenElectrovise", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

				calcCur();
			}
		});
		btnCurrent.setBounds(116, 75, 117, 23);
		bgPanel.add(btnCurrent);

		JButton btnVoltage = new JButton("Voltage");
		btnVoltage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action");

				calcVolt();
			}
		});
		btnVoltage.setBounds(116, 44, 117, 23);
		bgPanel.add(btnVoltage);

		JButton btnResistance = new JButton("Resistance");
		btnResistance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action");

				calcRes();
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

				calcPow();
			}
		});
		btnPower.setBounds(116, 137, 117, 23);
		bgPanel.add(btnPower);

		buttonGroupV.add(rdbtnViR);
		rdbtnViR.setBounds(239, 44, 109, 23);
		bgPanel.add(rdbtnViR);

		buttonGroupV.add(rdbtnVpI);
		rdbtnVpI.setBounds(350, 44, 109, 23);
		bgPanel.add(rdbtnVpI);

		buttonGroupI.add(rdbtnIvR);
		rdbtnIvR.setBounds(239, 75, 109, 23);
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
				calcCharge();
			}
		});
		btnCharge.setBounds(116, 168, 117, 23);
		bgPanel.add(btnCharge);

		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcTime();
			}
		});
		btnTime.setBounds(116, 199, 117, 23);
		bgPanel.add(btnTime);

		JButton btnEnergy = new JButton("Energy");
		btnEnergy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcEnergy();
			}
		});
		btnEnergy.setBounds(116, 230, 117, 23);
		bgPanel.add(btnEnergy);

		buttonGroupI.add(rdbtnIQ);
		rdbtnIQ.setBounds(461, 75, 109, 23);
		bgPanel.add(rdbtnIQ);

		buttonGroupP.add(rdbtnPiV);
		rdbtnPiV.setBounds(239, 137, 109, 23);
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
		bgPanel.add(rdbtnEP);

		buttonGroupE.add(rdbtnEQ);
		rdbtnEQ.setBounds(350, 230, 109, 23);
		bgPanel.add(rdbtnEQ);

		buttonGroupT.add(rdbtnTeP);
		rdbtnTeP.setBounds(239, 199, 109, 23);
		bgPanel.add(rdbtnTeP);

		buttonGroupP.add(rdbtnPE);
		rdbtnPE.setBounds(461, 137, 109, 23);
		bgPanel.add(rdbtnPE);

		buttonGroupC.add(rdbtnQI);
		rdbtnQI.setBounds(239, 168, 109, 23);
		bgPanel.add(rdbtnQI);

		buttonGroupR.add(rdbtnRV);
		rdbtnRV.setBounds(239, 106, 109, 23);
		bgPanel.add(rdbtnRV);
		buttonGroupV.add(rdbtnVE);
		rdbtnVE.setBounds(461, 44, 109, 23);

		bgPanel.add(rdbtnVE);
	}

	private void calcCur() {
		System.out.println("CalcCur");
		try {
			System.out.println(buttonGroupI.getSelection());
			if (rdbtnIvR.isSelected()) {

				float r = Float.parseFloat(textFieldR.getText());
				float v = Float.parseFloat(textFieldV.getText());
				float i = v / r;

				textFieldI.setText(Float.toString(i));
			}

			if (rdbtnIpV.isSelected()) {

				float p = Float.parseFloat(textFieldP.getText());
				float v = Float.parseFloat(textFieldV.getText());
				float i = p / v;

				textFieldI.setText(Float.toString(i));
			}

			if (rdbtnIQ.isSelected()) {

				float q = Float.parseFloat(textFieldQ.getText());
				float t = Float.parseFloat(textFieldT.getText());
				float i = q / t;

				textFieldI.setText(Float.toString(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void calcRes() {
		System.out.println("CalcRes");
		try {
			if (rdbtnRV.isSelected()) {

				float v = Float.parseFloat(textFieldV.getText());
				float i = Float.parseFloat(textFieldI.getText());
				float r = v / i;

				textFieldR.setText(Float.toString(r));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void calcVolt() {
		System.out.println("CalcVol");
		try {

			if (rdbtnViR.isSelected()) {

				float i = Float.parseFloat(textFieldI.getText());
				float r = Float.parseFloat(textFieldR.getText());
				float v = i * r;

				textFieldV.setText(Float.toString(v));
			}

			if (rdbtnVpI.isSelected()) {

				float i = Float.parseFloat(textFieldI.getText());
				float p = Float.parseFloat(textFieldP.getText());
				float v = p / i;

				textFieldV.setText(Float.toString(v));
			}

			if (rdbtnVE.isSelected()) {
				float e = Float.parseFloat(textFieldE.getText());
				float q = Float.parseFloat(textFieldQ.getText());
				float v = e / q;

				textFieldV.setText(Float.toString(v));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void calcPow() {
		System.out.println("CalcPow");
		try {
			if (rdbtnPiV.isSelected()) {
				float i = Float.parseFloat(textFieldI.getText());
				float v = Float.parseFloat(textFieldV.getText());
				float p = i * v;

				textFieldP.setText(Float.toString(p));
			}
			if (rdbtnPiR.isSelected()) {
				float i = Float.parseFloat(textFieldI.getText());
				float r = Float.parseFloat(textFieldR.getText());
				float p = i * i * r;

				textFieldP.setText(Float.toString(p));
			}
			if (rdbtnPE.isSelected()) {
				float e = Float.parseFloat(textFieldE.getText());
				float t = Float.parseFloat(textFieldT.getText());
				float p = e / t;

				textFieldP.setText(Float.toString(p));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void calcTime() {
		System.out.println("CalcTime");
		try {

			if (rdbtnTeP.isSelected()) {
				float e = Float.parseFloat(textFieldE.getText());
				float p = Float.parseFloat(textFieldP.getText());
				float t = e / p;

				textFieldT.setText(Float.toString(t));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void calcCharge() {
		System.out.println("CalcCharge");
		try {

			if (rdbtnQI.isSelected()) {

				float t = Float.parseFloat(textFieldT.getText());
				float i = Float.parseFloat(textFieldI.getText());
				float q = i * t;

				textFieldQ.setText(Float.toString(q));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void calcEnergy() {
		System.out.println("CalcEnergy");
		try {

			if (rdbtnEP.isSelected()) {

				float p = Float.parseFloat(textFieldP.getText());
				float t = Float.parseFloat(textFieldT.getText());
				float e = p * t;

				textFieldE.setText(Float.toString(e));
			}

			if (rdbtnEQ.isSelected()) {

				float q = Float.parseFloat(textFieldQ.getText());
				float v = Float.parseFloat(textFieldV.getText());
				float e = q * v;

				textFieldE.setText(Float.toString(e));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
