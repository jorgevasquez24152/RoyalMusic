package Model.pojo;

public class User {

    private int id_user;
    private String identification_type;
    private String identification_number;
    private String firstname;
    private String middlename;
    private String lastname;
    private String second_lastname;
    private String phone_number;
    private String email;
    private String username;
    private String password;
    private int profile;

    
    /**
     * Constructor sin argumentos
     */
    public User() {
    }

    /**
     * Constructor solo con los argumentos username y password para login
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor con todos los argumentos definidos en la Base de Datos
     */
    public User(int id_user, String identification_type, String identification_number, String firstname, String middlename, String lastname, String second_lastname, String phone_number, String email, String username, String password, int profile) {
        this.id_user = id_user;
        this.identification_type = identification_type;
        this.identification_number = identification_number;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.second_lastname = second_lastname;
        this.phone_number = phone_number;
        this.email = email;
        this.username = username;
        this.password = password;
        this.profile = profile;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getIdentification_type() {
        return identification_type;
    }

    public void setIdentification_type(String identification_type) {
        this.identification_type = identification_type;
    }

    public String getIdentification_number() {
        return identification_number;
    }

    public void setIdentification_number(String identification_number) {
        this.identification_number = identification_number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecond_lastname() {
        return second_lastname;
    }

    public void setSecond_lastname(String second_lastname) {
        this.second_lastname = second_lastname;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", identification_type=" + identification_type + ", identification_number=" + identification_number + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", second_lastname=" + second_lastname + ", phone_number=" + phone_number + ", email=" + email + ", username=" + username + ", password=" + password + ", profile=" + profile + '}';
    }

}
