package Homework4;

import java.util.List;
import java.util.Random;

public class Library {

    private String name;
    private List<Book> books;
    private List<Copy> copies;
    private List<Member> members;
    private List<Integer> genNum;

    protected enum Category {

        Action, Fiction, Drama, Romance, SciFi, Poems, Kids
    }

    //Constructor
    public void Library(String name) {
        this.name = name;
    }

    //Accessors
    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Copy> getCopies() {
        return copies;
    }

    //Transformers
    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setCopies(List<Copy> copies) {
        this.copies = copies;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    //Book
    //add-remove
    public int addBook(String title, List<String> authors) {//diwrthosi tou return
        //Book bk = new Book(title,authors);
        return 0;
    }

    public int addBook(String title, List<String> authors, String publisher) {
        return 0;
    }

    public int addBook(String title, List<String> authors, String publisher, int year) {
        return 0;
    }

    public int addBook(String title, List<String> authors, String publisher, int year, Category categ) {
        return 0;
    }
    //public Book removeBook(int bookCode){}

    //Copies
    //add remove -den uparxei kati gia return
    public int addCopy(int bookCode) {
        return 0;
    }
    //public Copy removeCopy(int copyCode){}

    //Member
    //add-remove
    public int addMember(String firstName, String lastName) {
        return 0;
    }

    //public Member removeMember(int memberID){}
    
    //book search
    //public book findBook(String title, List<String> authors){}
    //public Book findBook(String title, List<String> authors, String publisher){}
    //public Book findBook(String title, List<String> authors, String publisher, int year){}
    //public Book findBook(String title, List<String> authors, String publisher, int year, Category categ){}
    
    //rent book
    public int rentBook(int memberID, String bookTitle, List<String> bookAuthors) {
        return 0;
    }

    public void returnCopy(int copyCode) {
    }

    //Get numbers of items
    public int getMembersNum() {
        return 0;
    }

    public int getBooksNum() {
        return 0;
    }

    public int getCopiesNum() {
        return 0;
    }

    public int getCheckedCopiesNum() {
        return 0;
    }

    public String toString() {
        return " ";
    }
    
    public int generatorCode(){
        int num=books.size();
        Random rand = new Random();
        num = rand.nextInt((num*num)+20)+1;
        while(genNum.contains(num)){
            num = rand.nextInt((num*num)+20)+1;
        }
        genNum.add(num);
        return num;
    }
    

    
}
