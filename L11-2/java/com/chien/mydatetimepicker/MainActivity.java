package com.chien.mydatetimepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button btn_date, btn_time;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        show = findViewById(R.id.txtResult);
        btn_date = findViewById(R.id.btnDateDlg);
        btn_time = findViewById(R.id.btnTimeDlg);

        btn_date.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(
                        context,
                        datePicker, //自訂物件
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dialog.setTitle("日期");
                dialog.setMessage("請設定日期 : ");
                dialog.setIcon(android.R.drawable.ic_lock_idle_alarm);
                dialog.setCancelable(true);
                dialog.show();
            }
        });

        btn_time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Calendar now2 = Calendar.getInstance();
                TimePickerDialog dialog2 = new TimePickerDialog(
                        context,
                        timePicker, //自訂物件
                        now2.get(Calendar.HOUR_OF_DAY),
                        now2.get(Calendar.MINUTE),
                        true
                );
                dialog2.setTitle("時間");
                dialog2.setMessage("請設定時間 : ");
                dialog2.setIcon(android.R.drawable.ic_lock_idle_alarm);
                dialog2.setCancelable(true);
                dialog2.show();
            }
        });
    }

    //監聽器datePicker 物件 記得要寫在 onCreate 外面
    DatePickerDialog.OnDateSetListener datePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            show.setText("設定日期是 : " + year + " 年 " + (month+1) + " 月 " + dayOfMonth + " 日 ");
        }
    };

    //TimePickerDialog 監聽物件 timePicker
    TimePickerDialog.OnTimeSetListener timePicker = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            show.setText("設定時間是 : " + hour + " 點 " + minute + " 分 ");
        }
    };
}