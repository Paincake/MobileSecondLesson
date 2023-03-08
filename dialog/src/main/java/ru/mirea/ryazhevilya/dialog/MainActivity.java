package ru.mirea.ryazhevilya.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowDestinyDialog(View view){
        DestinyDialogFragment dialogFragment = new DestinyDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "Destiny 2");
    }

    public void onOkClicked(){
        Toast.makeText(getApplicationContext(), "You rated 12/10!", Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked(){
        Toast.makeText(getApplicationContext(), "You rated 10/10!", Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked(){
        Toast.makeText(getApplicationContext(), "You rated 11/10!", Toast.LENGTH_LONG).show();
    }

    public void callSnackBar(View view) {
        Snackbar snackbar = Snackbar.make(view, "Congrats! I stole all your money.", Snackbar.LENGTH_LONG);
        snackbar.setAction("Get it back...", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Nah, it's mine!", Toast.LENGTH_LONG).show();
            }
        });
        snackbar.show();
    }

    public void onClickShowTimePickDialog(View view) {
        MyTimeDialogFragment customTimeDialog = new MyTimeDialogFragment(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
            Snackbar timeSetBar = Snackbar.make(view, "Time has been set", Snackbar.LENGTH_LONG);
            @SuppressLint("DefaultLocale")
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                view.setHour(hourOfDay);
                view.setMinute(minute);

                timeSetBar.setAction("Send info", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "some time that i set");
                        shareIntent.putExtra(Intent.EXTRA_TEXT, String.format("Hour set: %d \nMinute set: %d", view.getHour(), view.getMinute()));
                        startActivity(Intent.createChooser(shareIntent, "TIME SET BY TIMEPICKER"));
                    }
                });

                Log.d("TimeDialog", "TIME SET");
                timeSetBar.show();
            }
        },1, 1, true, view);
        customTimeDialog.show();
    }

    public void onClickShowDatePickDialog(View view) {
        MyDateDialogFragment customDateDialog = new MyDateDialogFragment(MainActivity.this);
        customDateDialog.show();
    }

    public void onClickShowProgressDialog(View view) {
        MyProgressDialogFragment customProgressDialog = new MyProgressDialogFragment(MainActivity.this, 3);
        customProgressDialog.setTitle("Downloading Destiny 2...Wait for 2 years...");
        customProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Toast.makeText(MainActivity.this, "Download has been interrupted!", Toast.LENGTH_LONG).show();
            }
        });

//        customProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//            @Override
//            public void onDismiss(DialogInterface dialog) {
//                Toast.makeText(MainActivity.this, "Download has been finished!", Toast.LENGTH_LONG).show();
//            }
//        });
        customProgressDialog.show();
        Thread progressThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                customProgressDialog.dismiss();
            }
        });
        progressThread.start();
    }
}