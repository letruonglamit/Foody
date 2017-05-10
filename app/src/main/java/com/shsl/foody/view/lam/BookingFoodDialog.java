package com.shsl.foody.view.lam;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import com.shsl.foody.R;

public class DialogEditVisaDialog extends DialogFragment implements OnEditorActionListener, View.OnClickListener {
    private static final String TAG = "TEST";

    private TextView title;
    private EditText mEditText;
    private Button btnCancel, btnOK;
    private EditVisaDialogListener mListener;
    private String strTitle;
    public DialogEditVisaDialog(String title){
        this.strTitle = title;

    }
    public void setListener(EditVisaDialogListener mListener) {
        this.mListener = mListener;
    }

    public interface EditVisaDialogListener {
        void onFinishEditDialog(String inputText);
    }

    @Override
    public View onCreateView(LayoutInflater inflater
            , ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_visa, container);
        title = (TextView) view.findViewById(R.id.tv_title_dialog);
        title.setText(strTitle);
        btnCancel = (Button) view.findViewById(R.id.btn_cancel);
        btnOK = (Button) view.findViewById(R.id.btn_ok);
        mEditText = (EditText) view.findViewById(R.id.txt_your_name);

        /**
         * Establish keyboard
         */
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        mEditText.setOnEditorActionListener(this);

        btnCancel.setOnClickListener(this);
        btnOK.setOnClickListener(this);
        return view;
    }

    @Override
    public boolean onEditorAction(TextView view,
                                  int actionId, KeyEvent event) {
        /**
         * Cash event when user click Done
         */
        this.dismiss();
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            if (mListener != null) {
                mListener.onFinishEditDialog(mEditText.getText().toString());
            }
            this.dismiss();
            return true;
        }
        return false;
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_ok:
                mListener.onFinishEditDialog(mEditText.getText().toString());
            case R.id.btn_cancel:
            default:
                this.dismiss();
        }
        //this.dismiss();
    }
}



