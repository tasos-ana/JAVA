package Homework4;

import java.util.List;

public class Book{

    //orizoume tis private metavlites mas!
    private String title;
    private int code;
    private List<String> authors;
    private String publisher;
    private int year;
    private Category category;
    private List<Integer> copies;

    //orizoume tous constructores
    public void Book(String title, int code, List<String> authors) {
        this.title=title;
        this.code=code;
        this.authors=authors;
    }
    
    public void Book(String title, int code, List<String> authors, String publisher) {
        this.title=title;
        this.code=code;
        this.authors=authors;
        this.publisher=publisher;
    }
    
    public void Book(String title, int code, List<String> authors, String publisher, int year) {
        this.title=title;
        this.code=code;
        this.authors=authors;
        this.publisher=publisher;
        this.year=year;
    }
    
    public void Book(String title, int code, List<String> authors, String publisher, int year, Category categ) {
        this.title=title;
        this.code=code;
        this.authors=authors;
        this.publisher=publisher;
        this.year=year;
        this.category=categ;
    }

    //orizoume tous accessors
    public String getTitle() {
        return title;
    }

    public int getCode() {
        return code;
    }
    
    public List<String> getAuthors() {
        return authors;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public int getYear() {
        return year;
    }
    
    public Category getCategory() {
        return category;
    }
    
    public List<Integer> getCopies() {
        return copies;
    }
    
    //orizoume tous transformers
    public void setTitle(String title) {
        this.title=title;
    }
    
    public void setCode(int code) {
        this.code=code;
    }
    
    public void setAuthors(List<String> authors) {
        this.authors=authors;
    }
    
    public void setPublisher(String publisher) {
        this.publisher=publisher;
    }
    
    public void setYear(int year) {
        this.year=year;
    }
    
    public void setCategory(Category categ) {
        this.category=categ;
    }
    
    public void setCopies(List<Integer> copies) {
        this.copies=copies;
    }

    //prosthiki kodikou antitipou
    public void addCopy(int copyCode) {
        copies.add(code);
    }

    //aferei enan kwdiko antitipou
    public void removeCopy(int copyCode) {
        copies.remove(copyCode);
    }

    //afetei olous tous kwdikous antitupwn
    void removeAllCopies() {
        copies.removeAll(copies);
    }

    protected enum Category {
        Action, Fiction, Drama, Romance, SciFi, Poems, Kids
    }

}
