package com.evaluation.me.entity;

import com.evaluation.me.validators.ValidEmail;
import com.evaluation.me.validators.ValidPassword;
import java.util.Collection;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "useruuid")
    @GenericGenerator(name = "uuid", strategy = "uuid4")
    private Long useruuid;
    private String name;
    @ValidEmail
    private String email;

    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.getEmail();
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
}
