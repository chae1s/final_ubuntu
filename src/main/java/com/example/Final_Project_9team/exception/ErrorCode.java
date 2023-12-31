package com.example.Final_Project_9team.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum ErrorCode {

    ERROR_BAD_REQUEST(400, "ERR_BAD_REQUEST", "Bad request"),
    ERROR_UNAUTHORIZED(401, "ERR_UNAUTHORIZED", "Unauthorized access"),
    ERROR_FORBIDDEN(403, "ERR_FORBIDDEN", "Access forbidden"),
    ERROR_NOT_FOUND(404, "ERR_NOT_FOUND", "Resource not found"),
    ERROR_METHOD_NOT_ALLOWED(405, "ERR_METHOD_NOT_ALLOWED", "Method not allowed"),
    ERROR_NOT_ACCEPTABLE(406, "ERR_NOT_ACCEPTABLE", "Not acceptable"),
    ERROR_CONFLICT(409, "ERR_CONFLICT", "Conflict with existing resource"),
    ERROR_LENGTH_REQUIRED(411, "ERR_LENGTH_REQUIRED", "Length required"),
    ERROR_PRECONDITION_FAILED(412, "ERR_PRECONDITION_FAILED", "Precondition failed"),
    ERROR_UNSUPPORTED_MEDIA(415, "ERR_UNSUPPORTED_MEDIA", "Unsupported media type"),
    ERROR_TOO_MANY_REQUESTS(429, "ERR_TOO_MANY_REQUESTS", "Too many requests"),
    ERROR_INTERNAL_SERVER(500, "ERR_INTERNAL_SERVER", "Internal server error"),
    ERROR_SERVICE_UNAVAILABLE(503, "ERR_SERVICE_UNAVAILABLE", "Service temporarily unavailable"),
    ERROR_GATEWAY_TIMEOUT(504, "ERR_GATEWAY_TIMEOUT", "Gateway timeout"),
    ERROR_NETWORK_AUTHENTICATION_REQUIRED(511, "ERR_NETWORK_AUTH_REQUIRED", "Network authentication required"),

    // 400 BAD_REQUEST 잘못된 요청
    ALREADY_EXISTED_NICKNAME(400, "ERR_BAD_REQUEST", "이미 존재하는 닉네임입니다"),
    ALREADY_EXISTED_EMAIL(400, "ERR_BAD_REQUEST", "이미 존재하는 이메일입니다"),
    ALREADY_ACCEPTED_MATES(400, "ERR_BAD_REQUEST", "이미 초대를 수락한 유저입니다"),
    ALREADY_LEFT_MATES(400, "ERR_BAD_REQUEST", "이미 메이트를 떠난 유저입니다"),
    ALREADY_INVITED_MATES(400, "ERR_BAD_REQUEST", "이미 초대된 유저입니다"),
    ALREADY_LIKED_USER(400, "ERR_BAD_REQUEST", "이미 즐겨찾기된 유저입니다."),
    USER_NOT_LIKED(400, "ERR_BAD_REQUEST", "즐겨찾기된 유저가 아닙니다."),

    INVALID_PARAMETER(400, "ERR_BAD_REQUEST","파라미터 값을 확인해주세요."),
    MATES_NOT_MATCHED_USER(400,"ERR_BAD_REQUEST","메이트와 유저 정보가 일치하지 않습니다."),
    USER_NOT_MATCHED_HOST(400,"ERR_BAD_REQUEST","채팅방의 호스트와 일치하지 않습니다."),
    INVALID_FILE(400,"ERR_BAD_REQUEST","첨부파일을 다시 확인해주세요."),
    ERROR_NO_KEYWORD(400,"ERR_BAD_REQUEST","검색어를 입력해주세요."),
    USER_NOT_INCLUDED_SCHEDULE(400,"ERR_BAD_REQUEST","해당 일정에 속하는 유저가 아닙니다."),

    // 403 FORBIDDEN 권한이 없는 경우
    USER_NO_AUTH(403, "ERR_FORBIDDEN", "해당 기능에 대해 권한이 없습니다."),

    // 404 NOT_FOUND 잘못된 리소스 접근
    USER_NOT_FOUND(404, "ERR_NOT_FOUND", "존재하지 않는 유저입니다."),
    COMMENT_NOT_FOUND(404, "ERR_NOT_FOUND", "존재하지 않는 댓글입니다."),
    BOARD_NOT_FOUND(404, "ERR_NOT_FOUND", "존재하지 않는 게시글입니다."),
    INVALID_PASSWORD(404, "ERR_NOT_FOUND", "비밀번호가 일치하지 않습니다."),
    SCHEDULE_NOT_FOUND(404, "ERR_NOT_FOUND", "존재하지 않는 일정입니다."),
    ITEM_NOT_FOUND(404, "ERR_NOT_FOUND", "존재하지 않는 관광상품입니다."),
    MATES_NOT_FOUND(404, "ERR_NOT_FOUND", "존재하지 않는 메이트입니다."),
    CHATROOM_NOT_FOUND(404, "ERR_NOT_FOUND", "존재하지 않는 채팅방입니다."),
    INVITATION_NOT_FOUND(404, "ERR_NOT_FOUND", "초대받은 일정이 없습니다."),

    ERROR_SELF_ADDITION(412,"ERROR_SELF_ADDITION","본인을 추가할 수 없습니다."),

    // 500 내부 서버 에러
    INTERNAL_SERVER_ERROR(500, "ERR_INTERNAL_SERVER","서버 에러입니다. 서버 팀으로 문의바랍니다."),

    // JWT 관련 에러
    TOKEN_NO_AUTH(403, "TOKEN_NO_AUTH", "권한 정보가 없는 토큰입니다."),
    TOKEN_INVALID(401, "TOKEN_INVALID", "유효하지 않은 토큰입니다.");

    private final int status;
    private final String code;
    private final String message;
    ErrorCode(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
