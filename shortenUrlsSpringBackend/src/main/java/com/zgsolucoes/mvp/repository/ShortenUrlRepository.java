package com.zgsolucoes.mvp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zgsolucoes.mvp.model.ShortenUrl;

public interface ShortenUrlRepository extends CrudRepository<ShortenUrl, String> {
	List<ShortenUrl> findByCodeForUrl(String codeForUrl);
}
