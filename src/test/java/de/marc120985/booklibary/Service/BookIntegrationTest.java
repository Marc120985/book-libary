package de.marc120985.booklibary.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class BookIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DirtiesContext
    void getBookList() throws Exception {
        //given

        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                       [
                           {
                               "isbn": "1234",
                               "title": "Tagebuch",
                               "author": "Marc",
                               "type": "SOFTCOVER"
                           },
                           {
                               "isbn": "4567",
                               "title": "Fantasy World",
                               "author": "James",
                               "type": "AUDIOBOOK"
                           }
                       ]
                    """));
    }

    @Test
    @DirtiesContext
    void testGetBook() throws Exception {
        //given
        String isbn = "1234";
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/books/"+isbn))
                //then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("""
                    {
                               "isbn": "1234",
                               "title": "Tagebuch",
                               "author": "Marc",
                               "type": "SOFTCOVER"
                    }
                    """));
    }

    @Test
    @DirtiesContext
    void addBook() throws Exception {
        //given
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                            {
                               "isbn": "88888",
                               "title": "Mein Buch",
                               "author": "Anders",
                               "type": "SOFTCOVER"
                            }
                            """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                               "isbn": "88888",
                               "title": "Mein Buch",
                               "author": "Anders",
                               "type": "SOFTCOVER"
                    }
                    """));
        //when
        mockMvc.perform(MockMvcRequestBuilders.get("/books/88888"))
                //then
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    {
                               "isbn": "88888",
                               "title": "Mein Buch",
                               "author": "Anders",
                               "type": "SOFTCOVER"
                    }
                    """));
    }

    @Test
    @DirtiesContext
    void deleteBook() throws Exception {
        //given
        String isbn = "1234";
        //when
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/"+isbn))
                //then
                .andExpect(status().isOk());
        mockMvc.perform(MockMvcRequestBuilders.get("/books"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                        {
                               "isbn": "4567",
                               "title": "Fantasy World",
                               "author": "James",
                               "type": "AUDIOBOOK"
                        }
                    ]
                    """));
    }
}


