package com.app1.domain.fileUpload.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;
import com.sbs.tutorial.app1.domain.fileUpload.entity.GenFile;
import com.querydsl.core.types.dsl.*;

// 엔티티의 경로에 대한 메타데이터 정보
// 필드 이름, 부모 path, path 타입등 의 정보를 담고 있음
import com.querydsl.core.types.PathMetadata;

// 이 클래스가 자동 생성된 코드임을 표시하는 표준 어노테이션
// 인텔리J 같은 도구가 이 코드를 무시하도록 함, 리팩터링 대상에서 제외
import javax.annotation.processing.Generated;

// Querydsl의 모든 Path 타입의 최상위 인터페이스
import com.querydsl.core.types.Path;

// 가장 중요함, 이 클래스는 Querydsl의DefaultEntitySerializer에 의해 자동 생성되었다.
@Generated("com.querydsl.codegen.DefaultEntitySerializer")

public class QGenFile extends EntityPathBase<GenFile> {
    // 직렬화된 객체와 클래스 정의가 호환되는지 판단하기 위한 고유 ID
    private static final long serialVersionUID = -123456789L;

    private static final QGenFile genFile = new QGenFile("genFile");

    // _super는 GenFile이 상속한 BaseEntity의 필드들을 Querydsl 쿼리에서 동일한 테이블 기준으로 사용하기 위해 포함된 부모 Q클래스 참조다.
    public final com.sbs.tutorial.base.entity.QBaseEntity _super =
            new com.sbs.tutorial.base.entity.QBaseEntity(this);

    // 상속
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final StringPath fileDir = createString("fileDir");

    public final StringPath fileExt = createString("fileExt");

    public final StringPath fileExtType2Code = createString("fileExtType2Code");

    public final StringPath fileExtTypeCode = createString("fileExtTypeCode");

    public final NumberPath<Integer> fileNo = createNumber("fileNo", Integer.class);

    public final NumberPath<Integer> fiileSize = createNumber("fileSize", Integer.class);

    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifyDate = _super.modifyDate;

    public final StringPath originFileName = createString("originFileName");

    public final NumberPath<Integer> relId = createNumber("relId", Integer.class);

    public final StringPath relTypeCode = createString("relTypeCode");

    public final StringPath type2Code = createString("type2Code");

    public final StringPath typeCode = createString("typeCode");

    public QGenFile(String variable) {
        super(GenFile.class, forVariable(variable));
    }

    public QGenFile(Path<? extends GenFile> path){
        super(path.getType(), path.getMetadata());
    }

    public QGenFile(PathMetadata metadata) {
        super(GenFile.class, metadata);
    }
}
