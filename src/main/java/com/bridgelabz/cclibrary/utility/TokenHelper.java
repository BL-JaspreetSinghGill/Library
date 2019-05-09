package com.bridgelabz.cclibrary.utility;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@PropertySource("classpath:message.properties")
@Slf4j
public class TokenHelper {
	
	@Autowired
	private Environment environment;
	
	public String createJWT(String id, String issuer, String subject, long ttlMillis, String campaignId, String testId, String role) {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(environment.getProperty("token.key"));
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
		
		Map<String, Object> map = new HashMap<>();
		map.put("userId", id);
		map.put("campaignId", campaignId);
		map.put("testId", testId);
		map.put("role", role);
	
		JwtBuilder builder = Jwts.builder().setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.setClaims(map)
				.signWith(signatureAlgorithm, signingKey);

		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		return builder.compact();
	}

	public Claims parseJWT(String jwt)  {
		Claims claims = null;

		try {
			claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(environment.getProperty("token.key"))).parseClaimsJws(jwt)
					.getBody();
			
			log.info("ID: " + claims.getId());
			log.info("Subject: " + claims.getSubject());
			log.info("Issuer: " + claims.getIssuer());
			log.info("Expiration: " + claims.getExpiration());
		} catch (Exception e) {
			log.info(""+e.toString());
			throw new JwtException(environment.getProperty("token.invalid.message"));
		}

		return claims;
	}
}
