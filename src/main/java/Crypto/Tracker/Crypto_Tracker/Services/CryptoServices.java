package Crypto.Tracker.Crypto_Tracker.Services;



import Crypto.Tracker.Crypto_Tracker.Entity.CoinEntity;
import Crypto.Tracker.Crypto_Tracker.Entity.CryptoEntity;
import Crypto.Tracker.Crypto_Tracker.Repository.CryptoRepository;
import Crypto.Tracker.Crypto_Tracker.Response.CreateCryptoRequest;
import Crypto.Tracker.Crypto_Tracker.Response.GetEmailRequest;
import Crypto.Tracker.Crypto_Tracker.Response.GetLoginRequest;
import Crypto.Tracker.Crypto_Tracker.Response.UpdateCoinsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CryptoServices {

    @Autowired
    CryptoRepository cryptoRepository;


    //get All users in present the database
    public List<CryptoEntity> getAllRecords() {
        return cryptoRepository.findAll();
    }

    
    // this is get the all user information userName and UserId
   public CryptoEntity getUserInfo(GetEmailRequest getEmailRequest){

       Optional<CryptoEntity> cryptoEntityOptional = cryptoRepository.findById(getEmailRequest.getEmail());
       if (cryptoEntityOptional.isPresent()){
           return cryptoEntityOptional.get();

       }
       return null;
   }

    // this is only return the all coins
    public List<String> getAllCoins(GetEmailRequest getEmailRequest) {

        Optional<CryptoEntity> cryptoEntityRecord = cryptoRepository.findById(getEmailRequest.getEmail());


        if (cryptoEntityRecord.isPresent()) {
            CryptoEntity cryptoEntity = cryptoEntityRecord.get();

            String coins = cryptoEntity.getCoinEntity().getCoins();

            String[] parts = coins.split(",");
            List<String> databaseCoins = new ArrayList<>(Arrays.asList(parts));

            return databaseCoins;
        }
        return null;
    }

    // this is used to add the coin in database
    public String addCoins(UpdateCoinsRequest updateCoinsRequest) {

        Optional<CryptoEntity> optionalCryptoEntity =
                cryptoRepository.findById(updateCoinsRequest.getEmail());

        if (optionalCryptoEntity.isPresent()) {
            CryptoEntity cryptoEntity = optionalCryptoEntity.get();

            if (updateCoinsRequest.getCoins() != null && !updateCoinsRequest.getCoins().isEmpty()) {

                String coins = cryptoEntity.getCoinEntity().getCoins();
                if (!coins.isEmpty() ) {
                    String[] parts = coins.split(",");

                    List<String> databaseCoins = new ArrayList<>(Arrays.asList(parts));

                    if (!databaseCoins.contains(updateCoinsRequest.getCoins())) {
                        databaseCoins.add(updateCoinsRequest.getCoins());

                        String result = String.join(",", databaseCoins);

                        cryptoEntity.getCoinEntity().setCoins(result);

                        cryptoRepository.save(cryptoEntity);
                    }
                }else{
                    cryptoEntity.getCoinEntity().setCoins(updateCoinsRequest.getCoins());
                    cryptoRepository.save(cryptoEntity);
                }

                return "Coin Added Successfully";
            }
        }
        return "coin not added";
    }


    // this is used to remove the coin in database
    public String removeCoins(UpdateCoinsRequest updateCoinsRequest) {

        Optional<CryptoEntity> optionalCryptoEntity = cryptoRepository.findById(updateCoinsRequest.getEmail());


        if (optionalCryptoEntity.isPresent()) {
            CryptoEntity cryptoEntity = optionalCryptoEntity.get();

            if (updateCoinsRequest.getCoins() != null && !updateCoinsRequest.getCoins().isEmpty()) {

                String coins = cryptoEntity.getCoinEntity().getCoins();
                String[] parts = coins.split(",");
                List<String> databaseCoins = new ArrayList<>(Arrays.asList(parts));

//        System.out.println(" Original List the element ...."+databaseCoins);

                String requestedCoin = updateCoinsRequest.getCoins();
                databaseCoins.remove(requestedCoin);

                String result = String.join(",", databaseCoins);

                cryptoEntity.getCoinEntity().setCoins(result);

                cryptoRepository.save(cryptoEntity);


//        System.out.println("After Removing the element String ...."+result);


                return "Coin Added successfully";
            }
        }

        return "Coin not added";
    }

    // this is used to sing up the user
    public CryptoEntity createNewRecord(CreateCryptoRequest createCryptoRequest) {
        CryptoEntity cryptoEntity = new CryptoEntity(createCryptoRequest);

        CoinEntity coinEntity = new CoinEntity(createCryptoRequest.getEmail(), " ");
        cryptoEntity.setCoinEntity(coinEntity);

        cryptoEntity = cryptoRepository.save(cryptoEntity);
        return cryptoEntity;
    }




    // this is handle the login request
    public boolean login(GetLoginRequest getLoginRequest) {

        Optional<CryptoEntity> cryptoEntity = cryptoRepository.findById(getLoginRequest.getEmail());


        if (cryptoEntity.isPresent()) {
            CryptoEntity cryptoEntity1 = cryptoEntity.get();

            return cryptoEntity1.getPassword().equals(getLoginRequest.getPassword());
        }
        return false;


    }


}
