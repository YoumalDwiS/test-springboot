package com.astratech.meister.repository;


import com.astratech.meister.model.DetailAspek;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailAspekRepository extends CrudRepository<DetailAspek, Integer> {

    @Query("SELECT s from DetailAspek s where s.status =:status")
    public Iterable<DetailAspek> findDetailAspekByStatus(@Param("status") String status);


    @Query("SELECT s from DetailAspek s where s.id_aspek.id_aspek =:id_aspek and s.status ='Aktif'")
    public Iterable<DetailAspek> findDetailAspekById_aspek(@Param("id_aspek") Integer id_aspek);
}
