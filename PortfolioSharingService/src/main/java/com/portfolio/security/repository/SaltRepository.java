package com.portfolio.security.repository;

import com.portfolio.security.model.Salt;
import org.springframework.data.repository.CrudRepository;

public interface SaltRepository extends CrudRepository<Salt,Long> {

}