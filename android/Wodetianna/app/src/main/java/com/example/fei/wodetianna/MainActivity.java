package com.example.fei.wodetianna;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity{
    // 定义界面上的两个文本框
    EditText input;
    TextView show;
    // 定义界面上的一个按钮
    Button send;
    Handler handler;
    // 定义与服务器通信的子线程
    ClientThread clientThread;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        input = (EditText) findViewById(R.id.input);
        send = (Button) findViewById(R.id.send);
        show = (TextView) findViewById(R.id.show);

        handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg)
            {
                // 如果消息来自于子线程
                switch (msg.what){
                    case 0x123:
                        show.append("\nww: " + msg.obj.toString());
                        break;
//                    case 0x345:
//                        //show.append("\ncc: " + msg.obj.toString());
//                        Bundle bundle = msg.getData();
//                        show.append("\ncc:"+bundle.getString("msg"));
//                        break;
                    default:
                        break;
                }
//                if (msg.what == 0x123)
//                {
//                    // 将读取的内容追加显示在文本框中
//                    show.append("\nww: " + msg.obj.toString());
//                }
            }
        };
        clientThread = new ClientThread(handler);

        // 客户端启动ClientThread线程创建网络连接、读取来自服务器的数据
        new Thread(clientThread).start();

        send.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                try
                {
                    // 当用户按下发送按钮后，将用户输入的数据封装成Message，
                    // 然后发送给子线程的Handler
                    Message msg = new Message();
                    msg.what = 0x345;
                    msg.obj = input.getText().toString();
                    clientThread.revHandler.sendMessage(msg);
                    //handler.sendMessage(msg);
                    // 清空input文本框
                    input.setText("");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
}


//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.Socket;
//import java.net.UnknownHostException;
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout);
//    }
//
//    class MyThread implements Runnable{
//
//        @Override
//        public void run() {
//            try {
//                RequestSocket("192.168.232.115",30000);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        private Socket RequestSocket (String host,int port) throws UnknownHostException,IOException{
//            Socket socket = new Socket(host, port);
//            return socket;
//        }
//        //客户端发送消息
//        private void SendMsg (Socket socket,String msg)throws IOException{
//            //将要发送的数据写入Buffer中
//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            //格式转换
//            writer.write(msg.replace("\n"," ")+"\n");
//            //刷新，重新发送
//            writer.flush();
//        }
//        //客户端接收消息
//        private String ReceiveMsg(Socket socket)throws IOException{
//            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            //读取消息到字符串中
//            String msg = reader.readLine();
//            return msg;
//        }
//    }
//}
