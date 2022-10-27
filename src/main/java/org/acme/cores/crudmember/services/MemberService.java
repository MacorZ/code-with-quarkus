package org.acme.cores.crudmember.services;

import org.acme.entitys.Member;
import org.acme.exeptions.CustomException;

import java.util.List;

/**
 * @author ToanNT
 */
public interface MemberService {
    List<Member> getList();

    Member save(Member member);

    Member update(Long id,Member member) throws CustomException;

    String delete(Long id) throws CustomException;

    List<Member> getByTen(String ten);


}
