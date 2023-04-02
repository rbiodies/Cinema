package edu.school21.cinema.controllers;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.services.ChatMessageService;
import edu.school21.cinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
public class ChatController {

    @Autowired
    private ChatMessageService chatService;

    @Autowired
    private FilmService filmService;

    @GetMapping("/films/{filmId}/chat")
    public String showChatPage(@PathVariable Long filmId, @CookieValue(value = "userId", defaultValue = "null") String userId, HttpServletResponse response, Model model) {
        if (Objects.equals(userId, "null")) {
            Cookie cookie = new Cookie("userId", "user" + UUID.randomUUID().toString().substring(0, 8));
            response.addCookie(cookie);
        }
        List<ChatMessage> messages = chatService.findTopByFilmIdOrderByTimestampDesc(filmId, 20);
        Collections.reverse(messages);
        model.addAttribute("messages", messages);
        model.addAttribute("film", filmService.findById(filmId));
        return "chat";
    }

    @MessageMapping("/films/{filmId}/chat/messages")
    @SendTo("/films/{filmId}/chat/messages")
    public ChatMessage handleMessage(@DestinationVariable Long filmId, ChatMessage message) {
        message.setFilm(filmService.findById(filmId));
        chatService.save(message);
        return message;
    }
}