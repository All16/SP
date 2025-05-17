package com.example.ciuleSP.obs;

import com.example.ciuleSP.Book.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.io.IOException;

public class SseObserver implements Observer {
    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON); // Send the book as JSON
        } catch (IOException e) {
            emitter.completeWithError(e);
        }
    }
}
