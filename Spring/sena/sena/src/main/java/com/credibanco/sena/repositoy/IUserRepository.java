package com.credibanco.sena.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

@Repository
public interface IUserRepository extends JpaRepository<Usuario, Long>{

 

}