CREATE TABLE CURRENCY (
CurrencyId varchar(3) NOT NULL primary key,
CurrencyName varchar(20))

CREATE INDEX INDEX_CURRENCYID ON CURRENCY (CurrencyId)

INSERT INTO CURRENCY 
VALUES ('USD', '美金'), ('GBP', '英鎊'), ('EUR', '歐元')