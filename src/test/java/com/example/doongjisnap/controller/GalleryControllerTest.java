package com.example.doongjisnap.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class GalleryControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void list() throws Exception {
        log.info("boards : " +mockMvc.perform(MockMvcRequestBuilders.get("/gallery/list")
                .param("page", "1")
                .param("amount", "10")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void write() throws Exception {
        log.info("flash map : " + mockMvc.perform(MockMvcRequestBuilders.post("/gallery/write")
                .param("boardTitle", "ControllerTest")
                .param("boardContent", "Controller 내용")
                .param("boardWriter", "이순신")).andReturn().getFlashMap());
    }

    @Test
    void read() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/gallery/read").param("boardNumber", "2")).andReturn().getModelAndView().getModelMap();
    }

    @Test
    void update() throws Exception{
        log.info("model map : " +mockMvc.perform(MockMvcRequestBuilders.post("/gallery/update")
                .param("boardNumber", "5")
                .param("boardTitle", "update Test")
                .param("boardContent", "수정된 게시글")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/gallery/delete")
                .param("boardNumber", "1")
        ).andExpect(MockMvcResultMatchers.status().is3xxRedirection());
    }
}