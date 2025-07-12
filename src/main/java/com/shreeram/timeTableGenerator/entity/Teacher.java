package com.shreeram.timeTableGenerator.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@DiscriminatorValue("TEACHER")
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends User {
	
	@ToString.Exclude
    @OneToMany(mappedBy = "teacher", fetch = FetchType.EAGER)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<NotAvailable> notAvailables = new ArrayList<>();
	
	@ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ModuleElement> moduleElements = new ArrayList<>();
}
