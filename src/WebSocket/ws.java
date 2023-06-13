package WebSocket;

import Save.FileSaver;
import Save.DbSaver;
import Save.iSave;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;

import com.google.gson.*;

public class ws extends WebSocketServer {
    private iSave saver = null;

    public ws(int port, iSave saver){
        super(new InetSocketAddress(port));
        this.saver = saver;
    }


    @Override
    public void onOpen(WebSocket webSocket, ClientHandshake clientHandshake) {
        System.out.println("Новое соединение: " + webSocket.getRemoteSocketAddress());
    }

    @Override
    public void onClose(WebSocket webSocket, int i, String s, boolean b) {
        System.out.println("Соединение закрыто: " + webSocket.getRemoteSocketAddress());
    }

    @Override
    public void onMessage(WebSocket webSocket, String s) {
        System.out.println("Получено сообщение от " + webSocket.getRemoteSocketAddress() + ": " + s);
        Gson gson = new Gson();
        //WsProto msg = gson.fromJson(s, WsProto.class);
        WsProto message = gson.fromJson(s, WsProto.class);

        if(message.getAction().equals("connect")){

            if(message.getMethod().equals("db")){
                try {
                    saver = (iSave) new DbSaver();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(message.getMethod().equals("file")){
                try {
                    saver = (iSave) new FileSaver();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                String jsonInString = gson.toJson(saver.getAll());
                System.out.println(jsonInString);
                webSocket.send(jsonInString);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(message);
        //webSocket.send("Сообщение: " + s);

    }

    @Override
    public void onError(WebSocket webSocket, Exception e) {
        System.out.println("Произошла ошибка на соединении " + webSocket.getRemoteSocketAddress() + ": " + e.getMessage());
    }

    @Override
    public void onStart() {
        System.out.println("On start");
    }
}
