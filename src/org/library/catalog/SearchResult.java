package org.library.catalog;

import java.util.List;

public class SearchResult<T> {

    private List<T> results;
    private String query;

    public SearchResult(
            List<T> results,
            String query) {

        this.results = results;
        this.query = query;
    }

    public List<T> getResults() {
        return results;
    }

    public String getQuery() {
        return query;
    }
}