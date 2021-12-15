package com.example.breakingbad.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterModel {

    @SerializedName("char_id")
    @Expose
    private Integer charId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("occupation")
    @Expose
    private List<String> occupation = null;
    @SerializedName("img")
    @Expose
    private String img;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("nickname")
    @Expose
    private String nickname;

    public CharacterModel(Integer charId, String name, String birthday, List<String> occupation, String img, String status, String nickname) {
        this.charId = charId;
        this.name = name;
        this.birthday = birthday;
        this.occupation = occupation;
        this.img = img;
        this.status = status;
        this.nickname = nickname;
    }

    public Integer getCharId() {
        return charId;
    }

    public void setCharId(Integer charId) {
        this.charId = charId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public void setOccupation(List<String> occupation) {
        this.occupation = occupation;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

