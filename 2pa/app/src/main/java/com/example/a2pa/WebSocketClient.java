package com.example.a2pa;
import android.widget.TextView;
import android.content.Context;
import androidx.viewpager.widget.ViewPager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
public class WebSocketClient extends WebSocketListener{
    private Context context;
    private TextView textView;
    private ViewPager viewPager;
    private String selectedValue;

    private static final String WEBSOCKET_URL = "http://192.168.127.222:8080";
    private WebSocket webSocket;
    public WebSocketClient(Context context, TextView textView, ViewPager viewPager, String selectedValue) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(WEBSOCKET_URL)
                .build();
        this.context = context;
        this.textView = textView;
        this.viewPager = viewPager;
        this.selectedValue = selectedValue;
        WebSocketListener socketListener = new WebSocketListener() {
            @Override
            public void onOpen(WebSocket webSocket, Response response) {
                webSocket.send("{\"action\": \"connect\", \"method\": \""+selectedValue+"\"}");
            }

            @Override
            public void onMessage(WebSocket webSocket, String text) {
                ((Main) context).onWebSocketMessageReceived(text);
                viewPager.setCurrentItem(1);
                System.out.println("---------------------------------==text! "+text);
            }

            @Override
            public void onMessage(WebSocket webSocket, ByteString bytes) {
            }

            @Override
            public void onClosed(WebSocket webSocket, int code, String reason) {
            }

            @Override
            public void onFailure(WebSocket webSocket, Throwable t, Response response) {
                System.out.println("---------------------------------==Ошибка! "+t);
            }
        };
        webSocket = client.newWebSocket(request, socketListener);
    }

    public void stop() {
        if (webSocket != null) {
            webSocket.cancel();
        }
    }
}
