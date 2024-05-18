package exception.ex0;

public class NetworkClientV0 {

    private final String address;

    public NetworkClientV0(String address) {
        this.address = address;
    }

    public String connect() {
        System.out.println(address+ " is connected");
        return "Success";
    }

    public String send(String message) {
        System.out.println(address+ " is sending " + message);
        return "Success";
    }

    public void disconnect() {
        System.out.println(address+ " is disconnected");
    }
}
