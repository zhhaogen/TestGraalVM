package cn.zhg.test.graalvm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zhhaogen
 */
public class User {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Integer score;

    /**
     */
    public Long getId() {
        return id;
    }

    /**
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     */
    public String getName() {
        return name;
    }

    /**
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     */
    public String getEmail() {
        return email;
    }

    /**
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     */
    @JsonProperty("hashPassword")
    public String getPassword() {
        return password;
    }

    /**
     */
    @JsonProperty("hashPassword")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     */
    public Integer getScore() {
        return score;
    }

    /**
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}
