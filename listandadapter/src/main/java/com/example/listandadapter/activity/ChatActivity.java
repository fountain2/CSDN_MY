package com.example.listandadapter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.listandadapter.R;
import com.example.listandadapter.adapter.MyAdapter;
import com.example.listandadapter.example.Msg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fountian on 2017/1/1.
 *    自定义 MyAdapter
 *    创建 Msg类
 *    自定义布局 msg_item
 */
public class ChatActivity extends AppCompatActivity{
    private Button bt_send;
    private EditText ed_input;
    private ListView msg_list_chat;
    private MyAdapter adapter;
    private List<Msg> msgList=new ArrayList<Msg>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        ed_input= (EditText) findViewById(R.id.ed_input);
        bt_send= (Button) findViewById(R.id.bt_send);
        msg_list_chat= (ListView) findViewById(R.id.list_chat);

        initMsg();

        adapter=new MyAdapter(getApplicationContext(),R.layout.msg_item,msgList);
        msg_list_chat.setAdapter(adapter);
        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=ed_input.getText().toString();
                if (!"".equals(content)){
                    Msg msg=new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();//有消息就刷新msglist的显示
                    msg_list_chat.setSelection(msgList.size());//定位到最后一行
                    ed_input.setText("");
                }
            }
        });
    }

    private void initMsg() {
        Msg msg_1=new Msg("你好，我是fountain，为你服务！！！",Msg.TYPE_RECEIVED);
        msgList.add(msg_1);
        Msg msg_2=new Msg("初次见面，请多指教",Msg.TYPE_SEND);
        msgList.add(msg_2);
        Msg msg_3=new Msg("Meet to，你个瓜皮",Msg.TYPE_RECEIVED);
        msgList.add(msg_3);
    }
}
