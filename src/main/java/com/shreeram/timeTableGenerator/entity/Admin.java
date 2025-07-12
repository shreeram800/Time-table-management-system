package com.shreeram.timeTableGenerator.entity;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("ADMIN")
public class Admin extends User{
	
	@OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<NotAvailable> notAvailables = new ArrayList<>();
	
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Collection<ModuleElement> moduleElements = new ArrayList<>();

}
