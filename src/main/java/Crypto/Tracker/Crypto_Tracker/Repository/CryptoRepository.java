package Crypto.Tracker.Crypto_Tracker.Repository;

import Crypto.Tracker.Crypto_Tracker.Entity.CryptoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoRepository extends JpaRepository<CryptoEntity,String> {


}
