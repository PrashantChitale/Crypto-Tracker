package Crypto.Tracker.Crypto_Tracker.Response;

public class GetEmailRequest {

    String email;


    public GetEmailRequest(String email) {
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
