package com.oralce.web.bean;

public class School {
    private Integer schoolId;

    private String name;

    private String address;

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", name=" + name + ", address=" + address + "]";
	}
    
}