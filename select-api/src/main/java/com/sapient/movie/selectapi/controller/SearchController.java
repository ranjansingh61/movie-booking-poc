package com.sapient.movie.selectapi.controller;

import com.sapient.movie.selectapi.response.SearchResponse;
import com.sapient.movie.selectapi.service.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchServiceImpl searchService;

    @GetMapping
    public SearchResponse searchedData(@RequestParam("input") String input) {
        SearchResponse searchResponse = searchService.getAllData(input);
        return searchResponse;
    }
}
