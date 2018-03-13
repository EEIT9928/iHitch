package model.bean;
// default package

// Generated 2018/2/14 �U�� 01:34:38 by Hibernate Tools 5.2.8.Final

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Member generated by hbm2java
 */
@Entity
@Table(name = "Member", schema = "dbo", catalog = "iHitch", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Member implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer mid;
	private String email;
	private String pwd;
	private String firstName;
	private String lastName;
	private Character gender;
	private String country;
	private Integer birthYear;
	private Blob photo;
	private String phone;
	private String bio;
	private Blob licensePhoto;
	private Boolean phoneVerified;
	private Boolean emailVerified;
	private Boolean licenseVerified;
	private Integer prefPaPet;
	private Integer prefPaSmoke;
	private Integer prefPaTalk;
	private Integer prefPaMusic;
	private Integer prefDrPet;
	private Integer prefDrSmoke;
	private Integer prefDrTalk;
	private Integer prefDrMusic;
	private Integer currentLv;
	private Date regisDate;
	private Date lastLog;
	private Integer malPoint;
	private Double rate;
	private Integer rateReceived;
	private Integer ridesOffered;
	// private Set<Car> cars = new HashSet<>(0);
	// private Set alerts = new HashSet(0);
	// private Set blockListsForFromMid = new HashSet(0);
	// private Set faqs = new HashSet(0);
	// private Set chatsForToMid = new HashSet(0);
	// private Set blackListsForFromMid = new HashSet(0);
	// private Set passDetails = new HashSet(0);
	// private Set blackListsForToMid = new HashSet(0);
	// private Set chatsForFromMid = new HashSet(0);
	// private Set rides = new HashSet(0);
	// private Set blockListsForToMid = new HashSet(0);
	// private Set ratesForToMid = new HashSet(0);
	// private Set ratesForFromMid = new HashSet(0);

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", email=" + email + ", pwd=" + pwd + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", country=" + country + ", birthYear=" + birthYear + ", photo="
				+ photo + ", phone=" + phone + ", bio=" + bio + ", licensePhoto=" + licensePhoto + ", phoneVerified="
				+ phoneVerified + ", emailVerified=" + emailVerified + ", licenseVerified=" + licenseVerified
				+ ", prefPaPet=" + prefPaPet + ", prefPaSmoke=" + prefPaSmoke + ", prefPaTalk=" + prefPaTalk
				+ ", prefPaMusic=" + prefPaMusic + ", prefDrPet=" + prefDrPet + ", prefDrSmoke=" + prefDrSmoke
				+ ", prefDrTalk=" + prefDrTalk + ", prefDrMusic=" + prefDrMusic + ", currentLv=" + currentLv
				+ ", regisDate=" + regisDate + ", lastLog=" + lastLog + ", malPoint=" + malPoint + ", rate=" + rate
				+ ", rateReceived=" + rateReceived + ", ridesOffered=" + ridesOffered + "]";
	}

	public Member() {
	}

	public Member(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mid", unique = true, nullable = false)
	public Integer getMid() {
		return this.mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	@Column(name = "email", unique = true, nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "pwd", nullable = false, length = 20)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "firstName", length = 20)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "lastName", length = 20)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "gender", length = 1)
	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	@Column(name = "country", length = 50)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "birthYear")
	public Integer getBirthYear() {
		return this.birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	@Column(name = "photo")
	public Blob getPhoto() {
		return this.photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "bio")
	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Column(name = "licensePhoto")
	public Blob getLicensePhoto() {
		return this.licensePhoto;
	}

	public void setLicensePhoto(Blob licensePhoto) {
		this.licensePhoto = licensePhoto;
	}

	@Column(name = "phoneVerified")
	public Boolean getPhoneVerified() {
		return this.phoneVerified;
	}

	public void setPhoneVerified(Boolean phoneVerified) {
		this.phoneVerified = phoneVerified;
	}

	@Column(name = "emailVerified")
	public Boolean getEmailVerified() {
		return this.emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	@Column(name = "licenseVerified")
	public Boolean getLicenseVerified() {
		return this.licenseVerified;
	}

	public void setLicenseVerified(Boolean licenseVerified) {
		this.licenseVerified = licenseVerified;
	}

	@Column(name = "prefPaPet")
	public Integer getPrefPaPet() {
		return this.prefPaPet;
	}

	public void setPrefPaPet(Integer prefPaPet) {
		this.prefPaPet = prefPaPet;
	}

	@Column(name = "prefPaSmoke")
	public Integer getPrefPaSmoke() {
		return this.prefPaSmoke;
	}

	public void setPrefPaSmoke(Integer prefPaSmoke) {
		this.prefPaSmoke = prefPaSmoke;
	}

	@Column(name = "prefPaTalk")
	public Integer getPrefPaTalk() {
		return this.prefPaTalk;
	}

	public void setPrefPaTalk(Integer prefPaTalk) {
		this.prefPaTalk = prefPaTalk;
	}

	@Column(name = "prefPaMusic")
	public Integer getPrefPaMusic() {
		return this.prefPaMusic;
	}

	public void setPrefPaMusic(Integer prefPaMusic) {
		this.prefPaMusic = prefPaMusic;
	}

	@Column(name = "prefDrPet")
	public Integer getPrefDrPet() {
		return this.prefDrPet;
	}

	public void setPrefDrPet(Integer prefDrPet) {
		this.prefDrPet = prefDrPet;
	}

	@Column(name = "prefDrSmoke")
	public Integer getPrefDrSmoke() {
		return this.prefDrSmoke;
	}

	public void setPrefDrSmoke(Integer prefDrSmoke) {
		this.prefDrSmoke = prefDrSmoke;
	}

	@Column(name = "prefDrTalk")
	public Integer getPrefDrTalk() {
		return this.prefDrTalk;
	}

	public void setPrefDrTalk(Integer prefDrTalk) {
		this.prefDrTalk = prefDrTalk;
	}

	@Column(name = "prefDrMusic")
	public Integer getPrefDrMusic() {
		return this.prefDrMusic;
	}

	public void setPrefDrMusic(Integer prefDrMusic) {
		this.prefDrMusic = prefDrMusic;
	}

	@Column(name = "currentLv")
	public Integer getCurrentLv() {
		return this.currentLv;
	}

	public void setCurrentLv(Integer currentLv) {
		this.currentLv = currentLv;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "regisDate", length = 10)
	public Date getRegisDate() {
		return this.regisDate;
	}

	public void setRegisDate(Date regisDate) {
		this.regisDate = regisDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastLog", length = 23)
	public Date getLastLog() {
		return this.lastLog;
	}

	public void setLastLog(Date lastLog) {
		this.lastLog = lastLog;
	}

	@Column(name = "malPoint")
	public Integer getMalPoint() {
		return this.malPoint;
	}

	public void setMalPoint(Integer malPoint) {
		this.malPoint = malPoint;
	}

	@Column(name = "rate", precision = 18, scale = 0)
	public Double getRate() {
		return this.rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Column(name = "rateReceived")
	public Integer getRateReceived() {
		return this.rateReceived;
	}

	public void setRateReceived(Integer rateReceived) {
		this.rateReceived = rateReceived;
	}

	@Column(name = "ridesOffered")
	public Integer getRidesOffered() {
		return this.ridesOffered;
	}

	public void setRidesOffered(Integer ridesOffered) {
		this.ridesOffered = ridesOffered;
	}

}
