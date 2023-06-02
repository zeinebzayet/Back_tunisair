package Tunisair.security.services;

import Tunisair.entity.User;
import Tunisair.enums.TRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//to get more user details
public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    private Long cin;
    private String username;
    private String email;
    private String tel;
    @JsonIgnore
    private String password;

    private TRole role;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long cin, String username, String email, String tel, String password,TRole role) {
        this.cin = cin;
        this.username = username;
        this.email = email;
        this.tel = tel;
        this.password = password;
        this.role = role;
    }

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(
                user.getCin(),
                user.getUsername(),
                user.getEmail(),
                user.getTel(),
                user.getPassword(),
                user.getRole());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Long getCin() {
        return cin;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public TRole getRole() {
        return role;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(cin, user.cin);
    }
}
