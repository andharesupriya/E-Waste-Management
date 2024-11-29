package com.wastemanagement.e_wastemanagement.corprativeentity;

import java.sql.Date;
import java.util.Arrays;

import com.wastemanagement.e_wastemanagement.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class PickupCorprater {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private String productname;
private String itemtype;
private String damagepersentage;
private Date pickupdate;
private String description;
@Lob
private byte photo[];
@ManyToOne
@JoinColumn(name="userId")
private Corprative corprative;
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
public byte[] getPhoto() {
	return photo;
}
public void setPhoto(byte[] photo) {
	this.photo = photo;
}
public Corprative getCorprative() {
	return corprative;
}
public void setCorprative(Corprative corprative) {
	this.corprative = corprative;
}
@Override
public String toString() {
	return "PickupCorprater [id=" + id + ", productname=" + productname + ", itemtype=" + itemtype
			+ ", damagepersentage=" + damagepersentage + ", pickupdate=" + pickupdate + ", description=" + description
			+ ", photo=" + Arrays.toString(photo) + ", corprative=" + corprative + "]";
}

}
