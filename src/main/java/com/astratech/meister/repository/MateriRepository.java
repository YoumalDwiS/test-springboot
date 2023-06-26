package com.astratech.meister.repository;

import com.astratech.meister.model.Materi;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriRepository extends CrudRepository<Materi, Integer> {
    @Query("SELECT mt from Materi mt where mt.status =:status")
    public Iterable<Materi> findMateriByStatus(@Param("status") Integer status);
}
