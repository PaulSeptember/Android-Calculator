package mainpkg;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.mariuszgromada.math.mxparser.Expression;

import lab2.R;

public class ButtonsFragment extends Fragment implements View.OnClickListener {

    private EditText input, result;
    private boolean isLastAns = true;
    private Button clear;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.buttons_fragment, container, false);
        rootView.findViewById(R.id.button0).setOnClickListener(this);
        rootView.findViewById(R.id.button1).setOnClickListener(this);
        rootView.findViewById(R.id.button2).setOnClickListener(this);
        rootView.findViewById(R.id.button3).setOnClickListener(this);
        rootView.findViewById(R.id.button4).setOnClickListener(this);
        rootView.findViewById(R.id.button5).setOnClickListener(this);
        rootView.findViewById(R.id.button6).setOnClickListener(this);
        rootView.findViewById(R.id.button7).setOnClickListener(this);
        rootView.findViewById(R.id.button8).setOnClickListener(this);
        rootView.findViewById(R.id.button9).setOnClickListener(this);
        rootView.findViewById(R.id.button_dot).setOnClickListener(this);
        rootView.findViewById(R.id.button_perc).setOnClickListener(this);
        rootView.findViewById(R.id.button_sum).setOnClickListener(this);
        rootView.findViewById(R.id.button_sub).setOnClickListener(this);
        rootView.findViewById(R.id.button_mul).setOnClickListener(this);
        rootView.findViewById(R.id.button_div).setOnClickListener(this);
        rootView.findViewById(R.id.button_erase).setOnClickListener(this);
        rootView.findViewById(R.id.button_eq).setOnClickListener(this);
        rootView.findViewById(R.id.button_close_bracket).setOnClickListener(this);
        rootView.findViewById(R.id.button_open_bracket).setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        input = getActivity().findViewById(R.id.input);
        input.setSelection(input.getText().length());
        result = getActivity().findViewById(R.id.result);
        clear = getActivity().findViewById(R.id.button_erase);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                clear.setText(getResources().getString(R.string.backspace));
                isLastAns = false;
                String text = s.toString();
                text = text.replace('×','*').replace('÷','/').replace("log","log10");
                if (text.contains("sosi")){
                    result.setText("Do it yourself.");
                    return;
                }
                if (text.isEmpty()){
                    result.setText("");
                    return;
                }
                Expression exp = new Expression(text);
                String res = String.valueOf(exp.calculate());

                if (!res.equals("NaN")){
                    if (res.endsWith(".0")){
                        res = res.substring(0,res.length() - 2);
                    }
                    result.setText(res);
                }
                else result.setText("Error.");
            }
        });
    }

    private boolean isNeedMultiplyForNumber(String exp){
        return exp.endsWith(")") || exp.endsWith("pi") || exp.endsWith("e") || exp.endsWith("!") || exp.endsWith("%");
    }
    private boolean isNeedMultiply(String exp){
        return isNeedMultiplyForNumber(exp) || exp.endsWith("1")|| exp.endsWith("2")|| exp.endsWith("3")|| exp.endsWith("4")|| exp.endsWith("5")|| exp.endsWith("6")|| exp.endsWith("7") || exp.endsWith("8")|| exp.endsWith("9")|| exp.endsWith("0");
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.one));
                break;
            }
            case R.id.button2: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.two));
                break;
            }
            case R.id.button3: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.three));
                break;
            }
            case R.id.button4: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.four));
                break;
            }
            case R.id.button5: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.five));
                break;
            }
            case R.id.button6: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.six));
                break;
            }
            case R.id.button7: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.seven));
                break;
            }
            case R.id.button8: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.eight));
                break;
            }
            case R.id.button9: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.nine));
                break;
            }
            case R.id.button0: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.zero));
                break;
            }
            case R.id.button_close_bracket: {
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.close_bracket));
                break;
            }
            case R.id.button_open_bracket: {
                if (isNeedMultiply(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.open_bracket));
                break;
            }
            case R.id.button_dot: {
                if (isNeedMultiplyForNumber(input.getText().toString()))
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.dot));
                break;
            }
            case R.id.button_perc: {
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.percent));
                break;
            }
            case R.id.button_sum: {
                if (input.getText().length() != 0)
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.sum));
                break;
            }
            case R.id.button_sub: {
                input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.sub));
                break;
            }
            case R.id.button_mul: {
                if (input.getText().length() != 0)
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.mul));
                break;
            }
            case R.id.button_div: {
                if (input.getText().length() != 0)
                    input.getText().insert(input.getSelectionStart(), getResources().getString(R.string.div));
                break;
            }
            case R.id.button_eq: {
                if (result.getText().length() != 0) {
                    input.setText(result.getText().toString());
                    result.getText().clear();
                    input.setSelection(input.getText().length());
                    isLastAns = true;
                    clear.setText(getResources().getString(R.string.clear));
                }
                break;
            }
            case R.id.button_erase: {
                if (isLastAns){
                    input.getText().clear();
                    result.getText().clear();
                    break;
                }else {
                    CharSequence text = input.getText().toString();
                    int cursorPos = input.getSelectionEnd();
                    if (cursorPos != 0) {
                        CharSequence cursorToEnd = text.subSequence(cursorPos, text.length());
                        CharSequence startToCursor = text.subSequence(0, cursorPos);
                        startToCursor = startToCursor.subSequence(0, startToCursor.length() - 1);
                        text = startToCursor.toString() + cursorToEnd.toString();
                        input.setText(text);
                        if (cursorPos - 1 != 0)
                            input.setSelection(cursorPos - 1);
                        else input.setSelection(text.length());
                    }
                    break;
                }
            }

        }
    }
}
