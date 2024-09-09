package com.rt.entity;

import java.io.Serializable;

import org.springframework.lang.NonNull;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emp_details_india")
@Data
@NoArgsConstructor
public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	
	@Column(name = "name",nullable = false)
	private String ename;
	
	@Column(name = "address",nullable = true,length = 20)
	private String eadd;
	
	@Column(name = "g_salery")
	@Nonnull
	private int grossSalery;
	
	@Column(name = "n_salery")
	@Nonnull
	private int netSalery;
	
	@Column(name = "PF")
	private int pfContribution;
	
	
	
	
}
