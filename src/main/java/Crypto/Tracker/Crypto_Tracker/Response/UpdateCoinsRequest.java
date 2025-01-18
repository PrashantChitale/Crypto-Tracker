package Crypto.Tracker.Crypto_Tracker.Response;

public class UpdateCoinsRequest {

    private String email;
    private String coins;


    public UpdateCoinsRequest() {
    }

    public UpdateCoinsRequest(String email, String coins) {
        this.email = email;
        this.coins = coins;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "UpdateCoinsRequest{" +
                "email='" + email + '\'' +
                ", coins='" + coins + '\'' +
                '}';
    }
}
