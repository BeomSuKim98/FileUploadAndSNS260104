package com.sbs.tutorial.app1.domain.fileUpload.entity;

import com.sbs.tutorial.app1.base.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
// 객체를 생성할 때 new 키워드 대신 빌더 패턴을 쓰게 해준다.
// 상속 관계에 있는 부모 클래스의 필드까지 자식 클래스에서 한 번에 세팅할 수 있다.
@SuperBuilder
// 객체를 출력할 때 문자열을 보기 좋게 보여준다, 부모 클래스에 정의된 필드값까지 보여 달라는 의미.
@ToString(callSuper = true)
public class GenFile extends BaseEntity{
    private String relTypeCode;
    private int relId;
    private String typeCode;
    private String type2Code;
    private String fileExtTypeCode;
    private String fileExtType2Code;
    private int fileSize;
    private int fileNo;
    private String fileExt;
    private String fileDir;
    private String originFileName;
}
