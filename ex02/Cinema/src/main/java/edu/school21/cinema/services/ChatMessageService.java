package edu.school21.cinema.services;

import edu.school21.cinema.models.ChatMessage;

import java.util.List;

public interface ChatMessageService extends CrudService<ChatMessage> {
    List<ChatMessage> findTopByFilmIdOrderByTimestampDesc(Long filmId, int count);
}
