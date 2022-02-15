package com.example.company_asset.service;

import com.example.company_asset.model.Asset;
import com.example.company_asset.repository.AssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetService {

    @Autowired
    AssetRepository assetRepository;

    public List<Asset> getAssets() {
        return assetRepository.findAll();
    }

    public Optional<Asset> getSingleAsset(int asset_id)
    {
        return assetRepository.findById(asset_id);
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
