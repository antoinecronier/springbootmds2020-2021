package com.tactfactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tactfactory.demo.entities.BaseEntity;

public abstract class BaseCrudController<T extends BaseEntity> {

	protected static final String INDEX_ROUTE = "/index";
	private final String TEMPLATE_NAME;

	public BaseCrudController(String templateName) {
		this.TEMPLATE_NAME = templateName;
	}

	@Autowired
	private JpaRepository<T, Long> repository;

	@GetMapping(value = {"", "/", "index"})
	public String index(final Model model) {

		model.addAttribute("items", repository.findAll());

		return "/" + this.TEMPLATE_NAME + INDEX_ROUTE;

	}
}
