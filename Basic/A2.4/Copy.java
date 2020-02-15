package Homework4;

public class Copy{
    private int code;
    private int bookCode;
    private boolean checkedOut;
    private int lastMember;
    
    //Constructor
    public void Copy(int copyCode,int bookCode) {
        this.code=copyCode;
        this.bookCode=bookCode;
        this.checkedOut=false;
        this.lastMember=-1;
    }
    
    //Accessors
    public int getCode(){
        return code;
    }
    
    public int getBookCode(){
        return bookCode;
    }
    
    public boolean getCheckedOut(){
        return checkedOut;
    }
    
    public int getLastMember(){
        return lastMember;
    }
    
    //Transformers
    public void setCode(int Code){
    this.code=Code;
    }
    
    public void setBookCode(int bookCode){
        this.bookCode=bookCode;
    }
    
    public void setCheckedOut(boolean chk){
        this.checkedOut=chk;
    }
    
    public void setLastMember(int memberID){
        this.lastMember=memberID;
    }
}