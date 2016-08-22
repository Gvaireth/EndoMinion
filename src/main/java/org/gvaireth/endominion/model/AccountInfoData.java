package org.gvaireth.endominion.model;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.moomeen.endo2java.model.Sex;
import com.moomeen.endo2java.model.Sport;

public class AccountInfoData implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer weight;
	private String phone;
	private Sex sex;
	private DateTime syncTime;
	private DateTime dateOfBirth;
	private Boolean loungeMember;
	private Sport favoriteSportEnum;
	private Sport favoriteSport2Enum;
	private String units;
	private String country;
	private Long id;
	private String firstName;
	private String lastName;
	private Long pictureId;
	private DateTime weightTime;
	private Integer height;
	private DateTime createdTime;
	private DateTimeZone timeZone;

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public DateTime getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(DateTime syncTime) {
		this.syncTime = syncTime;
	}

	public DateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(DateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getLoungeMember() {
		return loungeMember;
	}

	public void setLoungeMember(Boolean loungeMember) {
		this.loungeMember = loungeMember;
	}

	public Sport getFavoriteSportEnum() {
		return favoriteSportEnum;
	}

	public void setFavoriteSportEnum(Sport favoriteSport) {
		this.favoriteSportEnum = favoriteSport;
	}

	public String getFavoriteSport() {
		return favoriteSportEnum.description();
	}

	public Sport getFavoriteSport2Enum() {
		return favoriteSport2Enum;
	}

	public void setFavoriteSport2Enum(Sport favoriteSport2) {
		this.favoriteSport2Enum = favoriteSport2;
	}

	public String getFavoriteSport2() {
		return favoriteSport2Enum.description();
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPictureId() {
		return pictureId;
	}

	public void setPictureId(Long pictureId) {
		this.pictureId = pictureId;
	}

	public DateTime getWeightTime() {
		return weightTime;
	}

	public void setWeightTime(DateTime weightTime) {
		this.weightTime = weightTime;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public DateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(DateTime createdTime) {
		this.createdTime = createdTime;
	}

	public DateTimeZone getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(DateTimeZone timeZone) {
		this.timeZone = timeZone;
	}

	@Override
	public String toString() {
		return "AccountInfoData [weight=" + weight + ", phone=" + phone + ", sex=" + sex + ", syncTime=" + syncTime
				+ ", dateOfBirth=" + dateOfBirth + ", loungeMember=" + loungeMember + ", favoriteSport="
				+ favoriteSportEnum + ", favoriteSport2=" + favoriteSport2Enum + ", units=" + units + ", country="
				+ country + ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", pictureId="
				+ pictureId + ", weightTime=" + weightTime + ", height=" + height + ", createdTime=" + createdTime
				+ ", timeZone=" + timeZone + "]";
	}

}
