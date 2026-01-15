package com.sbs.tutorial.app1.domain.member.service;

import com.sbs.tutorial.app1.domain.member.entity.Member;
import com.sbs.tutorial.app1.domain.member.form.MemberJoinForm;
import com.sbs.tutorial.app1.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

import static com.sbs.tutorial.app1.domain.member.entity.QMember.member;

@Service
@RequiredArgsConstructor
public class MemberService {
    @Value("${custom.genFileDirPath}")
    private String genFileDirPath;
    private final MemberRepository memberRepository;

    public Member getMemberByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

    public Member join(MemberJoinForm memberJoinForm) {
        String profileImagePath = "member/" + UUID.randomUUID() + ".png";

        File profileImgFile = new File(genFileDirPath + "/" + profileImagePath);
        if(!profileImgFile.canExecute()){
            profileImgFile.mkdirs();
        }

        MultipartFile profileImage = memberJoinForm.getProfileImage();

        try {
            profileImage.transferTo(profileImgFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Member member = Member.builder()
                .username(memberJoinForm.getUsername())
                .password(memberJoinForm.getPassword())
                .email(memberJoinForm.getEmail())
                .profileImage(profileImagePath)
                .build();

        memberRepository.save(member);
        return member;
    }
}
