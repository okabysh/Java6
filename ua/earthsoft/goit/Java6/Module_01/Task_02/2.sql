/*самый дорогой проект исходя из ЗП разработчиков*/
Select
projects.name as project,
SUM(developers.salary) AS CostProject
from mtm_customer_project
left join projects
	on mtm_customer_project.project = projects.id 
left join mtm_customer_project_developer
	on mtm_customer_project.customer = mtm_customer_project_developer.customer
    AND mtm_customer_project.project = mtm_customer_project_developer.project 
left join developers
	on mtm_customer_project_developer.developer = developers.id
group by project
order by CostProject desc
limit 1