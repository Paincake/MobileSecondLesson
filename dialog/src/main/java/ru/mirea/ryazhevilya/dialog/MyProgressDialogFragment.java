package ru.mirea.ryazhevilya.dialog;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.textclassifier.ConversationActions;
import android.widget.Toast;


public class MyProgressDialogFragment extends ProgressDialog {


    public MyProgressDialogFragment(Context context) {
        super(context);

    }

    public MyProgressDialogFragment(Context context, int theme) {
        super(context, theme);
    }
}
