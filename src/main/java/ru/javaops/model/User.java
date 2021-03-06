package ru.javaops.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.substringBefore;

/**
 * User: gkislin
 */
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotEmpty
    private String email;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "password")
    @Length(min = 5)
    private String password;

    @Email
    @Size(max = 100)
    @Column(length = 100, unique = true)
    private String gmail;

    @Size(max = 50)
    private String location;

    @Size(max = 50)
    private String phone;

    @Size(max = 100)
    @Column(name = "info_source", length = 100)
    private String infoSource;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "stats_agree")
    private boolean statsAgree;

    @Column(name = "consider_job_offers")
    private Boolean considerJobOffers;

    @Column(name = "relocation_ready")
    private Boolean relocationReady;

    @Column(name = "job_through_topjava")
    private Boolean jobThroughTopjava;

    @Column(name = "under_recruitment")
    private Boolean underRecruitment;

    @Column(name = "resume_url")
    private String resumeUrl;

    @Size
    private String website;

    @Size
    private String company;

    @Size(max = 50)
    private String skype;

    @Size(max = 100)
    private String github;

    @Size(max = 100)
    private String vk;

    @Column(name = "active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean active = true;

    @Column(name = "registered_date", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private Date registeredDate = new Date();

    @Column(name = "activated_date")
    private Date activatedDate;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.LAZY)
    private Set<Role> roles;

    @OneToMany(mappedBy = "group")
    private Set<UserGroup> userGroups;

    public User() {
    }

    public User(String email, String nameSurname, String location, String infoSource, String phone) {
        this(null, email, nameSurname, location, infoSource, phone);
    }

    public User(Integer id, String email, String fullName, String location, String infoSource, String phone) {
        super(id);
        this.email = email;
        this.fullName = fullName;
        this.location = location;
        this.infoSource = infoSource;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return fullName == null ? "" : (substringBefore(capitalize(fullName), " "));
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean activated) {
        this.active = activated;
    }

    public void setActivatedDate(Date activatedDate) {
        this.activatedDate = activatedDate;
    }

    public boolean isActive() {
        return active;
    }

    public Set<Role> getRoles() {
        if (roles == null) {
            roles = EnumSet.noneOf(Role.class);
        }
        return roles;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getInfoSource() {
        return infoSource;
    }

    public String getFullName() {
        return fullName;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getGmail() {
        return gmail;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public String getSkype() {
        return skype;
    }

    public String getWebsite() {
        return website;
    }

    public String getCompany() {
        return company;
    }

    public Boolean isJobThroughTopjava() {
        return jobThroughTopjava;
    }

    public Boolean isUnderRecruitment() {
        return underRecruitment;
    }

    public void setUnderRecruitment(Boolean underRecruitment) {
        this.underRecruitment = underRecruitment;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getResumeUrl() {
        return resumeUrl;
    }

    public String getGithub() {
        return github;
    }

    public String getVk() {
        return vk;
    }

    public Date getRegisteredDate() {
        return registeredDate;
    }

    public Date getActivatedDate() {
        return activatedDate;
    }

    public Boolean isConsiderJobOffers() {
        return considerJobOffers;
    }

    public void setConsiderJobOffers(Boolean considerJobOffers) {
        this.considerJobOffers = considerJobOffers;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setJobThroughTopjava(Boolean jobThroughTopjava) {
        this.jobThroughTopjava = jobThroughTopjava;
    }

    public void setResumeUrl(String resumeUrl) {
        this.resumeUrl = resumeUrl;
    }

    public boolean isStatsAgree() {
        return statsAgree;
    }

    public void setStatsAgree(boolean statsAgree) {
        this.statsAgree = statsAgree;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean isRelocationReady() {
        return relocationReady;
    }

    public void setRelocationReady(Boolean relocationReady) {
        this.relocationReady = relocationReady;
    }

    @Override
    public String toString() {
        return "User (" +
                "id=" + getId() +
                ", email=" + email +
                ", fullName='" + fullName + '\'' +
                ", location=" + location +
                ", infoSource=" + infoSource +
                ')';
    }
}
