package com.website.vzw.Member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.Math.toIntExact;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Optional<Member> findById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member;
    }
    public Optional<Member> findByLogin(String username, String passwd) {
        Optional<Member> member = memberRepository.findByUsernameAndPassword(username, passwd);
        return member;
    }

    public List<Member> findAll() {
        List<Member> cities = memberRepository.findAll();
        return cities;
    }

    public void save(Member member) {
        memberRepository.save(member);
    }

    public boolean update(Member member, Long id) {
        Optional<Member> currentMember = memberRepository.findById(id);
        if (currentMember.isPresent()) {
            member.setIdMember(toIntExact(id));
        } else {
            return false;
        }

        memberRepository.save(member);
        return true;
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

}

