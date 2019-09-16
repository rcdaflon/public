package veiculosonline.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import veiculosonline.database.entity.Chat;
import veiculosonline.service.ChatService;

public class ChatRestController {
    private ChatService chatService = new ChatService();

    @GetMapping("/anuncio/{id}/chats")
    public List<Chat> getAllByAnuncId(@PathVariable("id") Long id) {
        return chatService.readAllByAnuncId(id);
    }
    
    @GetMapping("/usuario/{id}/chats")
    public List<Chat> getAllByUserId(@PathVariable("id") Long id) {
        return chatService.readAllByUserId(id);
    }
    
    @DeleteMapping("/anuncio/{id}/chats")
    public void deleteAllByAnuncId(@PathVariable("id") Long id) {
        chatService.deleteAllByAnuncId(id);
    }
    
    @DeleteMapping("/usuario/{id}/chats")
    public void deleteAllByUserId(@PathVariable("id") Long id) {
        chatService.deleteAllByUserId(id);
    }

    @GetMapping("/chat/{id}")
    public Chat getById(@PathVariable("id") Long id) {
        return chatService.readById(id);
    }

    @DeleteMapping("/chat/{id}")
    public void delete(@PathVariable("id") Long id) {
        chatService.delete(id);
    }
    
    @PostMapping("/chat")
    public ResponseEntity post(@RequestBody Chat chat) {
        HttpHeaders httpHeaders = new HttpHeaders();
            chatService.create(chat);
            httpHeaders.add("Location", "/chat/" + chat.getId());
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }
}
