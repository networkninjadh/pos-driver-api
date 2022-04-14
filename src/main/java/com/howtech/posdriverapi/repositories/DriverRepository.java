package com.howtech.posdriverapi.repositories;
import java.util.Optional;

import com.howtech.posdriverapi.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Damond Howawrd
 * @apiNote This is a repository interface used for storing a driver and their information
 *
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long>{
    Optional<Driver> findByUsername(String username);
}
