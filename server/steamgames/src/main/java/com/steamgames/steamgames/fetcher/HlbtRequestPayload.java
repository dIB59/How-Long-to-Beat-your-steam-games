package com.steamgames.steamgames.fetcher;

import java.util.Arrays;

public class HlbtRequestPayload {
    private String searchType;
    private String[] searchTerms;
    private int searchPage;
    private int size;
    private SearchOptions searchOptions;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String[] getSearchTerms() {
        return searchTerms;
    }

    public void setSearchTerms(String[] searchTerms) {
        this.searchTerms = searchTerms;
    }

    public int getSearchPage() {
        return searchPage;
    }

    public void setSearchPage(int searchPage) {
        this.searchPage = searchPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public SearchOptions getSearchOptions() {
        return searchOptions;
    }

    public void setSearchOptions(SearchOptions searchOptions) {
        this.searchOptions = searchOptions;
    }

    // Inner class for searchOptions
    public static class SearchOptions {
        private Games games;
        private Users users;
        private String filter;
        private int sort;
        private int randomizer;

        // Getters and setters

        public Games getGames() {
            return games;
        }

        public void setGames(Games games) {
            this.games = games;
        }

        public Users getUsers() {
            return users;
        }

        public void setUsers(Users users) {
            this.users = users;
        }

        public String getFilter() {
            return filter;
        }

        public void setFilter(String filter) {
            this.filter = filter;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getRandomizer() {
            return randomizer;
        }

        public void setRandomizer(int randomizer) {
            this.randomizer = randomizer;
        }
    }

    // Inner class for games
    public static class Games {
        private int userId;
        private String platform;
        private String sortCategory;
        private String rangeCategory;
        private RangeTime rangeTime;
        private Gameplay gameplay;
        private String modifier;

        // Getters and setters

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getSortCategory() {
            return sortCategory;
        }

        public void setSortCategory(String sortCategory) {
            this.sortCategory = sortCategory;
        }

        public String getRangeCategory() {
            return rangeCategory;
        }

        public void setRangeCategory(String rangeCategory) {
            this.rangeCategory = rangeCategory;
        }

        public RangeTime getRangeTime() {
            return rangeTime;
        }

        public void setRangeTime(RangeTime rangeTime) {
            this.rangeTime = rangeTime;
        }

        public Gameplay getGameplay() {
            return gameplay;
        }

        public void setGameplay(Gameplay gameplay) {
            this.gameplay = gameplay;
        }

        public String getModifier() {
            return modifier;
        }

        public void setModifier(String modifier) {
            this.modifier = modifier;
        }
    }

    // Inner class for rangeTime
    public static class RangeTime {
        private int min;
        private int max;

        // Getters and setters

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

    // Inner class for gameplay
    public static class Gameplay {
        private String perspective;
        private String flow;
        private String genre;

        // Getters and setters

        public String getPerspective() {
            return perspective;
        }

        public void setPerspective(String perspective) {
            this.perspective = perspective;
        }

        public String getFlow() {
            return flow;
        }

        public void setFlow(String flow) {
            this.flow = flow;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }
    }

    // Inner class for users
    public static class Users {
        private String sortCategory;

        // Getters and setters

        public String getSortCategory() {
            return sortCategory;
        }

        public void setSortCategory(String sortCategory) {
            this.sortCategory = sortCategory;
        }
    }

    @Override
    public String toString() {
        return "HlbtRequestPayload{" +
                "searchType='" + searchType + '\'' +
                ", searchTerms=" + Arrays.toString(searchTerms) +
                ", searchPage=" + searchPage +
                ", size=" + size +
                ", searchOptions=" + searchOptions +
                '}';
    }
}

