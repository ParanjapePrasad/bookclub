package com.bookclub;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.impl.MongoBookOfTheMonthDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookoftheMonthTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private MongoBookOfTheMonthDao bookOfTheMonthDao;

    @Test
    public void addBookOfMonthTest() {
        BookOfTheMonth bookOfTheMonth = new BookOfTheMonth();
        bookOfTheMonthDao.add(bookOfTheMonth);
        verify(mongoTemplate, times(1)).save(eq(bookOfTheMonth));
    }

    @Test
    public void removeBookOfMonthTest() {
        when(mongoTemplate.remove(any(Query.class), eq(BookOfTheMonth.class))).thenReturn(null);
        assertTrue(bookOfTheMonthDao.remove("1"));
        verify(mongoTemplate, times(1)).remove(any(Query.class), eq(BookOfTheMonth.class));
    }

    @Test
    public void listAllBooksTest() {
        List<BookOfTheMonth> expectedItems = Arrays.asList(new BookOfTheMonth(), new BookOfTheMonth());

        when(mongoTemplate.findAll(BookOfTheMonth.class)).thenReturn(expectedItems);

        List<BookOfTheMonth> actualItems = bookOfTheMonthDao.list("999");

        assertEquals(expectedItems, actualItems);
        verify(mongoTemplate, times(1)).findAll(BookOfTheMonth.class);
    }

    @Test
    public void listByMonthBookTest() {
        int month = 5;
        List<BookOfTheMonth> expectedItems = Arrays.asList(new BookOfTheMonth(), new BookOfTheMonth());

        when(mongoTemplate.find(any(Query.class), eq(BookOfTheMonth.class))).thenReturn(expectedItems);

        List<BookOfTheMonth> actualItems = bookOfTheMonthDao.list(Integer.toString(month));

        assertEquals(expectedItems, actualItems);

        Query expectedQuery = new Query();
        expectedQuery.addCriteria(Criteria.where("month").is(month));

        verify(mongoTemplate, times(1)).find(eq(expectedQuery), eq(BookOfTheMonth.class));
    }


}
