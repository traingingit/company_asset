package com.example.company_asset.repository;

import com.example.company_asset.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset,Integer> {


}
