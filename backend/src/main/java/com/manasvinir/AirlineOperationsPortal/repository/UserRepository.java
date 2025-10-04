package com.manasvinir.AirlineOperationsPortal.repository;

import com.manasvinir.AirlineOperationsPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//had to make all id types as Long to be able to implement jpa repo
//Repository interface per class that interacts with database
@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
