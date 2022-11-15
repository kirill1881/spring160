package com.example.spring160.repos;

import com.example.spring160.models.ItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<ItemModel, Long> {
    ItemModel findItemModelById(long id);
    ItemModel findItemModelByDiscAndName(String disc, String name);
    List<ItemModel> findItemModelsByDiscAndName(String disc, String name);
}
