package Crypto.Tracker.Crypto_Tracker.Repository;


import Crypto.Tracker.Crypto_Tracker.Entity.CoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<CoinEntity,Long> {

}
