package com.metier;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name="typecharge")
public class TypeCharge {


	public TypeCharge() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setCodeTypeCharge(int codeTypeCharge) {
		this.codeTypeCharge = codeTypeCharge;
	}
	@Id
	@GeneratedValue
	@Column(name="codeTypeCharge")
	private int codeTypeCharge;
	@Column(name="libelleTypeCharge")
	private String libelleTypeCharge;
	@Column(name="puissanceTypeCharge")
	private int puissanceTypeCharge;
	@OneToMany
	@JoinColumn(name="idStation")
	private List<Borne> lesBornes;
	public TypeCharge(int codeTypeCharge, String libelleTypeCharge,
			int puissanceTypeCharge) {
		super();
		this.codeTypeCharge = codeTypeCharge;
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissanceTypeCharge = puissanceTypeCharge;
		lesBornes = new ArrayList<Borne>();
	}
	
	public TypeCharge(String libelleTypeCharge, int puissanceTypeCharge) {
		super();
		this.libelleTypeCharge = libelleTypeCharge;
		this.puissanceTypeCharge = puissanceTypeCharge;
	}
	
	public List<Borne> getLeParcBorne() {
		return lesBornes;
	}

	public void setLeParcBorne(List<Borne> lesBornes) {
		this.lesBornes = lesBornes;
	}

	public String getLibelleTypeCharge() {
		return libelleTypeCharge;
	}
	public void setLibelleTypeCharge(String libelleTypeCharge) {
		this.libelleTypeCharge = libelleTypeCharge;
	}
	public int getPuissanceTypeCharge() {
		return puissanceTypeCharge;
	}
	public void setPuissanceTypeCharge(int puissanceTypeCharge) {
		this.puissanceTypeCharge = puissanceTypeCharge;
	}
	public int getCodeTypeCharge() {
		return codeTypeCharge;
	}
	@Override
	public String toString() {
		return "TypeCharge [codeTypeCharge=" + codeTypeCharge
				+ ", libelleTypeCharge=" + libelleTypeCharge
				+ ", puissanceTypeCharge=" + puissanceTypeCharge + "]";
	}
}
