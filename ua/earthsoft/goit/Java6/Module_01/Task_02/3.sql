/*общая сумма ЗП всех Java разработчиков, если они напишут все указанные проекты*/
Select
SUM(developers.salary) AS CostProject
from _customer_project
left join projects
on _customer_project.project = projects.id
left join _customerproject_developer
on _customer_project.id = _customerproject_developer.id
left join developers
on _customerproject_developer.developer = developers.id