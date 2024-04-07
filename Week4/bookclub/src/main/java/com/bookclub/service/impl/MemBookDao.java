package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books;

    public MemBookDao() {
        this.books = new ArrayList<Book>();

        this.books.add(new Book("0747538492", "Harry Potter and the Philosopher's Stone", "Ever since Harry Potter had come home for the summer, the Dursleys had been so mean and hideous that all Harry wanted was to get back to the Hogwarts School for Witchcraft and Wizardry. But just as he’s packing his bags, Harry receives a warning from a strange impish creature who says that if Harry returns to Hogwarts, disaster will strike.", 352, new ArrayList<>(List.of("J.K. Rowling"))));
        this.books.add(new Book("9780747532699", "Harry Potter and the Chamber of Secrets", "Harry Potter has never even heard of Hogwarts when the letters start dropping on the doormat at number four, Privet Drive. Addressed in green ink on yellowish parchment with a purple seal, they are swiftly confiscated by his grisly aunt and uncle. An incredible adventure is about to begin!", 333, new ArrayList<>(List.of("J.K. Rowling"))));
        this.books.add(new Book("0743453255", "Forrest Gump", "Meet Forrest Gump, the lovable, herculean, and surprisingly savvy hero of this remarkable comic odyssey. After accidentally becoming the star of University of Alabama's football team, Forrest goes on to become a Vietnam War hero, a world-class Ping-Pong player, a villainous wrestler, and a business tycoon -- as he wonders with childlike wisdom at the insanity all around him.", 248, new ArrayList<>(List.of("Winston Groom"))));
        this.books.add(new Book("1503332543", "The Jungle Book", "Best known for the 'Mowgli' stories, Rudyard Kipling's The Jungle Book expertly interweaves myth, morals, adventure and powerful story-telling. Set in Central India, Mowgli is raised by a pack of wolves. Along the way he encounters memorable characters such as the foreboding tiger Shere Kahn, Bagheera the panther and Baloo the bear.", 277, new ArrayList<>(List.of("Rudyard Kipling"))));
        this.books.add(new Book("0676973760", "Life of Pi", "Life of Pi is a fantasy adventure novel by Yann Martel published in 2001. The protagonist, Piscine Molitor Pi Patel, a Tamil boy from Pondicherry, explores issues of spirituality and practicality from an early age. He survives 227 days after a shipwreck while stranded on a boat in the Pacific Ocean with a Bengal tiger named Richard Parker.", 460, new ArrayList<>(List.of("Yann Martel"))));
    }

    @Override
    public List<Book> list() {
        return this.books;
    }

    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    }
}
