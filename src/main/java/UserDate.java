public class UserDate {
    //definición de las variables
    String id;
    String username ;
    String firstName ;
    String lastName ;
    String mail ;
    String  password;
    String phone;
    String userStatus;
    String createUser = "user/";
    //Set y Getters

    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
    public void setUser(String identidad, String nombreUsuario, String apell1Usuario, String apell2Usuario, String tlf,
                        String pass, String estado, String email){
        this.setId(identidad);
        this.setUsername(nombreUsuario);
        this.setFirstName(apell1Usuario);
        this.setLastName(apell2Usuario);
        this.setMail(email);
        this.setPassword(pass);
        this.setPhone(tlf);
        this.setUserStatus(estado);
    }

}
