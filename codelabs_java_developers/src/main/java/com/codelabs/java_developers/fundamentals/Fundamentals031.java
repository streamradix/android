package com.codelabs.java_developers.fundamentals;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.codelabs.java_developers.R;

public class Fundamentals031 extends AppCompatActivity {
	private static final String LOG_TAG = Fundamentals031.class.getSimpleName();

	private Fundamentals031_Calculator mCalculator;

	private EditText mOperandOneEditText;
	private EditText mOperandTwoEditText;

	private TextView mResultTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fundamentals031);

		// Initialize the calculator class and all the views
		mCalculator = new Fundamentals031_Calculator();
		mResultTextView = findViewById(R.id.operation_result_text_view);
		mOperandOneEditText = findViewById(R.id.operand_one_edit_text);
		mOperandTwoEditText = findViewById(R.id.operand_two_edit_text);
	}

	// OnClick method called when the add Button is pressed.
	public void onAdd(View view) {
		compute(Fundamentals031_Calculator.Operator.ADD);
	}

	// OnClick method called when the subtract Button is pressed.
	public void onSub(View view) {
		compute(Fundamentals031_Calculator.Operator.SUB);
	}

	// OnClick method called when the divide Button is pressed.
	public void onDiv(View view) {
		try {
			compute(Fundamentals031_Calculator.Operator.DIV);
		} catch (IllegalArgumentException iae) {
			Log.e(LOG_TAG, "IllegalArgumentException", iae);
			mResultTextView.setText(getString(R.string.computationError));
		}
	}

	// OnClick method called when the multiply Button is pressed.
	public void onMul(View view) {
		compute(Fundamentals031_Calculator.Operator.MUL);
	}

	private void compute(Fundamentals031_Calculator.Operator operator) {
		double operandOne;
		double operandTwo;
		try {
			operandOne = getOperand(mOperandOneEditText);
			operandTwo = getOperand(mOperandTwoEditText);
		} catch (NumberFormatException nfe) {
			Log.e(LOG_TAG, "NumberFormatException", nfe);
			mResultTextView.setText(getString(R.string.computationError));
			return;
		}

		String result;
		switch (operator) {
			case ADD:
				result = String.valueOf(
						mCalculator.add(operandOne, operandTwo));
				break;
			case SUB:
				result = String.valueOf(
						mCalculator.sub(operandOne, operandTwo));
				break;
			case DIV:
				result = String.valueOf(
						mCalculator.div(operandOne, operandTwo));
				break;
			case MUL:
				result = String.valueOf(
						mCalculator.mul(operandOne, operandTwo));
				break;
			default:
				result = getString(R.string.computationError);
				break;
		}
		mResultTextView.setText(result);
	}

	// @return the operand value entered in an EditText as double.
	private static Double getOperand(EditText operandEditText) {
		String operandText = getOperandText(operandEditText);
		return Double.valueOf(operandText);
	}

	// @return the operand text which was entered in an EditText.
	private static String getOperandText(EditText operandEditText) {
		return operandEditText.getText().toString();
	}
}