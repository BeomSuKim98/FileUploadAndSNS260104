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
        // 파일 이름 정의
        String profileImagePath = "member/" + UUID.randomUUID() + ".png";

        // 저장할 파일의 전체 경로 설정
        File profileImgFile = new File(genFileDirPath + "/" + profileImagePath);

        if(!profileImgFile.canExecute()) {
            profileImgFile.mkdirs();
        }
        MultipartFile profileImage = memberJoinForm.getProfileImg();

        if (profileImage == null || profileImage.isEmpty()) {
            System.out.println("로그: 프로필 이미지가 전송되지 않았습니다!");
        } else {
            System.out.println("로그: 파일 이름 = " + profileImage.getOriginalFilename());
            System.out.println("로그: 파일 크기 = " + profileImage.getSize());
        }

        try {
            profileImage.transferTo(profileImgFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Member member = Member.builder()
                .username(memberJoinForm.getUsername())
                .password(memberJoinForm.getPassword())
                .email(memberJoinForm.getEmail())
                .profileImg(profileImagePath)
                .build();

        memberRepository.save(member);
        return member;
    }

    public Member getMemberById(Long loginedMemberId) {
        return memberRepository.findById(loginedMemberId).orElse(null);
    }
}
