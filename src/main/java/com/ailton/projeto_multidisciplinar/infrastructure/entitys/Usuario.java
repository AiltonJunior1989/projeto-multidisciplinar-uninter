package com.ailton.projeto_multidisciplinar.infrastructure.entitys;

import com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// getter e setter para acessar ou modificar os atributos
@Getter
@Setter
//@AllArgsConstructor, @NoArgsConstructor para acessar a classe.
@AllArgsConstructor
@NoArgsConstructor
//Implementa o padrão de projeto Builder para facilitar
//a criação de objetos de forma fluente.
@Builder
//@Table para colocar o nome da tabela no banco de dados
@Table(name = "usuario")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //UM CLIENTE PODE TER VÁRIOS PEDIDOS


    //nullable = false quer dizer que este campo será obrigatório o preenchimento de valor
    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "telefone")
    private String telefone;

    //unique = true quer dizer que a coluna cpf não poderá conter valor repetido com outro usuário do mesmo cpf
    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @CreationTimestamp
    @Column(name = "criado_em", nullable = false, updatable = false)
    private LocalDateTime criado_em;

    public Usuario(String nome, String telefone, String cpf, String password, UserRole role){
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.password = password;
        this.role = role;
    }


    //@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //OneToMany quer dizer que será uma relação de 1 usuário para muitos pedidos
    @OneToMany(mappedBy = "usuario") //, fetch = FetchType.LAZY
     //criado a relação de muitos pedidos no campo abaixo
    //O Set é parecido com o list que cria uma coleção, mas não aceita dados repetidos
    private Set<Pedido> pedidos = new HashSet<>();

    //Método que o Spring Security consulta uma entidade para saber quais são as roles que tal usuário tem.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
