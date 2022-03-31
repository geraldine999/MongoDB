package com.example.mongodb;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.io.Serializable;
import java.util.List;

@Repository
@RepositoryRestResource(path = "pos-models")
@CrossOrigin(value = {})
public interface POSModelRepository extends MongoRepository<POSModel, Serializable> {

    @RestResource(path = "find-model", rel = "find-model")
    //http://localhost:8080/api/pos-models/search/find-model?name=Model 1
    List<POSModel> findByName(@Param("name") String name, Pageable pageable);

    //http://localhost:8080/api/pos-models/
    //http://localhost:8080/api/pos-models/search/

}
