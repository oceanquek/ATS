package com.domain.repository;

import com.domain.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

    @Query(value = "SELECT * FROM Airport  WHERE code = :code ",nativeQuery = true)
    Airport findByCode(@Param("code") String code);

}
