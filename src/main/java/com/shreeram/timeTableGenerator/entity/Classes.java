package com.shreeram.timeTableGenerator.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Classes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classes {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "ID")
	    private Long id;

	   @Column(name = "name")
	    private String name;
	    
	    @Column(name="label")
	    private String label;

	    @Column(name = "grade")
	    private int grade;


	    @Column(name = "peopleTakingCourse")
	    private int peopleTakingCourse;
	    

	    @OneToMany(mappedBy = "lesson", fetch = FetchType.EAGER)
	    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	    private Collection<Module> modules = new ArrayList<>();
	    
	    @ManyToOne
	    @JoinColumn(name="semester")
	    private Semester semester;
	    
	    @ManyToOne
	    @JoinColumn(name="major")
	    private Major major;

	    
}



