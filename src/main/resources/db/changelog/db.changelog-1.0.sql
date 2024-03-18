--liquibase formatted sql

CREATE TABLE IF NOT EXISTS address(
    id SERIAL PRIMARY KEY,
    country VARCHAR(32) NOT NULL,
    city VARCHAR(32) NOT NULL,
    street VARCHAR(32) NOT NULL,
    house VARCHAR(32) NOT NULL,
    postal_code VARCHAR(32) NOT NULL
);

--changeset moonrock:1
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(32) NOT NULL UNIQUE,
    password VARCHAR(128) NOT NULL,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    address INT REFERENCES address(id),
    telephone INT
);

--changeset moonrock:2
CREATE TABLE IF NOT EXISTS discount(
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    description TEXT NOT NULL,
    discount_percent DECIMAL NOT NULL
);

--changeset moonrock:3
CREATE TABLE IF NOT EXISTS payment_details(
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    amount DECIMAL NOT NULL,
    provider VARCHAR(64) NOT NULL,
    status VARCHAR(32) NOT NULL
);

--changeset moonrock:4
CREATE TABLE IF NOT EXISTS product(
    id SERIAL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    description TEXT NOT NULL,
    SKU VARCHAR(64) NOT NULL UNIQUE,
    category VARCHAR NOT NULL,
    price DECIMAL NOT NULL,
    discount_id INT NOT NULL REFERENCES discount(id)
);

--changeset moonrock:5
CREATE TABLE IF NOT EXISTS order_details (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    total DECIMAL,
    payment_id INT REFERENCES payment_details(id)
);

--changeset moonrock:6
CREATE TABLE IF NOT EXISTS order_items(
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL REFERENCES order_details(id),
    product_id INT NOT NULL REFERENCES product(id)
);

--changeset moonrock:7
CREATE TABLE IF NOT EXISTS shopping_session(
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    total DECIMAL
);

--changeset moonrock:8
CREATE TABLE IF NOT EXISTS cart_item(
    id SERIAL PRIMARY KEY,
    session_id INT REFERENCES shopping_session(id),
    product_id INT REFERENCES product(id),
    quantity INT
);



