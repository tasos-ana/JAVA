package Homework4;

import java.util.List;

public class Member{
    
    private String firstName;
    private String lastName;
    private int memberID;
    private List<Integer> checkedCopies;
    private List<Integer> historyCopies;
    
    //Constructor
    public void Member(String firstName,String lastName,int memberID){
        this.firstName=firstName;
        this.lastName=lastName;
        this.memberID=memberID;
    }
    
    //Accessors
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public int getMemberID(){
        return memberID;
    }
    
    public List<Integer> getCheckedCopies(){
        return checkedCopies;
    }
    
    public List<Integer> getHistoryCopies(){
        return historyCopies;
    }
    
    //Transformers
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    
    public void setMemberID(int memberID){
        this.memberID=memberID;
    }
    
    public void setCheckedCopies(List<Integer> checkedCopies){
        this.checkedCopies=checkedCopies;
    }
    
    public void setHistoryCopies(List<Integer> historyCopies){
        this.historyCopies=historyCopies;
    }
       
    public void addCopyToCheckedCopies(int copyCode){
        checkedCopies.add(copyCode);
    }
    
    public void addCopyToHistoryCopies(int copyCode){
        historyCopies.add(copyCode);
    }
    
    public void removeCopyFromCheckedCopies(int copyCode){
        checkedCopies.remove(copyCode);
    }
    
    public void removeCopyFromHistoryCopies(int copyCode){
        historyCopies.remove(copyCode);
    }
    
    }