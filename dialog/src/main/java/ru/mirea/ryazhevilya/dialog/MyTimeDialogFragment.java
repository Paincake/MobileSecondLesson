package ru.mirea.ryazhevilya.dialog;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;


public class MyTimeDialogFragment extends TimePickerDialog {


    public MyTimeDialogFragment(Context context, OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView, View view) {
        super(context, listener, hourOfDay, minute, is24HourView);
        setMessage("Set the time on the wheel below.");
        setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Snackbar bar = Snackbar.make(view, "Time has not been set", Snackbar.LENGTH_LONG);
                bar.setAction("Try again", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show();
                    }
                });
                bar.show();
                cancel();
            }
        });

    }

    public MyTimeDialogFragment(Context context, int themeResId, OnTimeSetListener listener, int hourOfDay, int minute, boolean is24HourView) {
        super(context, themeResId, listener, hourOfDay, minute, is24HourView);
    }
}
