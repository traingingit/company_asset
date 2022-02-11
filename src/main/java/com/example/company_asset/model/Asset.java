package com.example.company_asset.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asset {
    @Id
    int assetid;
    String assetName;

    public Asset() {
    }

    public Asset(int assetid, String assetName) {
        this.assetid = assetid;
        this.assetName = assetName;
    }

    public int getAssetid() {
        return assetid;
    }

    public void setAssetid(int assetid) {
        this.assetid = assetid;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
}
