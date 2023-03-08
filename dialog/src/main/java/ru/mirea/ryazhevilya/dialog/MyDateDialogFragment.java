package ru.mirea.ryazhevilya.dialog;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Random;

public class MyDateDialogFragment extends DatePickerDialog {
    private int randomDay;
    private int randomMonth;


    OnDateSetListener listener = new OnDateSetListener() {
        String chooseDifference;
        @SuppressLint("DefaultLocale")
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            int chosenDay = view.getDayOfMonth();
            int chosenMonth = view.getMonth();
            if(chosenMonth != randomMonth){
                chooseDifference = String.format("Wrong! The difference between months is: %d", Math.abs(chosenMonth - randomMonth));
            }
            else{
                chooseDifference = "Month is correct!";
                if(chosenDay != randomDay){
                    chooseDifference += String.format("But the difference between days is %d", Math.abs(chosenDay - randomDay));

                }
                else chooseDifference += "And the day is right too! You won nothing! It was a lie!";
            }
            Toast.makeText(getContext(), chooseDifference, Toast.LENGTH_LONG).show();
        }
    };


    public MyDateDialogFragment(@NonNull Context context) {
        super(context);
        Random rnd = new Random();
        randomDay = rnd.nextInt(30) + 1;
        randomMonth = rnd.nextInt(12) + 1;
        setOnDateSetListener(listener);
        setTitle("Guess the month and day and win 1000000 dollars!");
    }

    public MyDateDialogFragment(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public MyDateDialogFragment(@NonNull Context context, @Nullable OnDateSetListener listener, int year, int month, int dayOfMonth) {
        super(context, listener, year, month, dayOfMonth);
    }

    public MyDateDialogFragment(@NonNull Context context, int themeResId, @Nullable OnDateSetListener listener, int year, int monthOfYear, int dayOfMonth) {
        super(context, themeResId, listener, year, monthOfYear, dayOfMonth);
    }
}
