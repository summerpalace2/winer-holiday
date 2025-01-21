package com.example.once2.Model.Json;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
//网络请求过程
//server(网络)->HttpURLConnection->获取输入流inputStream(二进制)->inputStreamReader(加工包装)->BufferedReader(数据储存池)->StringBuilder(一点点读取数据)—>给接收者即handler->在Gson解析Json数据并传到实体类->绑定数据
//get请求
// 1 http://+ 2 www....+ 3 /free/day+?+ 4 city_id=1010&...{最后没有&这是为什么要“减一”的原因}
//   1 scheme 2 host(域名):端口 3 path(路径) 4 query(条件)
//post 1+2+3+加键值对
public class Network {

    public static String StreamToString(InputStream in)
    {
        StringBuilder sb = new StringBuilder();
        String Line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            while ((Line = reader.readLine()) != null) {
                sb.append(Line);
                sb.append('\n');

            }
           if(sb.length()==0) {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public static void sendPostRequest(String mUrl,HashMap<String,String> params,Handler handler)
    {
        //lambda表达式，相当于其中new Runnable 并且重写⽅法
        new Thread(() -> {

            try {

                URL url = new URL(mUrl);
                //设置连接信息
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("POST");//设置请求⽅式为Post
                connection.setConnectTimeout(15000);//设置最⼤连接时间，单位为ms
                connection.setReadTimeout(15000);//设置最⼤的读取时间，单位为ms
                //设置后可以向服务端输出内容
                //因为默认是flase所以要设置，但是setDointput是默认true所以不用设置
                connection.setDoOutput(true);
                //优先接受中文zh-CN
                connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                StringBuilder dataToWrite = new StringBuilder();
                for (String key : params.keySet())
                {
                    dataToWrite.append(key).append("=").append(params.get(key)).append("&");
                    //append(key)获取遍历时的键 ，append(params.get(key))获取键对应的值
                    //.getBytes()：
                    //由于 OutputStream 的 write 方法需要以字节数组作为输入，因此调用 getBytes() 方法将截取后的字符串转换为字节数组。它会将字符串按照系统默认的字符编码（通常是 UTF-8）将字符串中的字符转换为对应的字节序列。
                }
                connection.setRequestProperty("Content-Length",String.valueOf(dataToWrite.length()-1));
                connection.connect();
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(dataToWrite.substring(0, dataToWrite.length() - 1).getBytes());
                //substring(0, dataToWrite.length() - 1)去最后的&
                InputStream in = connection.getInputStream();//从接⼝处获取
                String responseData = StreamToString(in);//这⾥就是服务器返回的数据
                Message message = new Message();
                message.what = 2;
                message.obj = responseData;
                handler.sendMessage(message);
                Log.d("Get", "sendGetNetRequest: " + responseData);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();

    }
//无参Get请求
    public static void sendGetRequest(String mUrl1,Handler handler)
    {
        //lambda表达式，相当于其中new Runnable 并且重写⽅法
        new Thread(() -> {

            try {
                Looper.prepare();
                URL url = new URL(mUrl1);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("Get");//设置请求⽅式为Get
                connection.setConnectTimeout(15000);//设置最⼤连接时间，单位为ms
                connection.setReadTimeout(15000);//设置最⼤的读取时间，单位为ms
                connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
                connection.setRequestProperty("Accept-Encoding", "gzip,deflate");
                StringBuilder dataToWrite = new StringBuilder();
                InputStream in = connection.getInputStream();//从接⼝处获取
                String responseData = StreamToString(in);//这⾥就是服务器返回的数据
                Message message = new Message();
                message.what = 1;
                message.obj = responseData;
                handler.sendMessage(message);
                Log.d("Post", "sendGetNetRequest: " + responseData);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Looper.loop();
        }).start();

    }
    //有参数的Get即根据业务增加条件
    public static void sendGetRequset(String mUrl1,Handler handler,HashMap<String,String> params)
    {
        StringBuilder stringBuilder = new StringBuilder(mUrl1).append("?");//Get请求中有一个问号
        for (String key : params.keySet()) {
            stringBuilder.append(key).append("=").append(params.get(key)).append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);//删除最后一个&
        sendGetRequest(stringBuilder.toString(),handler);
    }

}

