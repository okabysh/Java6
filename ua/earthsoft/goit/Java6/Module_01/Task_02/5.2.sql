/*Клиент который приносит меньше всего для компании "EarthSoft ODESSA"*/
select
customers.name AS customer, 
SUM(projects.cost) AS profit
from _company_customer
left join _customer_project
	on _company_customer.customer = _customer_project.customer
left join projects
	on _customer_project.project = projects.id
left join customers
	on _company_customer.customer = customers.id
where _company_customer.company = 2
group by customer
order by cost
limit 1
