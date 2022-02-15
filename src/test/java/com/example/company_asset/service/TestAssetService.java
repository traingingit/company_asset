package com.example.company_asset.service;

import com.example.company_asset.model.Asset;
import com.example.company_asset.repository.AssetRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestAssetService {
    @Autowired
    AssetService assetService;

    @MockBean
    AssetRepository assetRepository;


    @Test
    public void TestaddAssets()
    {
        Asset a= new Asset(1122,"stationary");
        when(assetRepository.save(a)).thenReturn(a);
        assertEquals("Assets added successfully",assetService.addAssets(a));
    }

    @Test
    public void TestgetAssets()
    {
        when(assetRepository.findAll()).thenReturn(Stream.of(new Asset(1234,"mock asset"),new Asset(4321,"asset mock")).collect(Collectors.toList()));
        assertEquals(2,assetService.getAssets().size());
    }

    @Test
    public void TestgetSingleAsset()
    {
        when(assetRepository.findById(9876)).thenReturn(Optional.of(new Asset(9876, "test asset")));
        assertEquals("test asset",assetService.getSingleAsset(9876).get().getAssetName());
    }

    @Test
    public void TestdeleteAssets()
    {

        assetService.deleteAssets(1122);
        verify(assetRepository,times(1)).deleteById(1122);

    }
}
