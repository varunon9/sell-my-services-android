package me.varunon9.sellmyservices.db.models;

/**
 * Created by varunkumar on 4/7/18.
 */

public class SearchHistory {

    int id;
    String searchText;
    long createdAt;

    public SearchHistory() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }
}
