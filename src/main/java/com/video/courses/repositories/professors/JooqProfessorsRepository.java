package com.video.courses.repositories.professors;

import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import static com.video.courses.models.Tables.PROFESSORS;

@Repository
public class JooqProfessorsRepository implements ProfessorsRepository{

    private final DSLContext dslContext;

    public JooqProfessorsRepository(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public boolean isProfessorExists(Long professorId) {

        return dslContext.fetchExists(
                dslContext.selectFrom(PROFESSORS)
                        .where(PROFESSORS.ID.eq(professorId))
        );

    }
}
