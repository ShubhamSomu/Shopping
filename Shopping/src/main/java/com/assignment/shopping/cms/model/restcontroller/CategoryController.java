package com.assignment.shopping.cms.model.restcontroller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assignment.shopping.cms.model.Category;
import com.assignment.shopping.cms.service.CategoryService;

@RestController
@RequestMapping("/category/")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> retrieveCategoryById(@PathVariable String id) {
		Optional<Category> categoryOpt = categoryService.retrieveCategoryById(id);
		if (categoryOpt.isPresent()) {
			return ResponseEntity.ok().body(categoryOpt.get());
		}

		else {
			return ResponseEntity.notFound().build();

		}
	}

	@GetMapping()
	public ResponseEntity<?> retrieveCategory() {
		List<Category> categoryList= categoryService.retrieveAllCategory();
		if (categoryList==null || categoryList.size() <= 0) {
			
			return ResponseEntity.notFound().build();
		}

		else {
			return ResponseEntity.ok().body(categoryList);

		}
	}
	
	@PostMapping
	public ResponseEntity<?> saveCategory(@RequestBody Category category) {
		Optional<Category> categoryOpt = categoryService.saveCategory(category);
		if (categoryOpt.isPresent()) {
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
					.buildAndExpand(categoryOpt.get().getId()).toUri();
			return ResponseEntity.created(uri).build();

		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
