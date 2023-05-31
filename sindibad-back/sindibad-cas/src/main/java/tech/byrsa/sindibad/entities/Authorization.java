package tech.byrsa.sindibad.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Entity
@Table(name = "`authorization`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
 
public class Authorization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private String id;
	private String registeredClientId;
	private String principalName;
	private String authorizationGrantType;
	@Column(length = 1000)
	private String authorizedScopes;
	@Column(length = 4000)
	private String attributes;
	@Column(length = 500)
	private String state;

	@Column(length = 4000)
	private String authorizationCodeValue;
	private Instant authorizationCodeIssuedAt;
	private Instant authorizationCodeExpiresAt;
	private String authorizationCodeMetadata;

	@Column(length = 4000)
	private String accessTokenValue;
	private Instant accessTokenIssuedAt;
	private Instant accessTokenExpiresAt;
	@Column(length = 2000)
	private String accessTokenMetadata;
	private String accessTokenType;
	@Column(length = 1000)
	private String accessTokenScopes;

	@Column(length = 4000)
	private String refreshTokenValue;
	private Instant refreshTokenIssuedAt;
	private Instant refreshTokenExpiresAt;
	@Column(length = 2000)
	private String refreshTokenMetadata;

	@Column(length = 4000)
	private String oidcIdTokenValue;
	private Instant oidcIdTokenIssuedAt;
	private Instant oidcIdTokenExpiresAt;
	@Column(length = 2000)
	private String oidcIdTokenMetadata;
	@Column(length = 2000)
	private String oidcIdTokenClaims;

	
}

