/*
* 每次使用完之后都无法再次重新安装，除非卸载掉
* */
package com.example.changeicon;

import android.app.Activity;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
//    private ComponentName mDefault;
//    private ComponentName mBouble;
//    private PackageManager mpm;
    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //动态修改App的icon mainfest中设置<activity-alias>
//        mDefault=getComponentName();
//        mBouble=new ComponentName(getBaseContext(),"com.example.fountian.csdn_my_code.Test1");
//        mpm=getApplicationContext().getPackageManager();

        bt1= (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeIcon();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.apple_1:
                Toast.makeText(this,"apple1 was clicked",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.apple_2:
                Toast.makeText(this,"apple2 was clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.apple_3:
                Toast.makeText(this,"apple3 was clicked",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void changeIcon() {
        PackageManager pm = getApplicationContext().getPackageManager();
        System.out.println(getComponentName());
        //去除旧图标，不去除的话会出现2个App图标
        pm.setComponentEnabledSetting(getComponentName(),
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
        //显示新图标
        pm.setComponentEnabledSetting(new ComponentName(
                        getBaseContext(),
                        "com.example.changeicon.SecondActivity"),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }



//    private void enableComponent(ComponentName componentName){
//        mpm.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
//                PackageManager.DONT_KILL_APP);
//    }
//    private void disableComponent(ComponentName componentName){
//        mpm.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
//                PackageManager.DONT_KILL_APP);
//    }
//
//    public void changeIcon(){
////        disableComponent(mDefault);
////        enableComponent(mBouble);
//
//        enableComponent(mDefault);
//        disableComponent(mBouble);
//    }
}
