// Copyright 2013 Structure Eng Inc.

package com.structureeng.persistence.dao.impl.product;

import com.structureeng.common.exception.ErrorCodeProperty;
import com.structureeng.common.exception.ErrorPropertyProvider;

/**
 * Defines the error codes for the entities related with a {@code ProductDefinition}.
 *
 * @author Edgar Rico (edgar.martinez.rico@gmail.com)
 */
public enum ProductErrorCode implements ErrorPropertyProvider {

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code ProductManufacturer} entity.
     */
    PRODUCT_MANUFACTURER_FK("dao.productManufacturer.foreignKey.productDefinition"),

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code ProductCategory} entity.
     */
    PRODUCT_CATEGORY_FK("dao.productCategory.foreignKey.productDefinition"),

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code ProductMeasureUnit} entity.
     */
    PRODUCT_MEASURE_UNIT_FK("dao.productMeasureUnit.foreignKey.retailProduct"),

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code ProductDefinition} entity.
     */
    PRODUCT_DEFFINITION_FK("dao.productDefinition.foreignKey.product"),

    /**
     * Property that specifies the error in case the unique key for the key attribute has been
     * violated.
     */
    PRODUCT_DEFFINITION_KEY_UK("dao.productDefinition.uniqueKey.key"),

    /**
     * Property that specifies the error in case the foreign key for retail products has been
     * violated for a {@code ProductPrice} entity.
     */
    PRODUCT_PRICES_FK("dao.product.foreignKey.productPrices"),

    /**
     * Property that specifies the error in case the unique key has been violated for a
     * {@code Product} entity.
     */
    PRODUCT_TYPE_UK("dao.product.uniqueKey.productType"),

    /**
     * Property that specifies the error in case the foreign key for stock has been violated for
     * a {@code Product} entity.
     */
    PRODUCT_FK_STOCK("dao.product.foreignKey.stock"),

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code ProductType} entity.
     */
    PRODUCT_TYPE_FK("dao.productType.foreignKey.product"),

    /**
     * Property that specifies the error in case the unique key for the key attribute has been
     * violated for a {@code PurchasePrice} entity.
     */
    PRODUCT_PURCHASE_PRICE_KEY_UK("dao.purchasePrice.uniqueKey"),

    /**
     * Property that specifies the error in case the unique key for the key attribute has been
     * violated for a {@code SalePrice} entity.
     */
    PRODUCT_SALE_PRICE_KEY_UK("dao.salePrice.uniqueKey"),

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code SalePrice} entity.
     */
    PRODUCT_SALE_PRICE_FK("dao.salePrice.foreignKey.saleDetail"),

    /**
     * Property that specifies the error in case the unique key for the key attribute has been
     * violated for a {@code Stocck} entity.
     */
    STOCK_UK("dao.stock.uniqueKey"),

    /**
     * Property that specifies the error in case the constraint has been violated for a
     * {@code Organization} entity.
     */
    STOCK_CONSTRAINT_ORGANIZATION("dao.stock.constraint.organization"),

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code Store} entity.
     */
    STORE_FK("dao.store.foreignKey"),

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code TaxType} entity.
     */
    TAX_TYPE_FK("dao.taxType.foreignKey.product"),

    /**
     * Property that specifies the error in case the foreign key has been violated for a
     * {@code Warehouse} entity.
     */
    WAREHOUSE_STOCK_FK("dao.warehouse.foreignKey.stock");

    private final ErrorCodeProperty errorCodeProperty;

    private ProductErrorCode(String property) {
        this.errorCodeProperty = new ErrorCodeProperty(property);
    }

    @Override
    public ErrorCodeProperty get() {
        return errorCodeProperty;
    }
}
