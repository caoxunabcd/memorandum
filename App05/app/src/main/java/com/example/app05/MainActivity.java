package com.example.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.app05.activity.DetailsActivity;
import com.example.app05.adapter.TaskAdapter;
import com.example.app05.entity.Task;
import com.example.app05.tool.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cx
 * @date: 2022/5/1
 */
public class MainActivity extends AppCompatActivity {
    private List<Task> taskList = new ArrayList<>();
    private TaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void initView(){
        taskAdapter = new TaskAdapter(this,taskList,R.layout.task);
        ListView taskListView = findViewById(R.id.tl_list);
        taskListView.setAdapter(taskAdapter);
        taskListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.e("任务标题",taskList.get(i).getTopic());
                Tool.onTtemClick(MainActivity.this, DetailsActivity.class,taskList.get(i));
            }
        });
    }
}