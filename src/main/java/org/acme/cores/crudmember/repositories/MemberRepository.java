package org.acme.cores.crudmember.repositories;

import org.acme.entitys.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ToanNT
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(" FROM Member u WHERE u.name LIKE   CONCAT('%',:ten,'%')")
    List<Member> findMemberByNameContainingIgnoreCase(@Param("ten") String ten);
}
