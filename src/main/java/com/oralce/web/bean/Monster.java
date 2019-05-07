package com.oralce.web.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Monster {
    private Integer monsterId;

    private String monstername;

    private String email;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date entryday;

    private Integer schoolFk;

    public Integer getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(Integer monsterId) {
        this.monsterId = monsterId;
    }

    public String getMonstername() {
        return monstername;
    }

    public void setMonstername(String monstername) {
        this.monstername = monstername == null ? null : monstername.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntryday() {
        return entryday;
    }

    public void setEntryday(Date entryday) {
        this.entryday = entryday;
    }

    public Integer getSchoolFk() {
        return schoolFk;
    }

    public void setSchoolFk(Integer schoolFk) {
        this.schoolFk = schoolFk;
    }

	@Override
	public String toString() {
		return "Monster [monsterId=" + monsterId + ", monstername=" + monstername + ", email=" + email + ", birthday="
				+ birthday + ", entryday=" + entryday + ", schoolFk=" + schoolFk + "]";
	}
    
}