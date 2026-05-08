package com.ailton.projeto_multidisciplinar.infrastructure.entitys.enums;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    //atributo
    private String role;

    //construtor
    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
