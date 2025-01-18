package Crypto.Tracker.Crypto_Tracker.Entity;


import Crypto.Tracker.Crypto_Tracker.Response.CreateCryptoRequest;
import jakarta.persistence.*;



@Entity
@Table(name = "user")
public class CryptoEntity {

    @Id
    private String email;
    private String name;
    private String password;


    @OneToOne(cascade = CascadeType.ALL)
    private CoinEntity coinEntity;



    public CoinEntity getCoinEntity() {
        return coinEntity;
    }

    public void setCoinEntity(CoinEntity coinEntity) {
        this.coinEntity = coinEntity;
    }



    public CryptoEntity(CreateCryptoRequest createCryptoRequest) {
        this.name = createCryptoRequest.getName();
        this.password = createCryptoRequest.getPassword();
        this.email = createCryptoRequest.getEmail();
    }

    public CryptoEntity() {
    }

    public CryptoEntity( String name, String password, String email) {

        this.name = name;
        this.password = password;
        this.email = email;
    }



    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CryptoEntity{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", coinEntity=" + coinEntity +
                '}';
    }
}
