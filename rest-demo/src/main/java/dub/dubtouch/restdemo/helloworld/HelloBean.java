package dub.dubtouch.restdemo.helloworld;

public class HelloBean {
    String message;
    public HelloBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
