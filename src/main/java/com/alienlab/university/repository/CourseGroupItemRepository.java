package com.alienlab.university.repository;

import com.alienlab.university.domain.BaseCourse;
import com.alienlab.university.domain.CourseGroup;
import com.alienlab.university.domain.CourseGroupItem;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.util.List;


/**
 * Spring Data JPA repository for the CourseGroupItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CourseGroupItemRepository extends JpaRepository<CourseGroupItem,Long> {
    List<CourseGroupItem> findItemByGroup(CourseGroup courseGroup);

    void deleteItemByGroupAndCourse(CourseGroup courseGroup, BaseCourse baseCourse);
}
