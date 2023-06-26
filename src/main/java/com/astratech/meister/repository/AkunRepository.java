package com.astratech.meister.repository;

import com.astratech.meister.model.Akun;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AkunRepository extends CrudRepository<Akun,Integer> {

    @Query("SELECT u from Akun u where u.status =:status")
    public Iterable<Akun> findAkunByStatus(@Param("status") Integer status);

    @Query("SELECT CASE WHEN COUNT(u.id_akun) > 0 THEN TRUE ELSE FALSE END from Akun u where u.nim =:nim and u.password =:password")
    public boolean login(@Param("nim") String nim, @Param("password") String password);

    @Query("SELECT u from Akun u where u.nim =:nim and u.password =:password")
    public Akun getAkunByNimAndPassword(@Param("nim") String nim, @Param("password") String password);

}
