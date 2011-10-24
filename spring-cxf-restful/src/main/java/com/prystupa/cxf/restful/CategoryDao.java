package com.prystupa.cxf.restful;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CategoryDao {
    
    private Map<String, Category> categoryMap = new HashMap<String, Category>();
    private Map<String, Collection<Book>> bookMap = new HashMap<String, Collection<Book>>();
    
    public void addCategory(Category category) {
        categoryMap.put(category.getId(), category);        
    }
    
    public void addBooks(Category category) {
        bookMap.put(category.getId(), category.getBooks());        
    }
    
    public Collection<Book> getBooks(String categoryId) {
        return bookMap.get(categoryId);
    }
    
    public Category getCategory(String categoryId) {
        Category result = null;
        Category stored = categoryMap.get(categoryId);
        if(stored != null) {
            result = new Category();
            result.setId(stored.getId());
            result.setName(stored.getName());
        }
        return result;
    }
    
    public void deleteCategory(String id) {
        categoryMap.remove(id);
        bookMap.remove(id);
    }
    
    public void updateCategory(Category category) {
        categoryMap.put(category.getId(), category);
    }
}
