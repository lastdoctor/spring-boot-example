alter table customers
    add constraint customers_email_unique unique (email);