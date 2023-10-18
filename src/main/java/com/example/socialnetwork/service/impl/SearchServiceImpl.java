package com.example.socialnetwork.service.impl;

import com.example.socialnetwork.dao.Impl.SearchDaoImpl;
import com.example.socialnetwork.dao.SearchDao;
import com.example.socialnetwork.domain.Search;
import com.example.socialnetwork.service.SearchService;

import java.util.List;

public class SearchServiceImpl implements SearchService {
    private SearchDao searchDao=new SearchDaoImpl();
    @Override
    public List<Search> showAllSearches() {

        return searchDao.getAllSearch();
    }
}
