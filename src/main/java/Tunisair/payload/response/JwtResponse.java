package Tunisair.payload.response;


import Tunisair.enums.TRole;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long cin;
    private String username;
    private String tel;
    private String email;

    private String password;
    private TRole role;

    public JwtResponse(String token, Long cin, String username, String tel, String email, String password,TRole role) {
        this.token = token;
        this.cin = cin;
        this.username = username;
        this.tel = tel;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TRole getRole() {
        return role;
    }

    public void setRole(TRole role) {
        this.role = role;
    }

}
