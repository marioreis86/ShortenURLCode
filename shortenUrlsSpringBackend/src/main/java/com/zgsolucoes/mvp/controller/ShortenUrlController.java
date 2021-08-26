package com.zgsolucoes.mvp.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zgsolucoes.mvp.model.ShortenUrl;
import com.zgsolucoes.mvp.repository.ShortenUrlRepository;
import com.zgsolucoes.mvp.service.ShortenUrlService;

@RestController("/")
public class ShortenUrlController {

	@Autowired
	ShortenUrlService shortenUrlService;

	@Autowired
	ShortenUrlRepository shortenUrlRepository;

	private static final String DOMAIN = "zg.com.br";

	@GetMapping("teste")
	public ResponseEntity<String> teste() {
		return ResponseEntity.ok().body("Deu tudo certo");
	}

	@PostMapping("generateShortUrl")
	public ResponseEntity<ShortenUrl> generateShortUrl(@Valid @RequestBody @URL String longUrl)
			throws MalformedURLException {

		Set<String> shortUrls = StreamSupport.stream(shortenUrlRepository.findAll().spliterator(), false)
				.map(url -> url.getCodeForUrl()).collect(Collectors.toSet());

		String urlCode = shortenUrlService.getNewFiveRandomChars(shortUrls);
		ShortenUrl shortenUrl = shortenUrlRepository.save(new ShortenUrl(urlCode, longUrl));

		return ResponseEntity.ok().body(shortenUrl);
	}

	@GetMapping("{codeUrl}")
	public void redirectToPage(HttpServletResponse response,
			@PathVariable(required = true, name = "codeUrl") String codeUrl) throws IOException {

		System.out.println("codeUrl:" + codeUrl);

		List<ShortenUrl> urls = shortenUrlRepository.findByCodeForUrl(codeUrl);
		System.out.println("urls (length):" + urls.size());
		ShortenUrl finded = urls.stream().findFirst().orElseThrow();

		System.out.printf("Url de encurtada: %s/%s", DOMAIN, finded.getCodeForUrl());
		System.out.println("Url de destino:" + finded.getLongUrl());
		response.sendRedirect(finded.getLongUrl());
	}
}
