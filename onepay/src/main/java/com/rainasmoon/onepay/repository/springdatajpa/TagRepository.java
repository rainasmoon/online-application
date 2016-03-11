
package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rainasmoon.onepay.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	@Query("select d from Tag d where d.objId=:objId and d.type=:tagType")
	List<Tag> findTags(@Param("objId")Long objId, @Param("tagType")Integer Type);
}
