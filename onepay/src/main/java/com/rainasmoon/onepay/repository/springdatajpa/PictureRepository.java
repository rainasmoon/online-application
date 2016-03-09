
package com.rainasmoon.onepay.repository.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rainasmoon.onepay.model.Picture;

public interface PictureRepository extends CrudRepository<Picture, Long> {

	@Query("select d from Picture d where d.productId = :productId")
	List<Picture> findPictures(@Param("productId") Long productId);

}
