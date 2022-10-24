package org.acme.cores.crudmember.repositories;

import org.acme.entitys.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ToanNT
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
