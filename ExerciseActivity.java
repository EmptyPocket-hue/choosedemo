package com.example.choosedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ExerciseActivity extends AppCompatActivity {

    private ListView lv_list;
    private ExerciseAdapter adapter;
    private List<ExerciseBean>ebl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        initData();

        lv_list=(ListView)findViewById(R.id.lv_list);
        adapter=new ExerciseAdapter(this);
        adapter.setData(ebl);
        lv_list.setAdapter(adapter);

    }

    private void initData(){
        ebl=new ArrayList<ExerciseBean>();
        for(int i=0; i<10; i++){
            ExerciseBean bean=new ExerciseBean();
            bean.id=(i+1);
            switch (i){
                case 0:
                    bean.title="Chapter 1";
                    bean.content="5 questions";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 1:
                    bean.title="Chapter 2";
                    bean.content="6 questions";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                case 2:
                    bean.title="Chapter 3";
                    bean.content="7 questions";
                    bean.background=(R.drawable.exercises_bg_3);
                    break;
                case 3:
                    bean.title="Chapter 4";
                    bean.content="3 question";
                    bean.background=(R.drawable.exercises_bg_4);
                    break;
                case 4:
                    bean.title="Chapter 5";
                    bean.content="8 question";
                    bean.background=(R.drawable.exercises_bg_1);
                    break;
                case 5:
                    bean.title="Chapter 6";
                    bean.content="9 questions";
                    bean.background=(R.drawable.exercises_bg_2);
                    break;
                case 6:
                    bean.title="Chapter 7";
                    bean.content="10 questions";
                    bean.background=(R.drawable.exercises_bg_3);
                    break;
                default:
                    break;
            }
            ebl.add(bean);
        }
    }
}