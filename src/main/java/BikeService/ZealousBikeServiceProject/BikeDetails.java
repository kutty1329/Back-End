package BikeService.ZealousBikeServiceProject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.JoinColumn;



;


@Entity

 class BikeDetails {
	

@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int cusId;
	private String cusName;
	private long cusContact;
	private String cusEmailid;
	private String cusBikeno;
	@JsonFormat(pattern = ("yyyy-mm-dd"))
	private Date cusDatepurchase;
	@OneToMany(cascade =CascadeType.ALL,fetch =FetchType.LAZY)
	@org.springframework.lang.Nullable
	@JsonBackReference
	@javax.persistence.JoinTable(name="Allrecords",joinColumns=@JoinColumn(name="CustomerId"),inverseJoinColumns=@JoinColumn(name="Servicejobcardno"))
	private Collection<ServiceDetails>myservicedetails=new ArrayList<ServiceDetails>();
	public BikeDetails(int cusId, String cusName, long cusContact, String cusEmailid, String cusBikeno,
			Date cusDatepurchase, Collection<ServiceDetails> myservicedetails) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusContact = cusContact;
		this.cusEmailid = cusEmailid;
		this.cusBikeno = cusBikeno;
		this.cusDatepurchase = cusDatepurchase;
		this.myservicedetails = myservicedetails;
	}
	@Override
	public String toString() {
		return "BikeDetails [cusId=" + cusId + ", cusName=" + cusName + ", cusContact=" + cusContact + ", cusEmailid="
				+ cusEmailid + ", cusBikeno=" + cusBikeno + ", cusDatepurchase=" + cusDatepurchase
				+ ", myservicedetails=" + myservicedetails + "]";
	}
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public long getCusContact() {
		return cusContact;
	}
	public void setCusContact(long cusContact) {
		this.cusContact = cusContact;
	}
	public String getCusEmailid() {
		return cusEmailid;
	}
	public void setCusEmailid(String cusEmailid) {
		this.cusEmailid = cusEmailid;
	}
	public String getCusBikeno() {
		return cusBikeno;
	}
	public void setCusBikeno(String cusBikeno) {
		this.cusBikeno = cusBikeno;
	}
	public Date getCusDatepurchase() {
		return cusDatepurchase;
	}
	public void setCusDatepurchase(Date cusDatepurchase) {
		this.cusDatepurchase = cusDatepurchase;
	}
	public Collection<ServiceDetails> getMyservicedetails() {
		return myservicedetails;
	}
	public void setMyservicedetails(Collection<ServiceDetails> myservicedetails) {
		this.myservicedetails = myservicedetails;
	}
	public BikeDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
}
