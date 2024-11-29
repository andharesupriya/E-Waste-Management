package com.wastemanagement.e_wastemanagement.entity;

import java.sql.Date;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Pickup {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String productname;
private String itemtype;
private String damagepersentage;
private Date pickupdate;
private String description;
@ManyToOne
@JoinColumn(name="userID")
private User user;
@Lob
private byte[] photoes;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getItemtype() {
	return itemtype;
}
public void setItemtype(String itemtype) {
	this.itemtype = itemtype;
}
public String getDamagepersentage() {
	return damagepersentage;
}
public void setDamagepersentage(String damagepersentage) {
	this.damagepersentage = damagepersentage;
}
public Date getPickupdate() {
	return pickupdate;
}
public void setPickupdate(Date pickupdate) {
	this.pickupdate = pickupdate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public byte[] getPhotoes() {
	return photoes;
}
public void setPhotoes(byte[] photoes) {
	this.photoes = photoes;
}
@Override
public String toString() {
	return "Pickup [id=" + id + ", productname=" + productname + ", itemtype=" + itemtype + ", damagepersentage="
			+ damagepersentage + ", pickupdate=" + pickupdate + ", description=" + description + ", user=" + user
			+ ", photoes=" + Arrays.toString(photoes) + "]";
}



}
