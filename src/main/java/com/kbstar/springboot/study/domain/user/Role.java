package com.kbstar.springboot.study.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    // ADMIN, USER, GUEST
    // ROLE_
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "회원");

    private final String key;
    private final String title;
}

/*
ENUM : ENUMerate, tElephone NUMber

Trying=100,
OK=200,
AuthError=401, Forbidden=403, NotFound, MethodNotAllowed,


SUN=1, MON, TUE, WED, THU,FRI, SAT


 */