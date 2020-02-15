package Homework3;

public class Person {

    private String fName;
    private String lName;
    private String AT;
    private static int numberOfPersons = 0;

    /**
     * Check name and ID validation. Names must contain only greek or latin
     * letters and ID 2 letters (in start) and 6 numbers.
     */
    protected void check() {
        this.validFirstName();
        this.validLastName();
        this.validAT();
    }

    private void validAT() {
        char[] temp;
        String sTemp = this.AT.replace(" ", "");
        temp = sTemp.toCharArray();
        String letters, numbers;
        if (temp.length == 8) {
            letters = "" + temp[0] + temp[1];
            numbers = "" + temp[2] + temp[3] + temp[4] + temp[5] + temp[6] + temp[7];
            if (!letters.matches("[a-zA-ZΑ-Ωα-ω]+")) {
                throw new IllegalArgumentException("IllegalArgumentException: Invalid Arguments for Police Identity.");
            }
            if (!numbers.matches("[0-9]+")) {
                throw new IllegalArgumentException("IllegalArgumentException: Invalid Arguments for Police Identity.(Example for valid ID is <AB 123456>");
            }
        } else {
            throw new IllegalArgumentException("IllegalArgumentException: Too much or few Arguments for Police Identity.(Valid length is 8).");
        }
        this.AT = letters + " " + numbers;
    }

    private void validFirstName() {
        try {
            if (!this.fName.matches("[a-zA-ZΑ-Ωα-ω]+")) {
                throw new IllegalArgumentException("IllegalArgumentException: Invalid Argument for First Name.");
            }
        } catch (Exception throwObject) {
            System.out.println(throwObject.getMessage());
            System.exit(0);
        }
    }

    private void validLastName() {
        try {
            if (!this.lName.matches("[a-zA-ZΑ-Ωα-ω]+")) {
                throw new IllegalArgumentException("IllegalArgumentException: Invalid Argument for Last Name.");
            }
        } catch (Exception throwObject) {
            System.out.println(throwObject.getMessage());
            System.exit(0);
        }
    }

    /**
     * Constructor set first/last name and AT
     *
     * @param fName First name
     * @param lName Last name
     * @param AT Police Id
     *
     */
    public Person(String fName, String lName, String AT) {
        this.fName = fName;
        this.lName = lName;
        this.AT = AT;
        this.check();
        numberOfPersons++;
    }

    /**
     * Get first name.
     *
     * @return fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * Get last name.
     *
     * @return lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * Get ID.
     *
     * @return AT
     */
    public String getAT() {
        return AT;
    }

    /**
     * Set new first name
     *
     * @param fName is a new first name
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Set new last name.
     *
     * @param lName the new last name
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * Set new AT.
     *
     * @param AT the new ID
     */
    public void setAT(String AT) {
        this.AT = AT;
    }

    /**
     * Get the number of person
     * @return numberOfPersons
     */
    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    /**
     * Set new number on numberOfPersons
     * @param numberOfPersons stored the new number
     */
    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    /**
     * Print all data of class
     * @return fName lName AT
     */
    public String toString() {
        return (getfName() + " " + getlName() + " <" + getAT() + ">");
    }
}
