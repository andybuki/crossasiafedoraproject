package org.crossasia.mapper;

import org.crossasia.domain.Book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookMapper {

    public Map<String, Object> getMap(Book book) {
        Map<String, Object> answer = new HashMap<String, Object>();
        answer.put("id", book.getId());
        answer.put("name", book.getName());
        return answer;
    }

    public List<Book> readBooks(List<Map<String, String>> dataList) {

        System.out.println("data:" + dataList);
        List<Book> books = new ArrayList<Book>();

        for (Map<String, String> data : dataList) {

            Book book = new Book();
            book.setId(data.get("id"));
            book.setName(data.get("name"));
            books.add(book);
        }

        return books;
    }
}