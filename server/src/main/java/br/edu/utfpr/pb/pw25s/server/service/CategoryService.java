package br.edu.utfpr.pb.pw25s.server.service;

import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.utfpr.pb.pw25s.server.repository.CategoryRepository;
import br.edu.utfpr.pb.pw25s.server.model.Category;

@Service
public class CategoryService extends CrudService<Category, Long> {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    protected JpaRepository<Category, Long> getRepository() {
        return this.categoryRepository;
    }

}
