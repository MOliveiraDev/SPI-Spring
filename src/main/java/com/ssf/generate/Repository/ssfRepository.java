package com.ssf.generate.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ssf.generate.Model.ssfModel;

public interface ssfRepository extends JpaRepository<ssfModel, Long> {

}
