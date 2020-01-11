package lab2;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import org.mariuszgromada.math.mxparser.*;


public class ScientificFragment extends Fragment implements View.OnClickListener {

    private boolean inverted = false;

    private EditText input;
    private Button degRadButton, sinButton, cosButton, tanButton, logButton, lnButton, rootButton, x_nbutton;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sci_fragment, container, false);
        v.findViewById(R.id.x_n).setOnClickListener(this);
        v.findViewById(R.id.x_fact).setOnClickListener(this);
        v.findViewById(R.id.root).setOnClickListener(this);
        v.findViewById(R.id.exp).setOnClickListener(this);
        v.findViewById(R.id.e).setOnClickListener(this);
        v.findViewById(R.id.ln).setOnClickListener(this);
        v.findViewById(R.id.log).setOnClickListener(this);
        v.findViewById(R.id.sin).setOnClickListener(this);
        v.findViewById(R.id.cos).setOnClickListener(this);
        v.findViewById(R.id.tan).setOnClickListener(this);
        v.findViewById(R.id.pi).setOnClickListener(this);
        v.findViewById(R.id.deg_rad).setOnClickListener(this);
        v.findViewById(R.id.inv).setOnClickListener(this);
        v.findViewById(R.id.rnd).setOnClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        input = getActivity().findViewById(R.id.input);
        degRadButton = getActivity().findViewById(R.id.deg_rad);
        sinButton = getActivity().findViewById(R.id.sin);
        cosButton = getActivity().findViewById(R.id.cos);
        tanButton = getActivity().findViewById(R.id.tan);
        logButton = getActivity().findViewById(R.id.log);
        lnButton = getActivity().findViewById(R.id.ln);
        rootButton = getActivity().findViewById(R.id.root);
        x_nbutton = getActivity().findViewById(R.id.x_n);
    }

    private boolean isNeedMultiplyForNumber(String exp){
        return exp.endsWith(")") || exp.endsWith("Pi") || exp.endsWith("e") || exp.endsWith("!") || exp.endsWith("%");
    }
    private boolean isNeedMultiply(String exp){
        return isNeedMultiplyForNumber(exp) || exp.endsWith("1")|| exp.endsWith("2")|| exp.endsWith("3")|| exp.endsWith("4")|| exp.endsWith("5")|| exp.endsWith("6")|| exp.endsWith("7") || exp.endsWith("8")|| exp.endsWith("9")|| exp.endsWith("0");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.x_n: {
                if (inverted) {
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.n_root_action));
                }
                else input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.x_n_action));
                break;
            }
            case R.id.x_fact: {
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.x_fact_action));
                break;
            }
            case R.id.root: {
                if (inverted) {
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.x_squared_action));
                }
                else {
                    if (isNeedMultiply(input.getText().toString()))
                        input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.root_action));
                }
                break;
            }
            case R.id.rnd: {
                double rand = Math.random();
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), String.valueOf(rand));
                break;
            }
            case R.id.e: {
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.e_action));
                break;
            }
            case R.id.ln: {
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));

                if (inverted) {
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.ln_inv_action));
                }
                else input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.ln_action));
                break;
            }
            case R.id.log: {
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                if (inverted) {
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.log_inv_action));
                }
                else input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.log_action));
                break;
            }
            case R.id.sin: {
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                if (inverted) {
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.asin_action));
                }
                else input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.sin_action));
                break;
            }
            case R.id.cos: {
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                if (inverted) {
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.acos_action));
                }
                else input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.cos_action));
                break;
            }
            case R.id.tan: {
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                if (inverted) {
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.atan_action));
                }
                else input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.tan_action));
                break;
            }
            case R.id.pi: {
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.pi_action));
                break;
            }
            case R.id.exp: {
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.exp_action));
                break;
            }
            case R.id.deg_rad: {
                if (mXparser.checkIfDegreesMode()) {
                    mXparser.setRadiansMode();
                    degRadButton.setText(getResources().getString(R.string.rad_button));
                }
                else {
                    mXparser.setDegreesMode();
                    degRadButton.setText(getResources().getString(R.string.deg_button));
                }
                break;
            }
            case R.id.inv:
            {
                inverted = !inverted;
                if (inverted) {
                    sinButton.setText(getResources().getString(R.string.asin_button));
                    cosButton.setText(getResources().getString(R.string.acos_button));
                    tanButton.setText(getResources().getString(R.string.atan_button));
                    logButton.setText(getResources().getString(R.string.log_inv_button));
                    lnButton.setText(getResources().getString(R.string.ln_inv_button));
                    rootButton.setText(getResources().getString(R.string.x_squared_button));
                    x_nbutton.setText(getResources().getString(R.string.n_root_button));
                }
                else {
                    sinButton.setText(getResources().getString(R.string.sin_button));
                    cosButton.setText(getResources().getString(R.string.cos_button));
                    tanButton.setText(getResources().getString(R.string.tan_button));
                    logButton.setText(getResources().getString(R.string.log_button));
                    lnButton.setText(getResources().getString(R.string.ln_button));
                    rootButton.setText(getResources().getString(R.string.root_button));
                    x_nbutton.setText(getResources().getString(R.string.x_n_button));
                }
                break;
            }
        }
    }
}
