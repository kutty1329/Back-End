package BikeService.ZealousBikeServiceProject;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class ServiceDetails 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int bikeJobcardno;
	private String[] bikeIssue;
	@JsonFormat(pattern = ("yyy-mm-dd"))
	private Date bikeDateofservice;
	private int bikekilometer;
	private String bikeStatus;
	private String bikeTypeofservice;
	private int bikeEstimatecharge;
	@Override
	public String toString() {
		return "ServiceDetails [bikeJobcardno=" + bikeJobcardno + ", bikeIssue=" + Arrays.toString(bikeIssue)
				+ ", bikeDateofservice=" + bikeDateofservice + ", bikekilometer=" + bikekilometer + ", bikeStatus="
				+ bikeStatus + ", bikeTypeofservice=" + bikeTypeofservice + ", bikeEstimatecharge=" + bikeEstimatecharge
				+ ", bikeNewproductcost=" + bikeNewproductcost + ", bikeLabourcharge=" + bikeLabourcharge
				+ ", bikeFinalamount=" + bikeFinalamount + ", Bikedetails1=" + bikeDetails1 + "]";
	}
	private int bikeNewproductcost;
	private int bikeLabourcharge;
	@Column(name="bikeTotalamount")
	private int bikeFinalamount;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="bikeCustomerid")
	private BikeDetails bikeDetails1;
	public ServiceDetails(int bikeJobcardno, String[] bikeIssue, Date bikeDateofservice, int bikekilometer,
			String bikeStatus, String bikeTypeofservice, int bikeEstimatecharge, int bikeNewproductcost,
			int bikeLabourcharge, int bikeFinalamount, BikeDetails bikedetails1) {
		super();
		this.bikeJobcardno = bikeJobcardno;
		this.bikeIssue = bikeIssue;
		this.bikeDateofservice = bikeDateofservice;
		this.bikekilometer = bikekilometer;
		this.bikeStatus = bikeStatus;
		this.bikeTypeofservice = bikeTypeofservice;
		this.bikeEstimatecharge = bikeEstimatecharge;
		this.bikeNewproductcost = bikeNewproductcost;
		this.bikeLabourcharge = bikeLabourcharge;
		this.bikeFinalamount = bikeFinalamount;
		bikeDetails1 = bikeDetails1;
	}
	public ServiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBikeJobcardno() {
		return bikeJobcardno;
	}
	public void setBikeJobcardno(int bikeJobcardno) {
		this.bikeJobcardno = bikeJobcardno;
	}
	public String[] getBikeIssue() {
		return bikeIssue;
	}
	public void setBikeIssue(String[] bikeIssue) {
		this.bikeIssue = bikeIssue;
	}
	public Date getBikeDateofservice() {
		return bikeDateofservice;
	}
	public void setBikeDateofservice(Date bikeDateofservice) {
		this.bikeDateofservice = bikeDateofservice;
	}
	public int getBikekilometer() {
		return bikekilometer;
	}
	public void setBikekilometer(int bikekilometer) {
		this.bikekilometer = bikekilometer;
	}
	public String getBikeStatus() {
		return bikeStatus;
	}
	public void setBikeStatus(String bikeStatus) {
		this.bikeStatus = bikeStatus;
	}
	public String getBikeTypeofservice() {
		return bikeTypeofservice;
	}
	public void setBikeTypeofservice(String bikeTypeofservice) {
		this.bikeTypeofservice = bikeTypeofservice;
	}
	public int getBikeEstimatecharge() {
		return bikeEstimatecharge;
	}
	public void setBikeEstimatecharge(int bikeEstimatecharge) {
		this.bikeEstimatecharge = bikeEstimatecharge;
	}
	public int getBikeNewproductcost() {
		return bikeNewproductcost;
	}
	public void setBikeNewproductcost(int bikeNewproductcost) {
		this.bikeNewproductcost = bikeNewproductcost;
	}
	public int getBikeLabourcharge() {
		return bikeLabourcharge;
	}
	public void setBikeLabourcharge(int bikeLabourcharge) {
		this.bikeLabourcharge = bikeLabourcharge;
	}
	public int getBikeFinalamount() {
		return bikeFinalamount;
	}
	public void setBikeFinalamount(int bikeFinalamount) {
		this.bikeFinalamount = bikeFinalamount;
	}
	public BikeDetails getBikedetails1() {
		return bikeDetails1;
	}
	public void setBikedetails1(BikeDetails bikedetails1) {
		bikeDetails1 = bikedetails1;
	}
	

}
