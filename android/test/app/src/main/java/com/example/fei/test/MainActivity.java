package com.example.fei.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private EditText editText;
    private Button button;
    // 输出流
    private BufferedReader in;
    // 输入流
//	private BufferedWriter out;
    //输入流
//	private InputStream in;
    //输出流
    private OutputStream out;
    // 客户端socket
    private Socket socket;
    //数据流
    DataOutputStream dataOutputStream;
    //字节数组
    ByteArrayOutputStream byteArrayOutputStream;

    // 显示数据
    private TextView textView;
    // 用来存放要传递给客户端的数据
    private static String data;
    //handler发送处理消息
    private Handler handler;
    private String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.socket_layout);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.send);
        textView = (TextView) findViewById(R.id.textView);
        //设置textView可以滚动
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());


        handler = new Handler(new Handler.Callback() {

            @Override
            public boolean handleMessage(Message msg) {
                if(msg.what == 0x1314)
                {
                    textView.append("服务器：" + b + '\n');
                }
                return true;
            }
        });

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    socket = new Socket("192.168.232.115", 30000);
                    Log.e("--->", "已发出链接请求");
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    //out = socket.getOutputStream();
                    while (socket != null) {

                        b = in.readLine();
//							textView.append("服务器：" + b + '\n');
                        handler.sendEmptyMessage(0x1314);

                    }


                } catch (UnknownHostException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                data = editText.getText().toString();
                textView.append("客户端说：" + data + '\n');
                editText.setText("");
                //BufferedWriter bufferedWriter = null;
                BufferedReader bufferedReader = null;
                try {
                    if (socket != null) {
                        out = socket.getOutputStream();
                        out.write((data + '\n').getBytes("GBK"));
                        //out.flush();
                        //bufferedWriter = new BufferedWriter(new OutputStreamWriter(out));
                        //bufferedWriter.flush();
                    }
                    else
                        Log.e("--->", "服务器未连接，无法获得输出流");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally
                {
                    try {
                        out.close();
                        //dataOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //每当有菜单项被点击时，android就会调用该方法，并传入被点击菜单项
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}