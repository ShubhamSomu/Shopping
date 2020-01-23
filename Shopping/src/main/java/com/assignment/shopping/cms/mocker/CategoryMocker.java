package com.assignment.shopping.cms.mocker;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.assignment.shopping.cms.model.Filter;
import com.assignment.shopping.cms.model.Banner;
import com.assignment.shopping.cms.model.Category;
import com.assignment.shopping.cms.model.Coordinates;
import com.assignment.shopping.cms.model.FilterItem;
import com.assignment.shopping.cms.service.CategoryService;

@Component
@Order(1)
public class CategoryMocker implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Override
	public void run(String... args) throws Exception {
		CategoryMocker categoryMocker = new CategoryMocker();
		Category category = categoryMocker.getCategory();
		categoryService.saveCategory(category);
	}

	private Banner getFakeBanner() {
		return Banner.builder().id(new ObjectId().toHexString()).
				html("lorem").imageUrl("lorem").linkUrl("lorem")
				.coordinate(getCoordinate())
				.orignalWidth(20).build();
	}

	private FilterItem getFilterItem() {
		return FilterItem.builder().id(new ObjectId().toHexString()).name("lorem").selected("lorem").type("lorem").hasChildren("lorem").build();
	}

	private Filter getFilter() {
		List<FilterItem> filterItemList = new ArrayList<FilterItem>();
		filterItemList.add(getFilterItem());
		return Filter.builder()
				.id(new ObjectId().toHexString())
				.name("lorem").isMenuFiter(true).filterItems(filterItemList).build();
	}

	private Category getCategory() {
		List<Banner> bannerList = new ArrayList<Banner>();
		bannerList.add(getFakeBanner());
		List<Filter> filterList = new ArrayList<Filter>();
		filterList.add(getFilter());

		return Category.builder().banners(bannerList).filters(filterList).name("lorem").tag("lorem")
				.description("lorem").selected(false).build();
	}
	
	private Coordinates getCoordinate() {
		return Coordinates.builder().id(new ObjectId().toHexString())
				.items(20).build();
	}
}
