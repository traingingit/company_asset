package com.example.company_asset.service;

import com.example.company_asset.model.Asset;
import com.example.company_asset.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepository;
    public List<Asset> getAssets() {
        return assetRepository.findAll();
    }

    public String addAssets(Asset a) {
        assetRepository.save(a);
        return "Assets added successfully";
    }

    public String deleteAssets(int asset_id) {
        assetRepository.deleteById(asset_id);
        return "Asset Deleted";
    }
}
