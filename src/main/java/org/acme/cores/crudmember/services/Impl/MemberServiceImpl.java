package org.acme.cores.crudmember.services.Impl;

import org.acme.cores.crudmember.repositories.MemberRepository;
import org.acme.cores.crudmember.services.MemberService;
import org.acme.entitys.Member;
import org.acme.exeptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

/**
 * @author ToanNT
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getList() {
        return memberRepository.findAll();
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(Long id, Member member) throws CustomException {
        member.setId(id);
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (!optionalMember.isPresent()) {
            throw new CustomException("Không tồn tại");
        }

        return memberRepository.save(optionalMember.map(member1 -> member).get());
    }

    @Override
    public String delete(Long id) throws CustomException {
        Optional<Member> optionalMember = memberRepository.findById(id);
        if (optionalMember.isPresent()) {
            memberRepository.deleteById(id);
            return "xóa thành công member:" + optionalMember.get();
        } else {
            throw new CustomException("Không tồn tại");
        }

    }

    @Override
    public List<Member> getByTen(String ten) {
        return memberRepository.findMemberByNameContainingIgnoreCase(ten);
    }
}
