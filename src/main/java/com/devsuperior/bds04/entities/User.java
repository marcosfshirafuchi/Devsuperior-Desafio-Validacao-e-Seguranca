package com.devsuperior.bds04.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class User implements UserDetails {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(Long id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // getAuthorities(): Retorna a coleção de GrantedAuthority (perfis/roles) concedidas ao usuário.
    // Essencial para o Spring Security determinar as permissões do usuário.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    // getUsername(): Retorna o nome de usuário usado para autenticar o usuário.
    // Neste caso, o email é usado como nome de usuário.
    @Override
    public String getUsername() {
        return email;
    }

    // isAccountNonExpired(): Indica se a conta do usuário expirou. Retorna true para não expirada.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // isAccountNonLocked(): Indica se o usuário está bloqueado ou desbloqueado. Retorna true para não bloqueado.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // isCredentialsNonExpired(): Indica se as credenciais (senha) do usuário expiraram. Retorna true para não expiradas.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // isEnabled(): Indica se o usuário está habilitado ou desabilitado. Retorna true para habilitado.
    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        roles.add(role);
    }

    public boolean hasRoles(String roleName) {
        for (Role role : roles) {
            if (role.getAuthority().equals(roleName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof User user)) return false;

        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}