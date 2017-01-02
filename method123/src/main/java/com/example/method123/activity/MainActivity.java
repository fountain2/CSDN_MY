package com.example.method123.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.method123.R;
import com.example.method123.user.Person;
import com.example.method123.util.BaseActivity;
import com.example.method123.util.MyApplication;
/*
*       Toast显示图片
*       隐藏标题栏
*       自定义布局并使用 title_layout
* */
public class MainActivity extends BaseActivity {
    private Button bt_1;
    private Button bt_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();//用该方法隐藏标题栏，因为当前extends AppCompatActivity

//        requestWindowFeature(Window.FEATURE_NO_TITLE);  //此方法是extends Activity时的隐藏方法
        setContentView(R.layout.activity_main);

        bt_1= (Button) findViewById(R.id.bt_1);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyApplication.getContext(),"You Click The bt1",Toast.LENGTH_SHORT).show();
                Person person=new Person("fountain","111");
                Intent mIntent=new Intent(MainActivity.this,SecondActivity.class);

//                前两种的写入数据操作
                mIntent.putExtra("person_data",person);


                startActivity(mIntent);
            }
        });

//        Toast显示图片
        bt_2= (Button) findViewById(R.id.bt_2);
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//               显示图片
//                Toast toast=new Toast(MainActivity.this);
//
//                ImageView imageView = new ImageView(MainActivity.this);//创建图片控件
//                imageView.setImageResource(R.drawable.ic_get_app_brown_400_48dp);//给控件设置图片
//
//                toast.setView(imageView);//把图片绑定到Toast上
//                toast.setDuration(Toast.LENGTH_LONG);//Toast显示的时间;
//                //设置图片显示的位置：三个参数
//                //第一个：位置，可以用|添加并列位置，第二个：相对于X的偏移量，第三个：相对于Y轴的偏移量
//                //注意一点：第二和第三个参数是相对于第一个参数设定的位置偏移的
//                toast.setGravity(Gravity.TOP|Gravity.RIGHT,0,100);
//                toast.show();//显示Toast

//             显示图片加文字
                Toast toast=new Toast(MainActivity.this);

                LinearLayout linearLayout=new LinearLayout(MainActivity.this);//创建线性布局
                linearLayout.setOrientation(LinearLayout.VERTICAL);//设置布局垂直

                ImageView imageView = new ImageView(getApplicationContext());//创建图片控件
                imageView.setImageResource(R.drawable.ic_get_app_brown_400_48dp);//给控件设置图片
                TextView textView = new TextView(getApplicationContext());//创建文本控件
                textView.setText("我是那张图片的TOAST");//设置文本内容

                linearLayout.addView(imageView);//添加图片控件到布局中
                linearLayout.addView(textView);//添加文本控件到布局中。注意添加顺序会影响图片在前还是为本在前

                toast.setView(linearLayout);//把布局绑定到Toast上
                toast.setDuration(Toast.LENGTH_LONG);//Toast显示的时间;
                //参数同前面
                toast.setGravity(Gravity.CENTER,-222,222);//第二个参数，正为向右偏移，第三个参数，正为向下偏移
                toast.show();//显示Toast
            }
        });
    }
}
