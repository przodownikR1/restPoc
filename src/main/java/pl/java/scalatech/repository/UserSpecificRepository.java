package pl.java.scalatech.repository;

import java.io.Serializable;
import java.util.Map;

import pl.java.scalatech.entity.common.PKEntity;

public interface UserSpecificRepository<T extends PKEntity<K>,K extends Serializable> {
    T getResult(Map<String,String> map);
}
