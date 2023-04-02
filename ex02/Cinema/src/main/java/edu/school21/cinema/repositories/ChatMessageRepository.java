package edu.school21.cinema.repositories;

import edu.school21.cinema.models.ChatMessage;

import java.util.List;

public interface ChatMessageRepository extends CrudRepository<ChatMessage> {

    List<ChatMessage> findTopByFilmIdOrderByTimestampDesc(Long filmId, int count);
}
