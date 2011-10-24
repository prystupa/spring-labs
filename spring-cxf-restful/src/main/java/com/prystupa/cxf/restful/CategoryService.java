package com.prystupa.cxf.restful;

import javax.ws.rs.*;

@Path("/category-service")
@Produces("application/xml")
public class CategoryService {

    private final CategoryDao categoryDao;

    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GET
    @Path("/test/{message}")
    @Produces({ "application/xml", "application/json" })
    public Test getTestMessage(@PathParam("message") String message) {
        Test test = new Test();
        test.setMessage(message);
        return test;
    }

    @GET
    @Path("/category/{id}")
    public Category getCategory(@PathParam("id") String id) {
        return categoryDao.getCategory(id);
    }
    
    @POST
    @Path("/category")
    @Consumes({ "application/xml", "application/json" })
    public void addCategory(Category category) {
         categoryDao.addCategory(category);
    }
    
    @DELETE
    @Path("/category/{id}")
    public void deleteCategory(@PathParam("id") String id) {
        categoryDao.deleteCategory(id);        
    }
    
    @PUT
    @Path("/category")
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);        
    }

    @POST
    @Path("/category/book")
    @Consumes({ "application/xml", "application/json" })
    public void addBooks(Category category) {
        categoryDao.addBooks(category);
    }
    
    @GET
    @Path("/category/{id}/books")
    @Consumes({ "application/xml", "application/json" })
    public Category getBooks(@PathParam("id") String id) {
        Category result = categoryDao.getCategory(id);
        result.setBooks(categoryDao.getBooks(id));
        return result;
    }
}
