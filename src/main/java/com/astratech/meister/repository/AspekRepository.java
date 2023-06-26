package com.astratech.meister.repository;


import com.astratech.meister.model.Aspek;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AspekRepository extends CrudRepository<Aspek, Integer> {
    @Query("SELECT ks from Aspek ks where ks.status =:status")

    public Iterable<Aspek> findAspekByStatus(@Param("status") String status);



}
