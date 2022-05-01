package com.example.app05.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.app05.R;
import com.example.app05.entity.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cx
 * @date: 2022/5/1
 */
public class TaskAdapter extends BaseAdapter {
    private Context mContext;
    private List<Task> taskList = new ArrayList<>();
    private int itemLayoutRes;
    public TaskAdapter(Context mContext, List<Task> taskList, int itemLayoutRes){
        this.mContext = mContext;
        this.taskList = taskList;
        this.itemLayoutRes = itemLayoutRes;
    }
    @Override
    public int getCount() {
        if (null != taskList){
            return taskList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        if(null != taskList){
            return taskList.get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(null == view){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            view = inflater.inflate(itemLayoutRes,null);
        }
        TextView taskView = view.findViewById(R.id.tv_text);
        TextView topic = view.findViewById(R.id.t_topic);
        TextView doTime = view.findViewById(R.id.t_time);
        taskView.setText("任务");
        topic.setText(taskList.get(i).getTopic());
        doTime.setText(taskList.get(i).getDoTime());
        return view;
    }
}
