package com.sneakergo.controller;

import com.sneakergo.common.constants.PageConstant;
import com.sneakergo.common.constants.ParamConstant;
import com.sneakergo.common.constants.UtilsConstant;
import com.sneakergo.common.utils.FileUtils;
import com.sneakergo.common.utils.StringUtils;
import com.sneakergo.entity.*;
import com.sneakergo.service.interfaces.AttributeServiceInterface;
import com.sneakergo.service.interfaces.ProductServiceInterface;
import com.sneakergo.service.interfaces.SaleServiceInterface;
import com.sneakergo.service.interfaces.StockServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hung on 11/18/2016.
 */
@Controller
public class ProductController {
    @Value("${product.image.location}")
    String imagePath;

    @Autowired
    private ProductServiceInterface productServiceInterface;

    @Autowired
    private StockServiceInterface stockServiceInterface;

    @Autowired
    private AttributeServiceInterface attributeServiceInterface;

    @Autowired
    private SaleServiceInterface saleServiceInterface;

    @RequestMapping(value = PageConstant.PRODUCT_PAGE_URL, method = RequestMethod.GET)
    public ModelAndView initProductPage() {
        List<ProductEntity> listProduct = productServiceInterface.getAllProduct();
        ModelAndView modelAndView = new ModelAndView(PageConstant.PRODUCT_PAGE);
        modelAndView.addObject(ParamConstant.LIST_PRODUCT, listProduct);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.SEARCH_PRODUCT_URL, method = RequestMethod.POST)
    public List<ProductEntity> listSearchProducts(@RequestParam(value = ParamConstant.PRODUCT_NAME) String productName) {
        return productServiceInterface.getProductByName(productName);
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.ADD_PRODUCT_URL, method = RequestMethod.POST)
    public boolean createProduct(
            @RequestParam(value = ParamConstant.PICTURE, required = false) MultipartFile picture,
            @RequestParam(value = ParamConstant.PRODUCT_NAME) String productName,
            @RequestParam(value = ParamConstant.PRICE) String price,
            @RequestParam(value = ParamConstant.NATION) String nation,
            @RequestParam(value = ParamConstant.DESCRIPTION) String description) {
        try {
            ProductEntity productEntity = new ProductEntity();
            File imageDirectory = new File(imagePath);
            if (!imageDirectory.exists()) {
                imageDirectory.mkdirs();
            }

            if (!picture.isEmpty()) {
                String imageName = StringUtils.generateProductImageName() + StringUtils.getExtension(picture.getOriginalFilename());
                FileUtils.saveImageFile(picture, imageDirectory, imageName);
                productEntity.setPicture(imageName);
            }

            productEntity.setProductName(productName);
            productEntity.setPrice(price);
            productEntity.setNation(nation);
            productEntity.setDescription(description);
            productEntity.setEnabled(true);
            boolean result = productServiceInterface.addProduct(productEntity);

            //Create stock record with default size
            AttributeEntity attributeEntity = attributeServiceInterface.getAttributeBySize
                    (String.valueOf(UtilsConstant.ZERO));
            StockEntity stockEntity = new StockEntity();
            stockEntity.setAttributeId(attributeEntity.getAttributeId());
            stockEntity.setEnabled(true);
            stockEntity.setProductId(productEntity.getProductId());
            stockEntity.setQuantity(UtilsConstant.ZERO);
            stockServiceInterface.createStock(stockEntity);


            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.EDIT_PRODUCT_URL, method = RequestMethod.POST)
    public boolean editProduct(@RequestParam(value = ParamConstant.PRODUCT_ID) int productId,
                               @RequestParam(value = ParamConstant.PICTURE, required = false) MultipartFile picture,
                               @RequestParam(value = ParamConstant.PRODUCT_NAME) String productName,
                               @RequestParam(value = ParamConstant.PRICE) String price,
                               @RequestParam(value = ParamConstant.NATION) String nation,
                               @RequestParam(value = ParamConstant.DESCRIPTION) String description) {
        try {
            ProductEntity productEntity = productServiceInterface.getProductByID(productId);
            File imageDirectory = new File(imagePath);
            if (!imageDirectory.exists()) {
                imageDirectory.mkdirs();
            }

            if (!picture.isEmpty()) {
                String imageName = StringUtils.generateProductImageName() + StringUtils.getExtension(picture.getOriginalFilename());
                FileUtils.saveImageFile(picture, imageDirectory, imageName);
                productEntity.setPicture(imageName);
            }

            productEntity.setProductName(productName);
            productEntity.setPrice(price);
            productEntity.setNation(nation);
            productEntity.setDescription(description);
            productEntity.setEnabled(true);
            productServiceInterface.updateProduct(productEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.REMOVE_PRODUCT_URL, method = RequestMethod.POST)
    public boolean removeProduct(@RequestParam(value = ParamConstant.PRODUCT_ID) int productId) {

        ProductEntity productEntity = productServiceInterface.getProductByID(productId);

        if (productEntity != null) {
            productEntity.setEnabled(false);

            productServiceInterface.updateProduct(productEntity);
            new File(imagePath + productEntity.getPicture()).delete();
            AttributeEntity attributeEntity= attributeServiceInterface.getAttributeBySize(UtilsConstant.ZERO_STRING);
            StockEntity stockEntity=stockServiceInterface.getStockByProductIDAndAttributeID
                    (productEntity.getProductId(),attributeEntity.getAttributeId());
            stockEntity.setEnabled(false);
            stockServiceInterface.updateStockQuantity(stockEntity);
            return true;
        }

        return false;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_ALL_PRODUCT_URL, method = RequestMethod.GET)
    public List<ProductSellEntity> getAllProduct() {
        List<ProductEntity> listProduct = productServiceInterface.getAllProduct();

        for(ProductEntity entity: listProduct){
            System.out.println(entity.getProductId());
            AttributeEntity attributeEntity=attributeServiceInterface.getAttributeBySize(UtilsConstant.ZERO_STRING);
            StockEntity stockEntity=stockServiceInterface.
                    getStockByProductIDAndAttributeID(entity.getProductId(),attributeEntity.getAttributeId());
            if(stockEntity!=null&&stockEntity.getEnabled()){
                entity.setEnabled(false);
            }
        }

        List<ProductSellEntity> listSellProduct = new ArrayList<ProductSellEntity>();
        ProductSellEntity productSellEntity;
        for (ProductEntity entity : listProduct) {
            SaleEntity saleEntity = saleServiceInterface.getSaleByProductId(entity.getProductId());
            if(entity.getEnabled()){
                if (saleEntity == null) {
                    productSellEntity = new ProductSellEntity(entity, UtilsConstant.ZERO);
                } else {
                    productSellEntity = new ProductSellEntity(entity, saleEntity.getSalePercent());
                }
                listSellProduct.add(productSellEntity);
            }
        }
        return listSellProduct;
    }

    @ResponseBody
    @RequestMapping(value = PageConstant.GET_PRODUCT_SIZE, method = RequestMethod.POST)
    public List<String> getProductSize(@RequestParam(value = ParamConstant.PRODUCT_ID) int productId) {
        ProductEntity productEntity = productServiceInterface.getProductByID(productId);
        if (productEntity != null) {
            List<Integer> listOfAttId = stockServiceInterface.getSizeOfProduct(productEntity.getProductId());
            List<String> listOfSize = new ArrayList<String>();
            for (int i = UtilsConstant.ZERO; i < listOfAttId.size(); i++) {
                    listOfSize.add(attributeServiceInterface.getAttributeById(listOfAttId.get(i)).getSize());
            }
            return listOfSize;
        }
        return null;
    }
}
