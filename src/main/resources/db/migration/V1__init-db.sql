CREATE TABLE product_data
(
    product_id          BIGINT        NOT NULL,
    product_title       VARCHAR(50)   NULL,
    product_price       DOUBLE        NULL,
    product_category    VARCHAR(20)   NULL,
    product_description VARCHAR(500)  NULL,
    image_url           VARCHAR(1024) NULL,
    CONSTRAINT pk_product_data PRIMARY KEY (product_id)
);