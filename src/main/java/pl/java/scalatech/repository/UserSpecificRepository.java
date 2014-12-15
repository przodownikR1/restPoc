package pl.java.scalatech.repository;

import java.util.Map;

import pl.java.scalatech.entity.common.PKEntity;

public interface UserSpecificRepository<T extends PKEntity> {
    T getResult(Map<String,String> map);
}
