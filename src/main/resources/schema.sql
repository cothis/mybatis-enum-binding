DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    od_no           varchar(30),
    customer_name   varchar(30),
    order_status    varchar(50),
    delivery_status varchar(30),
    PRIMARY KEY (od_no)
);