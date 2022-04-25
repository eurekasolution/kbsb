package com.kbstar.springboot.study.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/* 31 : JPA Auditing (감시)
    게시글의 등록, 수정날짜를 자동 관리

    @MappedSuperclass
        JPA Entity Class들이 BaseTimeEntity(현재클래스) 상속받게 할 예정
        상속받으면, createDate, modifiedDate 칼럼으로 인식하게 함
    @EntityListner :BaseTimeEntity클래스에 Auditing 기능을 포함시키겠다.

    이 BaseTimeEntity 클래스를 Posts에서 상속받도록 변경할 예정

 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
