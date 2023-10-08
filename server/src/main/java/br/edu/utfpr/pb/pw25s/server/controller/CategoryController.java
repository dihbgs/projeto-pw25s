package br.edu.utfpr.pb.pw25s.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.pw25s.server.model.Category;
import br.edu.utfpr.pb.pw25s.server.service.CategoryService;
import br.edu.utfpr.pb.pw25s.server.service.CrudService;

@RestController
@RequestMapping("category")
public class CategoryController extends CrudController<Category, Long> {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    protected CrudService<Category, Long> getService() {
        return this.categoryService;
    }
}
