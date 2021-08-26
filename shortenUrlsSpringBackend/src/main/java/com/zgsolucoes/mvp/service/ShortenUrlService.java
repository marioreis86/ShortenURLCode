package com.zgsolucoes.mvp.service;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ShortenUrlService {
	
	public String getNewFiveRandomChars(Set<String> codesAlreadyRegistred) {
		StringBuilder chars = new StringBuilder();
		String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		boolean charsEqualCodes = true;
		
		do {
			for (int i = 0; i < 5; i++)
				chars.append(allChars.charAt((int) Math.floor(Math.random() * allChars.length())));
			
			charsEqualCodes = codesAlreadyRegistred.contains(chars.toString());
		} while(charsEqualCodes);
		
		return chars.toString();
	}
}
