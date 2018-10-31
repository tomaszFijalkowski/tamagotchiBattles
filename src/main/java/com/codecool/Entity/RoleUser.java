package com.codecool.Entity;


import javax.persistence.*;


    @Entity
    @Table(name = "role")
    public class RoleUser {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "role_id")
        private int roleId;

        @Column(name = "role")
        private String role;

        public RoleUser() {
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }



