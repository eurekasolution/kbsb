package com.kbstar.springboot.study.config.auth;

/*
Session을 사용
    로그인과 관련된 코드가 반복적으로 들어가 점점 지저분해진다.
    메소드 인자를 통해서 세션값을 바로 얻을 수 있도록 처리.
    어노테이션으로 처리
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER)  // 생성될수 있는 위치를 지정
                                // 파라미터로 지정
                                // 메소드의 파라미터로 선언된 객체에서만 사용
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
// @interface
    // 이 파일을 어노테이션 클래스로 지정
    // LoginUser라는 이름을 갖는 어노테이션이 새롭게 생성되었다.
}
