package com.hr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "locations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

	@Id
	@NotNull
	@Column(name = "location_id")
	private Long locationId;

	@Column(name = "street_address")
	private String streetAddress;

	@Column(name = "postal_code")
	private String postalCode;

	@NotNull
	@Column(name = "city")
	private String city;

	@Column(name = "state_province")
	private String stateProvince;

	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

}
