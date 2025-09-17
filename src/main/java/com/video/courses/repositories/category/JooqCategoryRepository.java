package com.video.courses.repositories.category;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.video.courses.models.Tables.CATEGORIES;

@Repository
public class JooqCategoryRepository implements CategoryRepository{

    @Autowired
    private DSLContext dslContext;

    @Override
    public boolean isCategoryExists(long categoryId) {

        return dslContext.fetchExists(
                dslContext.selectFrom(CATEGORIES)
                        .where(CATEGORIES.ID.eq(Math.toIntExact(categoryId)))
        );
    }
}
