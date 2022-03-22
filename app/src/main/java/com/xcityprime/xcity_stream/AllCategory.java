package com.xcityprime.xcity_stream;

import java.util.List;

public class AllCategory {
    String categoryTitle;
    Integer categoryId;
    private List<CategoryItem> categoryItemsList = null;

    public AllCategory(Integer categoryId, String categoryTitle, List<CategoryItem> categoryItemsList) {
        this.categoryTitle = categoryTitle;
        this.categoryId = categoryId;
        this.categoryItemsList = categoryItemsList;
    }

    public List<CategoryItem> getCategoryItemsList() {
        return categoryItemsList;
    }

    public void setCategoryItemsList(List<CategoryItem> categoryItemsList) {
        this.categoryItemsList = categoryItemsList;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
