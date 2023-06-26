package com.astratech.meister.repository;

import com.astratech.meister.model.Bagian;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BagianRepository extends CrudRepository<Bagian, Integer> {
    @Query("SELECT bg from Bagian bg where bg.status =:status")
    public Iterable<Bagian> findBagianByStatus(@Param("status") Integer status);
}
