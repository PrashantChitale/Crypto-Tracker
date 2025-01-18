package Crypto.Tracker.Crypto_Tracker.Controller;


import Crypto.Tracker.Crypto_Tracker.Entity.CryptoEntity;
import Crypto.Tracker.Crypto_Tracker.Response.*;
import Crypto.Tracker.Crypto_Tracker.Services.CryptoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("api/crypto/v1")
public class CryptoController {

    @Autowired
    CryptoServices cryptoServices;


    //get All users in present the database
    @GetMapping("/getAll")
    public List<CryptoResponse> getAllRecords() {

        List<CryptoEntity> userInfo = cryptoServices.getAllRecords();

        List<CryptoResponse> cryptoResponse = new ArrayList<CryptoResponse>();

        userInfo.forEach(user -> {
            cryptoResponse.add(new CryptoResponse(user));
        });

        return cryptoResponse;
    }

// this is get the all user information userName and UserId
    @PostMapping("/getUserInfo")
    public CryptoResponse getUserInfo(@RequestBody GetEmailRequest getEmailRequest){

        return new CryptoResponse(cryptoServices.getUserInfo(getEmailRequest));
    }


    // this is only return the all coins
    @PostMapping("/getAllCoins")
    public List<String> getAllCoins(@RequestBody GetEmailRequest getEmailRequest){

      return  cryptoServices.getAllCoins(getEmailRequest);


    }


//    this is used to add the coin in database
    @PostMapping("/addCoins")
    public String updateCoins(@RequestBody UpdateCoinsRequest updateCoinsRequest) {

        return cryptoServices.addCoins(updateCoinsRequest);
    }


    //    this is used to Remove the coin in database
    @PostMapping("/removeCoins")
    public String removeCoins(@RequestBody UpdateCoinsRequest updateCoinsRequest) {

        return cryptoServices.removeCoins(updateCoinsRequest);
    }




    // this is handle the login request
    @PostMapping("/login")
    public boolean login(@RequestBody GetLoginRequest getLoginRequest){

        return cryptoServices.login(getLoginRequest);

    }

    // this is used to sing up the user
    @PostMapping("/signUp")
    public CryptoResponse createNewRecord(@RequestBody CreateCryptoRequest createCryptoRequest){

        CryptoEntity cryptoEntity = cryptoServices.createNewRecord(createCryptoRequest);

        return new CryptoResponse(cryptoEntity);
    }

}
