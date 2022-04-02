DROP TABLE IF EXISTS orders;
CREATE TABLE orders (
    od_no         varchar(30),
    customer_name varchar(30),
    order_status  int,
    PRIMARY KEY (od_no)
);