# # Write your MySQL query statement below
# select p.product_id ,round((sum(price*units))/sum(units),2) as average_price
# from Prices p left join UnitsSold u
# on p.product_id=u.product_id and u.purchase_date between 
# p.start_date and p.end_date
# group by product_id

# Write your MySQL query statement below
SELECT p.product_id, ifnull(ROUND(SUM(units*price)/SUM(units),2),0) AS average_price
FROM Prices p LEFT JOIN UnitsSold u
ON p.product_id = u.product_id AND
u.purchase_date BETWEEN start_date AND end_date
group by product_id