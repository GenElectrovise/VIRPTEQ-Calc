package virpteq.calculator;

public class VIRPTEQ_Equations {
	protected void calcCur() {
		System.out.println("CalcCur");
		try {
			if (VIRPTEQ_Calculator.rdbtnIvR.isSelected()) {

				float r = Float.parseFloat(VIRPTEQ_Calculator.textFieldR.getText());
				float v = Float.parseFloat(VIRPTEQ_Calculator.textFieldV.getText());
				float i = v / r;

				VIRPTEQ_Calculator.textFieldI.setText(Float.toString(i));
			}

			if (VIRPTEQ_Calculator.rdbtnIpV.isSelected()) {

				float p = Float.parseFloat(VIRPTEQ_Calculator.textFieldP.getText());
				float v = Float.parseFloat(VIRPTEQ_Calculator.textFieldV.getText());
				float i = p / v;

				VIRPTEQ_Calculator.textFieldI.setText(Float.toString(i));
			}

			if (VIRPTEQ_Calculator.rdbtnIQ.isSelected()) {

				float q = Float.parseFloat(VIRPTEQ_Calculator.textFieldQ.getText());
				float t = Float.parseFloat(VIRPTEQ_Calculator.textFieldT.getText());
				float i = q / t;

				VIRPTEQ_Calculator.textFieldI.setText(Float.toString(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void calcRes() {
		try {
			if (VIRPTEQ_Calculator.rdbtnRV.isSelected()) {

				float v = Float.parseFloat(VIRPTEQ_Calculator.textFieldV.getText());
				float i = Float.parseFloat(VIRPTEQ_Calculator.textFieldI.getText());
				float r = v / i;

				VIRPTEQ_Calculator.textFieldR.setText(Float.toString(r));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void calcVolt() {
		try {

			if (VIRPTEQ_Calculator.rdbtnViR.isSelected()) {

				float i = Float.parseFloat(VIRPTEQ_Calculator.textFieldI.getText());
				float r = Float.parseFloat(VIRPTEQ_Calculator.textFieldR.getText());
				float v = i * r;

				VIRPTEQ_Calculator.textFieldV.setText(Float.toString(v));
			}

			if (VIRPTEQ_Calculator.rdbtnVpI.isSelected()) {

				float i = Float.parseFloat(VIRPTEQ_Calculator.textFieldI.getText());
				float p = Float.parseFloat(VIRPTEQ_Calculator.textFieldP.getText());
				float v = p / i;

				VIRPTEQ_Calculator.textFieldV.setText(Float.toString(v));
			}

			if (VIRPTEQ_Calculator.rdbtnVE.isSelected()) {
				float e = Float.parseFloat(VIRPTEQ_Calculator.textFieldE.getText());
				float q = Float.parseFloat(VIRPTEQ_Calculator.textFieldQ.getText());
				float v = e / q;

				VIRPTEQ_Calculator.textFieldV.setText(Float.toString(v));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void calcPow() {
		try {
			if (VIRPTEQ_Calculator.rdbtnPiV.isSelected()) {
				float i = Float.parseFloat(VIRPTEQ_Calculator.textFieldI.getText());
				float v = Float.parseFloat(VIRPTEQ_Calculator.textFieldV.getText());
				float p = i * v;

				VIRPTEQ_Calculator.textFieldP.setText(Float.toString(p));
			}
			if (VIRPTEQ_Calculator.rdbtnPiR.isSelected()) {
				float i = Float.parseFloat(VIRPTEQ_Calculator.textFieldI.getText());
				float r = Float.parseFloat(VIRPTEQ_Calculator.textFieldR.getText());
				float p = i * i * r;

				VIRPTEQ_Calculator.textFieldP.setText(Float.toString(p));
			}
			if (VIRPTEQ_Calculator.rdbtnPE.isSelected()) {
				float e = Float.parseFloat(VIRPTEQ_Calculator.textFieldE.getText());
				float t = Float.parseFloat(VIRPTEQ_Calculator.textFieldT.getText());
				float p = e / t;

				VIRPTEQ_Calculator.textFieldP.setText(Float.toString(p));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void calcTime() {
		try {

			if (VIRPTEQ_Calculator.rdbtnTeP.isSelected()) {
				float e = Float.parseFloat(VIRPTEQ_Calculator.textFieldE.getText());
				float p = Float.parseFloat(VIRPTEQ_Calculator.textFieldP.getText());
				float t = e / p;

				VIRPTEQ_Calculator.textFieldT.setText(Float.toString(t));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void calcCharge() {
		try {

			if (VIRPTEQ_Calculator.rdbtnQI.isSelected()) {

				float t = Float.parseFloat(VIRPTEQ_Calculator.textFieldT.getText());
				float i = Float.parseFloat(VIRPTEQ_Calculator.textFieldI.getText());
				float q = i * t;

				VIRPTEQ_Calculator.textFieldQ.setText(Float.toString(q));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void calcEnergy() {
		try {

			if (VIRPTEQ_Calculator.rdbtnEP.isSelected()) {

				float p = Float.parseFloat(VIRPTEQ_Calculator.textFieldP.getText());
				float t = Float.parseFloat(VIRPTEQ_Calculator.textFieldT.getText());
				float e = p * t;

				VIRPTEQ_Calculator.textFieldE.setText(Float.toString(e));
			}

			if (VIRPTEQ_Calculator.rdbtnEQ.isSelected()) {

				float q = Float.parseFloat(VIRPTEQ_Calculator.textFieldQ.getText());
				float v = Float.parseFloat(VIRPTEQ_Calculator.textFieldV.getText());
				float e = q * v;

				VIRPTEQ_Calculator.textFieldE.setText(Float.toString(e));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
