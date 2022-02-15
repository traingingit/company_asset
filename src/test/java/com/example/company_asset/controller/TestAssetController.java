package com.example.company_asset.controller;

import com.example.company_asset.model.Asset;
import com.example.company_asset.repository.AssetRepository;
import com.example.company_asset.service.AssetService;
import org.junit.jupiter.api.*;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestAssetController {
    @Autowired
    AssetController assetController;

    @MockBean
    AssetRepository assetRepository;


    @Test
    @Order(1)
    public void TestaddAssets()
    {
        Asset a= new Asset(1122,"stationary");
        when(assetRepository.save(a)).thenReturn(a);
        assertEquals("Assets added successfully",assetController.addAssets(a));
    }

    @Test
    @Order(2)
    public void TestgetAssets()
    {
        when(assetRepository.findAll()).thenReturn(Stream.of(new Asset(1234,"mock asset"),new Asset(4321,"asset mock")).collect(Collectors.toList()));
        assertEquals(2,assetController.getAssets().size());
    }

    @Test
    @Order(3)
    public void TestgetSingleAsset()
    {
        when(assetRepository.findById(9876)).thenReturn(Optional.of(new Asset(9876, "test asset")));
        assertEquals("test asset",assetController.getSingleAsset(9876).get().getAssetName());
    }

    @Test
    @Order(4)
    public void TestdeleteAssets()
    {
        assetController.deleteAssets(1122);
        verify(assetRepository,times(1)).deleteById(1122);
    }
}
