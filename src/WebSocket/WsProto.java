package WebSocket;

import java.util.Objects;

public class WsProto {
    protected String action;
    protected String method;

    public void setAction(String action) {
        this.action = action;
    }
    public String getAction() {
        return action;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return "WsProto{" +
                "action='" + action + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WsProto wsProto = (WsProto) o;
        return Objects.equals(action, wsProto.action) && Objects.equals(method, wsProto.method);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, method);
    }
}
