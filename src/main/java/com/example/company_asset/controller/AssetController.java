package com.example.company_asset.controller;


import com.example.company_asset.model.Asset;
import com.example.company_asset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AssetController {

    @Autowired
    AssetService assetService;

    @GetMapping("/assets")
    public List<Asset> getAssets(){
        return assetService.getAssets();
    }

    @GetMapping("/assets/{asset_id}")
    public Optional<Asset> getSingleAsset(@PathVariable int asset_id)
    {
        return assetService.getSingleAsset(asset_id);
    }

    @PostMapping("/assets")
    public String addAssets(@RequestBody Asset a)
    {
        return assetService.addAssets(a);
    }

    @DeleteMapping("/assets/{asset_id}")
    public String deleteAssets(@PathVariable int asset_id)
    {
        return assetService.deleteAssets(asset_id);
    }

}
