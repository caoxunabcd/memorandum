package com.example.app05.tool;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.app05.entity.Task;

/**
 * @author: cx
 * @date: 2022/5/1
 */
public class Tool {
    public static void onTtemClick(Context context, Class distination, Task task){
        //1.创建Intent对象（请求对象）
        Intent intent = new Intent();
        Bundle bundle=new Bundle();
        bundle.putSerializable("task", task);
        //2.设置目的地
        intent.setClass(context, distination);
        intent.putExtra("bundle", bundle);
        //3.传递自定义对象
        context.startActivity(intent);
    }
}
