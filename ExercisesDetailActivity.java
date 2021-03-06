package com.example.choosedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExercisesDetailActivity extends AppCompatActivity {
    private ListView lv_list;
    private String title;
    private int id;
    private List<ExerciseBean> ebl;
    private  ExercisesDetailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises_detail);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        id=getIntent().getIntExtra("id",0);
        title=getIntent().getStringExtra("title");
        ebl=new ArrayList<ExerciseBean>();
        initData();
        init();
    }
    private void initData(){
        try{
            InputStream is=getResources().getAssets().open("chapter"+id+".xml");
            ebl= AnalysisUtils.getExerciseInfos(is);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private  void init(){

        lv_list=(ListView)findViewById(R.id.lv_list);
        TextView tv=new TextView(this);
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setTextSize(16.0f);
        tv.setText("choose,1");
        tv.setPadding(10,15,0,0);
        lv_list.addHeaderView(tv);

        adapter=new ExercisesDetailAdapter(ExercisesDetailActivity.this, new ExercisesDetailAdapter.OnSelectListener() {
            @Override
            public void onSelectD(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d) {
                if(ebl.get(position).answer!=4){
                    ebl.get(position).select=4;
                } else {
                    ebl.get(position).select=0;
                }
                switch (ebl.get(position).answer){
                    case 1:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        iv_d.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 2:
                        iv_d.setImageResource(R.drawable.exercises_error_icon);
                        iv_b.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 3:
                        iv_d.setImageResource(R.drawable.exercises_error_icon);
                        iv_c.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 4:
                        iv_d.setImageResource(R.drawable.exercises_right_icon);
                        break;
                }
                AnalysisUtils.setABCDEnable(false, iv_a, iv_b, iv_c, iv_d);
            }

            @Override
            public void onSelectC(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d) {
                if (ebl.get(position).answer != 3) {
                    ebl.get(position).select = 3;
                } else {
                    ebl.get(position).select = 0;
                }
                switch (ebl.get(position).answer) {
                    case 1:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        iv_c.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 2:
                        iv_b.setImageResource(R.drawable.exercises_right_icon);
                        iv_c.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 3:

                        iv_c.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 4:
                        iv_c.setImageResource(R.drawable.exercises_error_icon);
                        iv_d.setImageResource(R.drawable.exercises_right_icon);
                }
                AnalysisUtils.setABCDEnable(false, iv_a, iv_b, iv_c, iv_d);

            }




            @Override
            public void onSelectB(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d) {
                if (ebl.get(position).answer != 2) {
                    ebl.get(position).select = 2;
                } else {
                    ebl.get(position).select = 0;

                }
                switch (ebl.get(position).answer) {
                    case 1:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        iv_b.setImageResource(R.drawable.exercises_error_icon);
                        break;
                    case 2:

                        iv_b.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 3:
                        iv_b.setImageResource(R.drawable.exercises_error_icon);
                        iv_c.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 4:
                        iv_b.setImageResource(R.drawable.exercises_error_icon);
                        iv_d.setImageResource(R.drawable.exercises_right_icon);
                        break;
                }
                AnalysisUtils.setABCDEnable(false, iv_a, iv_b, iv_c, iv_d);

            }

            @Override
            public void onSelectA(int position, ImageView iv_a, ImageView iv_b, ImageView iv_c, ImageView iv_d) {
                if (ebl.get(position).answer != 1) {
                    ebl.get(position).select = 1;
                } else {
                    ebl.get(position).select = 0;

                }
                switch (ebl.get(position).answer) {
                    case 1:
                        iv_a.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 2:
                        iv_a.setImageResource(R.drawable.exercises_error_icon);
                        iv_b.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 3:
                        iv_a.setImageResource(R.drawable.exercises_error_icon);
                        iv_c.setImageResource(R.drawable.exercises_right_icon);
                        break;
                    case 4:
                        iv_a.setImageResource(R.drawable.exercises_error_icon);
                        iv_d.setImageResource(R.drawable.exercises_right_icon);
                        break;
                }
                AnalysisUtils.setABCDEnable(false, iv_a, iv_b, iv_c, iv_d);

            }
        });
        adapter.setData(ebl);
        lv_list.setAdapter(adapter);
    }

}