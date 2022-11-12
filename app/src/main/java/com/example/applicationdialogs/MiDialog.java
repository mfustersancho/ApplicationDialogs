package com.example.applicationdialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

public class MiDialog extends DialogFragment {

    public interface NoticeDialogListener {
        public void onGetUser(String user, String password);
        public void onCancel();
    }

    NoticeDialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();

        View v = inflater.inflate(R.layout.mi_dialog, null);

        builder.setView(v);

        Button bIngresar = v.findViewById(R.id.bIngresar);
        Button bCancelar = v.findViewById(R.id.bCancelar);

        bIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView txtUserId = v.findViewById(R.id.txtUserId);
                TextView txtPassword = v.findViewById(R.id.txtPassword);
                String userId = txtUserId.getText().toString();
                String password = txtPassword.getText().toString();
                dismiss();
                listener.onGetUser(userId, password);
            }
        });

        bCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
                listener.onCancel();
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (NoticeDialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException("La clase no ha implementado la interfaz NoticeDialogListener");
        }
    }
}
