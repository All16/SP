package com.example.ciuleSP.Serv;

import com.example.ciuleSP.Book.Paragraph;

public interface Strategy {
    public default void render(Paragraph paragraph, int width){}
}

