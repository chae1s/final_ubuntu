package com.example.Final_Project_9team.controller.socket;

import com.example.Final_Project_9team.dto.ChatMessageDto;
import com.example.Final_Project_9team.dto.ChatRoomDto;
import com.example.Final_Project_9team.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequiredArgsConstructor
public class WebSocketMapping {
    // STOMP over WebSocket
    private final SimpMessagingTemplate simpMessagingTemplate;
    private final ChatService chatService;

    // WebSocket을 통해 클라이언트로부터 전송된 채팅 메시지를 처리하는 핸들러 메소드
    @MessageMapping("/chat")
    public void sendChat(
            @Payload ChatMessageDto chatMessageDto,
            // STOMP over WebSocket은 Header를 포함할 수 있다
            @Headers Map<String, Object> headers,
            @Header("nativeHeaders") Map<String, String> nativeHeaders
//            Authentication authentication
    ){
//        log.info(chatMessageDto.toString());
//        log.info(headers.toString());
//        log.info(nativeHeaders.toString());
        if (!chatMessageDto.getMessage().equals("")) { // 입력되지 않은 메시지는 전송되지 않도록
            String time = new SimpleDateFormat("HH:mm").format(new Date());
            chatMessageDto.setTime(time);
            chatService.saveChatMessage(chatMessageDto);
            simpMessagingTemplate.convertAndSend(
                    String.format("/topic/%s", chatMessageDto.getRoomId()),
                    chatMessageDto
            );
        }
    }

    // 누군가가 구독할때 실행하는 메소드
    @SubscribeMapping("/{roomId}")
    public List<ChatMessageDto> sendGreet(
            @DestinationVariable("roomId") Long roomId
    ) {
//        log.info("new subscription to {}", roomId);
        ChatRoomDto chatRoomDto = chatService.findRoomById(roomId);
        List<ChatMessageDto> last5Messages
                = chatService.getLast5Messages(roomId);

        return last5Messages;
    }
}
