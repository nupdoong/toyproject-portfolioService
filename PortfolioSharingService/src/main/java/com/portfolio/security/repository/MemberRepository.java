package com.portfolio.security.repository;

import com.portfolio.security.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Member findByUsername(String username);

}