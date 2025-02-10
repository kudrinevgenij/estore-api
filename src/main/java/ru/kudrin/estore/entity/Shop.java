package ru.kudrin.estore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "shop")
public class Shop implements Serializable {

	@Id
	@Column(name = "shop_id", nullable = false)
	Long shopId;

	@Column(name = "shop_name", nullable = false)
	String name;

	@Column(name = "address", nullable = false)
	String address;
}
