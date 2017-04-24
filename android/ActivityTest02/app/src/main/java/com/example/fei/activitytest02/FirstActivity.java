package com.example.fei.activitytest02;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.ProgressDialog.*;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Administrator on 2017/4/14.
 */

public class FirstActivity extends Activity{
    private static final int UPDATE_TEXT = 0x666;
    private static final int CHANGE = 0x333;
    private TextView text;
    private Button button_1;
    private Button change_text;
    private Button download;
    private Handler handler;
    private Menu menu;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        text = (TextView)findViewById(R.id.text);
        button_1 = (Button)findViewById(R.id.button_1);
        change_text = (Button)findViewById(R.id.change_text);
        download = (Button)findViewById(R.id.download);

        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        new DownloadTask().execute();
                    }
                });
            }
        });


        handler = new Handler(){
            public void handleMessage(Message msg){
                switch(msg.what) {
                    case UPDATE_TEXT:
                        text.setText("Nice to meet you");
                        break;
                    default:
                        break;
                }
            }
        };


        button_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        change_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.change_text:
                        new Thread(new Runnable(){
                            @Override
                            public void run() {
                                Message message = new Message();
                                message.what = UPDATE_TEXT;
                                handler.sendMessage(message);
                            }
                        }).start();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    class DownloadTask extends AsyncTask<Void,Integer,Boolean>{
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute(){
            //progressDialog = new ProgressDialog(this);
            progressDialog.show();
        }
        @Override
        protected Boolean doInBackground(Void... params) {
            try{
                while(true){
                    int downloadPercent = doDownload();//这是一个虚构的方法
                    publishProgress(downloadPercent);
                    if(downloadPercent>=100){
                        break;
                    }
                }
            }catch (Exception e){
                return false;
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            //在这里显示下载进度
            progressDialog.setMessage("Download "+values[0]+"%");
        }
        @Override
        protected void onPostExecute(Boolean result){
            progressDialog.dismiss();//关闭进度对话框
            Context context = null;
            //在这里显示下载结果
            if(result){
                Toast.makeText(context,"Download succeeded",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context,"Download Failed",Toast.LENGTH_LONG).show();
            }
        }
        private int doDownload() {
            return 1;
        }
    }

    //创建菜单项
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    //定义菜单响应事件
    public boolean onOptionsItemSelect(MenuItem item){
        switch(item.getItemId()){
            case R.id.remove_item:
                Toast.makeText(this,"you clicked remove",Toast.LENGTH_LONG).show();
                break;
            case R.id.add_item:
                Toast.makeText(this,"you clicked add",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }














    /*
    public static final int UPDATE_TEXT = 0x111;
    private TextView text;
    private Button changeText;
    private Button button1;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        button1 = (Button) findViewById(R.id.button_1);
        changeText = (Button)findViewById(R.id.change_text);
        text = (TextView)findViewById(R.id.text);

        handler = new Handler(){
            public void handleMessage(Message msg){
                switch (msg.what){
                    case UPDATE_TEXT:
                        text.setText("Nice to meet you");
                        break;
                    default:
                        break;
                }
            }
        };

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.change_text:
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                Message message = new Message();
                                message.what = UPDATE_TEXT;
                                handler.sendMessage(message);
                            }
                        }).start();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    //定义菜单响应事件
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

*/

}
