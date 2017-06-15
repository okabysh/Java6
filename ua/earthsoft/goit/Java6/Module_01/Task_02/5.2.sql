/*Клиент который приносит меньше всего для компании "EarthSoft ODESSA"*/
select
customers.name AS customer, 
SUM(projects.cost) AS profit
from mtm_company_customer
left join mtm_customer_project
	on mtm_company_customer.customer = mtm_customer_project.customer
left join projects
	on mtm_customer_project.project = projects.id
left join customers
	on mtm_company_customer.customer = customers.id
where mtm_company_customer.company = 2
group by customer
order by cost
limit 1
