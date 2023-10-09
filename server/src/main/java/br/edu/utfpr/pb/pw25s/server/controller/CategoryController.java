package br.edu.utfpr.pb.pw25s.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.pb.pw25s.server.service.interfaces.DefaultCrudService;
import br.edu.utfpr.pb.pw25s.server.service.CategoryService;
import br.edu.utfpr.pb.pw25s.server.dto.CategoryDTO;
import br.edu.utfpr.pb.pw25s.server.model.Category;

import org.modelmapper.ModelMapper;

@RestController
@RequestMapping("category")
public class CategoryController extends CrudController<Category, CategoryDTO, Long> {
    private final DefaultCrudService<Category, Long> categoryService;
    private final ModelMapper modelMapper;

    public CategoryController(CategoryService categoryService, ModelMapper modelMapper) {
        super(Category.class, CategoryDTO.class);
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    protected DefaultCrudService<Category, Long> getService() {
        return this.categoryService;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return this.modelMapper;
    }
}
