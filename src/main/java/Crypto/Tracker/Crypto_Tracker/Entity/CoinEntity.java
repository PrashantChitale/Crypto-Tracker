package Crypto.Tracker.Crypto_Tracker.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "coins")
public class CoinEntity {

    @Id
    private String userId;
    private String coins;


    public CoinEntity() {
    }

    public CoinEntity(String userId, String coins) {
        this.userId = userId;
        this.coins = coins;
    }

    public CoinEntity(String email) {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "CoinEntity{" +
                "userId='" + userId + '\'' +
                ", coins='" + coins + '\'' +
                '}';
    }
}
