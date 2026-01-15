package com.sbs.tutorial.app1.domain.member.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.sbs.tutorial.app1.domain.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUsername(String username);
}
