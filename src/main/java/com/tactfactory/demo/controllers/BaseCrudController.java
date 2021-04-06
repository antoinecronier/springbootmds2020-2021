package com.tactfactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tactfactory.demo.entities.BaseEntity;

public abstract class BaseCrudController<T extends BaseEntity> {

    protected static final String INDEX_ROUTE = "/index";
    protected static final String CREATE_ROUTE = "/create";
    protected static final String DETAILS_ROUTE = "/details/{id}";
    protected static final String DETAILS_TEMPLATE = "/details";

    private final String TEMPLATE_NAME;
    protected final String REDIRECT_INDEX;

    public BaseCrudController(String templateName) {
        this.TEMPLATE_NAME = templateName;
        this.REDIRECT_INDEX = "redirect:" + "/" + this.TEMPLATE_NAME + INDEX_ROUTE;
    }

    @Autowired
    private JpaRepository<T, Long> repository;

    @GetMapping(value = {"", "/", INDEX_ROUTE})
    public String index(final Model model) {

        model.addAttribute("items", repository.findAll());

        return "/" + this.TEMPLATE_NAME + INDEX_ROUTE;
    }

    @GetMapping(value = {CREATE_ROUTE})
    public String createGet(final Model model) {

        return "/" + this.TEMPLATE_NAME + CREATE_ROUTE;
    }

    @PostMapping(value = {CREATE_ROUTE})
    public String createPost(final T item) {

        this.repository.save(item);

        return this.REDIRECT_INDEX;
    }

    @GetMapping(value = {DETAILS_ROUTE})
    public String details(@PathVariable final Long id, final Model model) {
        String result = this.REDIRECT_INDEX;

        T item = this.repository.findById(id).orElse(null);

        if (item != null) {
            model.addAttribute("item", item);
            result = "/" + this.TEMPLATE_NAME + DETAILS_TEMPLATE;
        }

        return result;
    }
}
