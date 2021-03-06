package com.linnyk.jpa.safari.entities.association;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.linnyk.jpa.safari.entities.User;

@Entity
@Table(name = "CREDENTIAL")
public class Credential {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="CREDENTIAL_ID")
	public Long credentialId;

	@OneToOne(cascade = CascadeType.ALL) //во время сохранения CREDENTIAL, сохранится и FINANCES_USER
	@JoinColumn(name = "USER_ID") // FK к другой таблице
	public User user;

	@Column(name="USERNAME")
	private String username;

	@Column(name="PASSWORD")
	private String password;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getCredentialId() {
		return credentialId;
	}

	public void setCredentialId(Long credentialId) {
		this.credentialId = credentialId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Credential{" +
				"credentialId=" + credentialId +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
