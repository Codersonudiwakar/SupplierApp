package com.Supplier.app;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    private String companyName;
    private String website;
    private String location;

    @Enumerated(EnumType.STRING)
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection
    @CollectionTable(name = "supplier_processes", joinColumns = @JoinColumn(name = "supplier_id"))
    @Column(name = "process")
    private Set<String> manufacturingProcesses;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(Long supplierId, String companyName, String website, String location,
			NatureOfBusiness natureOfBusiness, Set<String> manufacturingProcesses) {
		super();
		this.supplierId = supplierId;
		this.companyName = companyName;
		this.website = website;
		this.location = location;
		this.natureOfBusiness = natureOfBusiness;
		this.manufacturingProcesses = manufacturingProcesses;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public NatureOfBusiness getNatureOfBusiness() {
		return natureOfBusiness;
	}

	public void setNatureOfBusiness(NatureOfBusiness natureOfBusiness) {
		this.natureOfBusiness = natureOfBusiness;
	}

	public Set<String> getManufacturingProcesses() {
		return manufacturingProcesses;
	}

	public void setManufacturingProcesses(Set<String> manufacturingProcesses) {
		this.manufacturingProcesses = manufacturingProcesses;
	}
}

