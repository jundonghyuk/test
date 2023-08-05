package com.test.database.api;

public class MemberDto {

    private Long id;
    private String name;

    public MemberDto() {
    }

    public MemberDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
