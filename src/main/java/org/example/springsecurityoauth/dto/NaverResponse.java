package org.example.springsecurityoauth.dto;

import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class NaverResponse implements OAuth2Response {

    private final Map<String, Object> attribute;

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getProviderId() {
        // 응답 구조에서 id는 response 객체 내부에 위치
        Map<String, Object> response = (Map<String, Object>) attribute.get("response");
        return response.get("id").toString();
    }

    @Override
    public String getEmail() {
        // 이메일도 response 객체 내에 존재
        Map<String, Object> response = (Map<String, Object>) attribute.get("response");
        return response.get("email").toString();
    }

    @Override
    public String getName() {
        // 이름도 response 객체 내에 존재
        Map<String, Object> response = (Map<String, Object>) attribute.get("response");
        return response.get("name").toString();
    }
}
